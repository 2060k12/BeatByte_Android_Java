package com.ait12275.beatbyte;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ait12275.beatbyte.artists.Artists;
import com.ait12275.beatbyte.artists.ArtistsDAO;
import com.ait12275.beatbyte.users.Users;
import com.ait12275.beatbyte.users.UsersDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Users.class, Artists.class}, version = 1, exportSchema = false)
public abstract class BeatByteRoomDatabase extends RoomDatabase {

    // declare all DAO's
    public abstract UsersDAO usersDAO();
    public abstract  ArtistsDAO artistsDAO();

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
          usersDAO.insert(new Users("admin", "admin", "admin@admin.com"));

          ArtistsDAO artistsDAO = INSTANCE.artistsDAO();
          artistsDAO.insert(new Artists("a","a", "a","a","a","a","a","a","a"));
        });
    }

}
