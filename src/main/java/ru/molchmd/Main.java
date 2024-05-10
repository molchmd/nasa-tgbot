package ru.molchmd;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.molchmd.tgbot.NasaTGBot;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        NasaTGBot tgbot = new NasaTGBot(Settings.BOT_NAME, Settings.TG_TOKEN);
    }
}