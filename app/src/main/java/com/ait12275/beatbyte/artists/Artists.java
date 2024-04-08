package com.ait12275.beatbyte.artists;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ARTISTS")
public class Artists {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ARTIST_ID")
    int id;

    @ColumnInfo(name = "NAME")
    String name;
    @ColumnInfo(name = "ABOUT")
    String about;
    @ColumnInfo(name = "ORIGIN")

    String origin;
    @ColumnInfo(name = "GENRES")

    String genres;
    @ColumnInfo(name = "LABELS")

    String labels;
    @ColumnInfo(name = "MEMBERS")

    String members;
    @ColumnInfo(name = "WEBSITE")

    String website;
    @ColumnInfo(name = "ALBUMS")
//
//    String albums;
//    @ColumnInfo(name = "UPCOMING_EVENTS")

    String upComingEvents;

    @ColumnInfo(name = "ARTIST_IMG")
    String artistImg;


    public Artists(String name, String about, String origin, String genres, String labels, String members, String website, String upComingEvents, String artistImg) {
        this.name = name;
        this.about = about;
        this.origin = origin;
        this.genres = genres;
        this.labels = labels;
        this.members = members;
        this.website = website;
//        this.albums = albums;
        this.upComingEvents = upComingEvents;
        this.artistImg = artistImg;
    }

    @Ignore
    public Artists() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

//    public String getAlbums() {
//        return albums;
//    }
//
//    public void setAlbums(String albums) {
//        this.albums = albums;
//    }

    public String getUpComingEvents() {
        return upComingEvents;
    }

    public void setUpComingEvents(String upComingEvents) {
        this.upComingEvents = upComingEvents;
    }

    public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", origin='" + origin + '\'' +
                ", genres='" + genres + '\'' +
                ", labels='" + labels + '\'' +
                ", members='" + members + '\'' +
                ", website='" + website + '\'' +
                ", upComingEvents='" + upComingEvents + '\'' +
                ", artistImg='" + artistImg + '\'' +
                '}';
    }
}
