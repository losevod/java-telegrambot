package com.github.losevod.javatelegrambot.jtb.command;

import com.github.losevod.javatelegrambot.jtb.repository.entity.GroupSub;
import com.github.losevod.javatelegrambot.jtb.repository.entity.TelegramUser;
import com.github.losevod.javatelegrambot.jtb.service.SendBotMessageService;
import com.github.losevod.javatelegrambot.jtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.ws.rs.NotFoundException;

import java.util.stream.Collectors;

import static com.github.losevod.javatelegrambot.jtb.command.CommandUtils.getChatId;

/**
 *  {@link Command} for getting list of {@link GroupSub}.
 */
public class ListGroupSubCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public ListGroupSubCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        //TODO add exception handling
        TelegramUser telegramUser = telegramUserService.findByChatId(String.valueOf(getChatId(update)))
                .orElseThrow(NotFoundException::new);

        String message = "Я нашел все подписки на группы: \n\n";
        String collectedGroups = telegramUser.getGroupSubs().stream()
                .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                .collect(Collectors.joining());

        sendBotMessageService.sendMessage(telegramUser.getChatId(), message + collectedGroups);
    }

}
