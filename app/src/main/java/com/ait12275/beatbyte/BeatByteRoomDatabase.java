package com.ait12275.beatbyte;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.albums.AlbumsDAO;
import com.ait12275.beatbyte.artists.Artists;
import com.ait12275.beatbyte.artists.ArtistsDAO;
import com.ait12275.beatbyte.users.Users;
import com.ait12275.beatbyte.users.UsersDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Users.class, Artists.class, Albums.class}, version =11, exportSchema = false)
public abstract class BeatByteRoomDatabase extends RoomDatabase {

    // declare all DAO's
    public abstract UsersDAO usersDAO();
    public abstract  ArtistsDAO artistsDAO();
    public abstract AlbumsDAO albumsDAO();

    private static final int NUMBERS_OF_THREADS =4;

    // creating an instance of our Database
    private static volatile BeatByteRoomDatabase INSTANCE;
    public  static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBERS_OF_THREADS);


    public static BeatByteRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (BeatByteRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BeatByteRoomDatabase.class, "beatbyte_db")
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            populateInitialData(INSTANCE);
            }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

        }
    };

    private static void populateInitialData (BeatByteRoomDatabase instance){

    BeatByteRoomDatabase.databaseWriteExecutor.execute(
        () -> {
          UsersDAO usersDAO = INSTANCE.usersDAO();
          usersDAO.insert(new Users("admin", "admin", "admin"));

          ArtistsDAO artistsDAO = INSTANCE.artistsDAO();
          artistsDAO.insert(new Artists("Queen", "This is queen", "London, England", "Rock", "...", "Freedy Mercury", "www.queen.com", "a", ""));

          AlbumsDAO albumsDAO = INSTANCE.albumsDAO();
            albumsDAO.insert(new Albums(1,"News of the world","","","","","","","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/The_Beatles_members_at_New_York_City_in_1964.jpg/220px-The_Beatles_members_at_New_York_City_in_1964.jpg"));

        });
    }

}
