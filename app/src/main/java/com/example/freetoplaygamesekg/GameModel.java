package com.example.freetoplaygamesekg;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameModel {
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
    @SerializedName("minimum_system_requirements")
    private MinimumSystemRequirements minimumSystemRequirements;
    @SerializedName("screenshots")
    private List<Screenshot> screenshots = null;

    public GameModel(final int id, final String title, final String thumbnail, final String status,
                     final String shortDescription, final String description, final String gameUrl,
                     final String genre, final String platform, final String publisher, final String developer,
                     final String releaseDate, final String freetogameProfileUrl,
                     final MinimumSystemRequirements minimumSystemRequirements, final List<Screenshot> screenshots) {
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
        setMinimumSystemRequirements(minimumSystemRequirements);
        setScreenshots(screenshots);
    }
}
