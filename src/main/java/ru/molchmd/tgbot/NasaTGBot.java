package ru.molchmd.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
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

            if ("/start".equals(userText) || "/help".equals(userText)) {
                SendMessage botText = new SendMessage();
                botText.setChatId(chatId);

                if ("/start".equals(userText))
                    botText.setText(
                            "Привет! Я бот, который может присылать картинку дня из NASA!\n" +
                                    "Напиши \"Картинка\" и я пришлю ее!\n" +
                                    "Или напиши \"/help\".\n"
                    );
                else
                    botText.setText(
                            "Я бот, который может присылать картинку дня из NASA!\n" +
                                    "Напиши \"Картинка\" и я пришлю ее!\n" +
                                    "Я понимаю только команды:\n- /start\n- /help\n- картинка"
                    );
                try {
                    execute(botText);
                    System.out.println("Send a text to [" + chatId +"]");
                } catch (TelegramApiException e) {
                    System.out.println("Error text!");
                }
                return;
            }

            SendPhoto botPhoto = new SendPhoto();
            botPhoto.setChatId(chatId);

            if (!("картинка".equals(userText))) {
                botPhoto.setCaption("Я вас не понимаю!");
                botPhoto.setPhoto(nasaApi.ERROR_PHOTO);
                System.out.println("[" + chatId + " write a word is not equal картинка");
            }
            else {
                botPhoto.setPhoto(nasaApi.getPhoto());
                botPhoto.setCaption(nasaApi.getNasaImageName());
                System.out.println("[" + chatId + "] write a word is equal картинка");
            }

            try {
                execute(botPhoto);
                System.out.println("Send a photo to [" + chatId +"]");
            } catch (TelegramApiException e) {
                System.out.println("Error photo!");
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
