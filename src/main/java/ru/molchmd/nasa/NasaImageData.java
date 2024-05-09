package ru.molchmd.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
public class NasaImageData {
    String copyright;
    String date;
    String explanation;
    String hurl;
    String media_type;
    String service_version;
    String title;
    public String url;

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
}
