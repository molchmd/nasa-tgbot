package ru.molchmd.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.molchmd.nasa.NasaHttpClientGetImage;

import java.util.Locale;

public class NasaTGBot extends TelegramLongPollingBot {
    private final String NAME;
    private final String TOKEN;
    private final NasaHttpClientGetImage nasaApi;

    public NasaTGBot(String name, String token) throws TelegramApiException {
        NAME = name;
        TOKEN = token;
        nasaApi = new NasaHttpClientGetImage();

        TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
        botApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String userText = update.getMessage().getText().toLowerCase();

            SendMessage botText = new SendMessage();
            botText.setChatId(chatId);
            if (!("картинка".equals(userText))) {
                botText.setText("Я вас не понимаю!\n" + nasaApi.ERROR_URL);
            }
            else {
                botText.setText(nasaApi.getImageURL());
            }

            try {
                execute(botText);
            } catch (TelegramApiException e) {
                System.out.println("Error!");
            }
        }
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
