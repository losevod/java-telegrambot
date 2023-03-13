package com.github.losevod.javatelegrambot.jtb.bot;

import com.github.losevod.javatelegrambot.jtb.command.CommandContainer;
import com.github.losevod.javatelegrambot.jtb.javarushclient.JavaRushGroupClient;
import com.github.losevod.javatelegrambot.jtb.javarushclient.dto.LikeStatus;
import com.github.losevod.javatelegrambot.jtb.service.GroupSubService;
import com.github.losevod.javatelegrambot.jtb.service.SendBotMessageServiceImpl;
import com.github.losevod.javatelegrambot.jtb.service.TelegramUserService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Locale;

import static com.github.losevod.javatelegrambot.jtb.command.CommandName.NO;

@Component
public class JavaTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    private final CommandContainer commandContainer;
    public JavaTelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient groupClient, GroupSubService groupSubService, @Value("#{'${bot.admins}'.split(',')}")List<String> admins) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService, groupClient, groupSubService, admins);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier, username).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName(), username).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
