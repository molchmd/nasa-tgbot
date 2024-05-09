package ru.molchmd.nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import ru.molchmd.Settings;

import java.io.IOException;

public class NasaHttpClientGetImage {
    private final CloseableHttpClient httpclient;
    private final ObjectMapper mapper;
    private HttpGet getRequest;
    private CloseableHttpResponse getResponse;
    private NasaImageData image;
    private final String GENERAL_API_NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=";

    public NasaHttpClientGetImage() {
        httpclient = HttpClients.createDefault();
        mapper = new ObjectMapper();

        getRequest = new HttpGet(GENERAL_API_NASA_URL + Settings.NASA_API_KEY);
    }

    public String getImageURL() throws IOException {
        getResponse = httpclient.execute(getRequest);
        try {
            image = mapper.readValue(getResponse.getEntity().getContent(), NasaImageData.class);
            return image.getUrl();
        }
        finally {
            getResponse.close();
        }
    }
}
