package ru.molchmd.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
public class NasaImageData {
    private String copyright;
    private String date;
    private String explanation;
    private String hurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public NasaImageData(@JsonProperty("copyright") String copyright,
                     @JsonProperty("date") String date,
                     @JsonProperty("explanation") String explanation,
                     @JsonProperty("hdurl") String hurl,
                     @JsonProperty("media_type") String media_type,
                     @JsonProperty("service_version") String service_version,
                     @JsonProperty("title") String title,
                     @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hurl = hurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }
    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHurl() {
        return hurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
