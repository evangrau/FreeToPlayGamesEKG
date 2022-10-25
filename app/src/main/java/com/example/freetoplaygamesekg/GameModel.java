package com.example.freetoplaygamesekg;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameModel implements Serializable {

    // All the stuff
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("status")
    private String status;
    @SerializedName("short_description")
    private String shortDescription;
    @SerializedName("description")
    private String description;
    @SerializedName("game_url")
    private String gameUrl;
    @SerializedName("genre")
    private String genre;
    @SerializedName("platform")
    private String platform;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("developer")
    private String developer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("freetogame_profile_url")
    private String freetogameProfileUrl;

    // Initializer
    public GameModel(final int id, final String title, final String thumbnail, final String status,
                     final String shortDescription, final String description, final String gameUrl,
                     final String genre, final String platform, final String publisher, final String developer,
                     final String releaseDate, final String freetogameProfileUrl) {
        setId(id);
        setTitle(title);
        setThumbnail(thumbnail);
        setStatus(status);
        setShortDescription(shortDescription);
        setDescription(description);
        setGameUrl(gameUrl);
        setGenre(genre);
        setPlatform(platform);
        setPublisher(publisher);
        setDeveloper(developer);
        setReleaseDate(releaseDate);
        setFreetogameProfileUrl(freetogameProfileUrl);
    }

    public String printGameModelDetails() {
//        if (publisher == "") {
//            publisher = "N/A";
//        }
        return "\nStatus: " + status + "\nGenre: " + genre + "\n\n" + description
                + "\n\nPlatform: " + platform + "\nDeveloper: " + developer + "\nRelease Date: " + releaseDate;
    }
}
