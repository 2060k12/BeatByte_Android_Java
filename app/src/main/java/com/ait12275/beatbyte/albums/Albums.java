package com.ait12275.beatbyte.albums;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.ait12275.beatbyte.artists.Artists;

import java.io.Serializable;


// Creating a table with name "ALBUMS" and also adding a foreign Key " ARTIST_ID" from the table "ARTISTS"
// adding CASCADE to the foreign key, so that the table gets deleted automatically when the artist is deleted for its table.
@Entity(tableName = "ALBUMS", foreignKeys = @ForeignKey(entity = Artists.class, parentColumns = "ARTIST_ID", childColumns = "ARTIST_ID", onDelete = ForeignKey.CASCADE) )
public class Albums implements Serializable {

    // id is a primary key for this table, and is set to autogenerate, so that we don't need to set it manually
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ALBUM_ID")
    int id;

    // ARTIST_Id is a foreign key from Artist table.
    @ColumnInfo(name = "ARTIST_ID")
    int artistId;
    @ColumnInfo(name = "NAME")
    String name;
    @ColumnInfo(name = "RECORDED_STUDIO")
    String recordedStudio;
    @ColumnInfo(name = "LENGTH")
    String length;
    @ColumnInfo(name = "LABELS")
    String labels;
    @ColumnInfo(name = "PRODUCERS")
    String producers;
    @ColumnInfo(name = "ABOUT")
    String about;
    @ColumnInfo(name = "TRACKS")
    String tracks;

    @ColumnInfo(name = "ALBUM_ART")
    String albumArt;


    // Constructor
    @Ignore
    public Albums() {
    }


    public Albums(int artistId, String name, String recordedStudio, String length, String labels, String producers, String about, String tracks, String albumArt) {
        this.artistId = artistId;
        this.name = name;
        this.recordedStudio = recordedStudio;
        this.length = length;
        this.labels = labels;
        this.producers = producers;
        this.about = about;
        this.tracks = tracks;
        this.albumArt = albumArt;
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordedStudio() {
        return recordedStudio;
    }

    public void setRecordedStudio(String recordedStudio) {
        this.recordedStudio = recordedStudio;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", name='" + name + '\'' +
                ", recordedStudio='" + recordedStudio + '\'' +
                ", length='" + length + '\'' +
                ", labels='" + labels + '\'' +
                ", producers='" + producers + '\'' +
                ", about='" + about + '\'' +
                ", tracks='" + tracks + '\'' +
                ", albumArt='" + albumArt + '\'' +
                '}';
    }
}
