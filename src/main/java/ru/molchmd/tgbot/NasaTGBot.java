package ru.molchmd.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.molchmd.Settings;

public class NasaTGBot extends TelegramLongPollingBot {
    private final String NAME;
    private final String TOKEN;

    public NasaTGBot(String name, String token) throws TelegramApiException {
        NAME = name;
        TOKEN = token;

        TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
        botApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // to do
    }
    @Override
    public String getBotUsername() {
        return NAME;
    }
    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
