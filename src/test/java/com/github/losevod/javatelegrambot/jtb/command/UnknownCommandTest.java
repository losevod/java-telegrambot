package com.github.losevod.javatelegrambot.jtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.losevod.javatelegrambot.jtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return "/ajsldkaslkdj";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }

}
