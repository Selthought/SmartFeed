package by.mvcom.smartfeed.entity;

import java.util.ArrayList;

/**
 * Created by puma on 22.06.16.
 */
public class News {

    private int id;
    private String text;
    private long unixTimeOfCreate;
    private ArrayList<String> pictureUrls;
    private ArrayList<String> movieUrls;
    private ArrayList<String> audioUrls;
    private String avtorName;
    private String avtorPictureUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(ArrayList<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public ArrayList<String> getMovieUrls() {
        return movieUrls;
    }

    public void setMovieUrls(ArrayList<String> movieUrls) {
        this.movieUrls = movieUrls;
    }

    public long getUnixTimeOfCreate() {
        return unixTimeOfCreate;
    }

    public void setUnixTimeOfCreate(long unixTimeOfCreate) {
        this.unixTimeOfCreate = unixTimeOfCreate;
    }

    public ArrayList<String> getAudioUrls() {
        return audioUrls;
    }

    public void setAudioUrls(ArrayList<String> audioUrls) {
        this.audioUrls = audioUrls;
    }

    public String getAvtorName() {
        return avtorName;
    }

    public void setAvtorName(String avtorName) {
        this.avtorName = avtorName;
    }

    public String getAvtorPictureUrl() {
        return avtorPictureUrl;
    }

    public void setAvtorPictureUrl(String avtorPictureUrl) {
        this.avtorPictureUrl = avtorPictureUrl;
    }
}
