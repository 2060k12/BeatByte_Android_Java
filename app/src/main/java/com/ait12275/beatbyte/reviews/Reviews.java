package com.ait12275.beatbyte.reviews;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "REVIEWS_TABLE")
public class Reviews {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    int id;
    @ColumnInfo(name = "COMMENT")

    String comment;
    @ColumnInfo(name = "ALBUM_ID")

    int albumId;
    @ColumnInfo(name = "USER_ID")

    String userID;
    @ColumnInfo(name = "RATING")

    float rating ;

    @Ignore
    public Reviews() {
    }

    public Reviews(String comment, int albumId, String userID, float rating) {
        this.comment = comment;
        this.albumId = albumId;
        this.userID = userID;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", albumId=" + albumId +
                ", userID=" + userID +
                ", rating=" + rating +
                '}';
    }
}
