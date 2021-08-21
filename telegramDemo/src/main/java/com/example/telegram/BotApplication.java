package com.example.telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;


import java.util.logging.Level;

import java.util.logging.Logger;

public class BotApplication {
    private static Logger logger = Logger.getLogger(BotApplication.class.getName());

    public static void main(String[] args) {

        TelegramBot bot = new TelegramBot(""); //ВОТ СЮДА ВСТАВИТЬ BOT_ID
        logger.info("Я включился");
        // Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(update ->
                    new Thread(
                            () -> {
                                switch (messageType(update)) {
                                    case MESSAGE:
                                        invokeMessage(update, bot);
                                        break;
                                    case CHAT_MEMBER:
                                        invokeChatMember(update, bot);
                                        break;
                                    case CALLBACK_QUERY:
                                        invokeCallbackQuery(update, bot);
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + messageType(update));
                                }
                            }
                    ).start()
            );
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private static void invokeChatMember(Update update, TelegramBot bot) {
        bot.execute(new SendMessage(update.myChatMember().chat().id(), "TEXT"));
    }

    private static void invokeMessage(Update update, TelegramBot bot) {
        String variable = update.message().text();
        String userAnswer = "";
        try {
            if (variable.matches("\\d+[ ][+\\-*:][ ]\\d+")) {
                logger.info("Я считаю");
                String[] variables = variable.split("[ ]");
                switch (variables[1]) {
                    case "+" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) + Integer.valueOf(variables[2]));
                    case "-" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) - Integer.valueOf(variables[2]));
                    case "*" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) * Integer.valueOf(variables[2]));
                    case ":" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) / Integer.valueOf(variables[2]));
                    default -> userAnswer = "Операция не поддерживается";
                }
            } else {
                userAnswer = "Неправильный формат сообщения";
            }
        } catch (NumberFormatException ex) {
            userAnswer = ex.getMessage();
            logger.log(Level.WARNING, ex.getMessage());
        }
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[]{
                        new InlineKeyboardButton("*2").callbackData("multiply:" + userAnswer),
                        new InlineKeyboardButton("/2").callbackData("division:" + userAnswer)
                });
        bot.execute(new SendMessage(update.message().chat().id(), userAnswer).replyMarkup(inlineKeyboard));
    }

    private static void invokeCallbackQuery(Update update, TelegramBot bot) {
        CallbackQuery callback = update.callbackQuery();
        int value = Integer.valueOf(callback.data().split(":")[1]);
        switch (callback.data().split(":")[0]) {
            case "division" -> value /= 2;
            case "multiply" -> value *= 2;
        }
        bot.execute(new SendMessage(update.callbackQuery().from().id(), update.callbackQuery().data()));
    }

    private static MessageType messageType(Update update) {
        if (update.message() != null) return MessageType.MESSAGE;
        if (update.myChatMember() != null) return MessageType.CHAT_MEMBER;
        if (update.callbackQuery() != null) return MessageType.CALLBACK_QUERY;
        return MessageType.UNSUPPORTED;
    }

}
