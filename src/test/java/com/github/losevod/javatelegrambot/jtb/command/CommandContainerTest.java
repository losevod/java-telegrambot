package com.github.losevod.javatelegrambot.jtb.command;

import com.github.losevod.javatelegrambot.jtb.service.SendBotMessageService;
import com.github.losevod.javatelegrambot.jtb.service.TelegramUserService;
import com.github.losevod.javatelegrambot.jtb.javarushclient.JavaRushGroupClient;
import com.github.losevod.javatelegrambot.jtb.service.GroupSubService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        GroupSubService groupSubService = Mockito.mock(GroupSubService.class);
        JavaRushGroupClient javaRushGroupClient = Mockito.mock(JavaRushGroupClient.class);
        commandContainer = new CommandContainer(sendBotMessageService,
                telegramUserService,
                javaRushGroupClient,
                groupSubService,
                Collections.singletonList("username"));
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName(), "username");
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/fgjshdfj";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand, "username");

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
