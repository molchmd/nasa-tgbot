package ru.molchmd.nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.molchmd.Settings;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class NasaHttpClientGetImage {
    private final CloseableHttpClient httpclient;
    private final ObjectMapper mapper;
    private final HttpGet getRequest;
    private CloseableHttpResponse getResponse;
    private NasaImageData image;

    public String getNasaImageName() {
        return image.getTitle();
    }

    private InputFile nasaPhoto;
    private final String GENERAL_API_NASA_URL = "https://api.nasa.gov/planetary/apod?thumbs=True&api_key=";
    public final String ERROR_URL =
            "https://www.funnyart.club/uploads/posts/2022-12/1671990510_www-funnyart-club-p-memi-s-kotom-vkontakte-17.jpg";
    public final InputFile ERROR_PHOTO;

    public NasaHttpClientGetImage() {
        httpclient = HttpClients.createDefault();
        mapper = new ObjectMapper();
        getRequest = new HttpGet();

        File error_photo = new File("src/main/resources/error.jpg");
        ERROR_PHOTO = new InputFile(error_photo);
    }

    public String getImageURL() {
        try {
            try {
                getRequest.setURI(new URI(GENERAL_API_NASA_URL + Settings.NASA_API_KEY));
            }
            catch (URISyntaxException e) {
                System.out.println("! Error: error setURI");
            }
            getResponse = httpclient.execute(getRequest);

            try {
                image = mapper.readValue(getResponse.getEntity().getContent(), NasaImageData.class);
                return image.getUrl();
            }
            finally {
                getResponse.close();
            }
        }
        catch (IOException e) {
            System.out.println("! Error: return a ERROR_URL");
            return ERROR_URL;
        }
    }
    public InputFile getPhoto() {
        try {
            getRequest.setURI(new URI(getImageURL()));
        }
        catch (URISyntaxException e) {
            System.out.println("! Error: error setURI");
        }

        try {
            getResponse = httpclient.execute(getRequest);
            InputStream inStream = getResponse.getEntity().getContent();
            nasaPhoto = new InputFile(inStream, "photo");
            return nasaPhoto;
        }
        catch (IOException e) {
            System.out.println("! Error: return ERROR_PHOTO");
            return ERROR_PHOTO;
        }
    }
}
