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
import com.ait12275.beatbyte.reviews.Reviews;
import com.ait12275.beatbyte.reviews.ReviewsDAO;
import com.ait12275.beatbyte.users.Users;
import com.ait12275.beatbyte.users.UsersDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Users.class, Artists.class, Albums.class, Reviews.class}, version =19, exportSchema = false)
public abstract class BeatByteRoomDatabase extends RoomDatabase {

    // declare all DAO's
    public abstract UsersDAO usersDAO();
    public abstract  ArtistsDAO artistsDAO();
    public abstract AlbumsDAO albumsDAO();
    public abstract ReviewsDAO reviewsDAO();

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
            usersDAO.insert(new Users("admin", "admin", "admin", "https://i.ebayimg.com/images/g/ACIAAOSwdnphKthz/s-l1600.png"));
            usersDAO.insert(new Users("pranish", "pranish", "1234", "https://static.wikia.nocookie.net/fairytail/images/c/ca/Natsu_X792.png/revision/latest?cb=20181111122101"));
            usersDAO.insert(new Users("user", "user", "user", "https://assets-prd.ignimgs.com/2022/08/17/top25animecharacters-blogroll-1660777571580.jpg"));
            usersDAO.insert(new Users("1", "1", "1", "https://miro.medium.com/v2/resize:fit:8384/1*_EDEWvWLREzlAvaQRfC_SQ.jpeg"));

          ArtistsDAO artistsDAO = INSTANCE.artistsDAO();
            artistsDAO.insert(new Artists("Queen", "Queen are a British rock band formed in London in 1970 by Freddie Mercury (lead vocals, piano), Brian May (guitar, vocals), and Roger Taylor (drums, vocals), later joined by John Deacon (bass). Their earliest works were influenced by progressive rock, hard rock, and heavy metal, but the band gradually ventured into more conventional and radio-friendly works by incorporating further styles, such as arena rock and pop rock.",
                    "London, England", "Rock", "...", "Freedy Mercury", "www.queen.com", "a", "https://faroutmagazine.co.uk/static/uploads/1/2023/08/Queen-Queen-II-Queen-2-Far-Out-Magazine-F-1140x855.jpg"));
            artistsDAO.insert(new Artists("The Beatles", "This is The Beatles", "London, England", "Rock", "...", "Freedy Mercury", "www.queen.com", "a", "https://i.scdn.co/image/ab6761610000e5ebe9348cc01ff5d55971b22433"));
            artistsDAO.insert(new Artists("Pranish", "Pranish ", "London, England", "Rock", "...", "Freedy Mercury", "www.queen.com", "a", "https://static.wikia.nocookie.net/fairytail/images/c/ca/Natsu_X792.png/revision/latest?cb=20181111122101"));

          ReviewsDAO reviewsDAO = INSTANCE.reviewsDAO();
            reviewsDAO.insert(new Reviews("This is one of the best album",1,"user",5));
            reviewsDAO.insert(new Reviews("Nice one Bro ",2,"admin",3));
            reviewsDAO.insert(new Reviews("Good on Ya mate",3,"admin",4));
            reviewsDAO.insert(new Reviews("Cool",1,"admin",5));
            reviewsDAO.insert(new Reviews("🔥🔥",2,"admin",4));

          AlbumsDAO albumsDAO = INSTANCE.albumsDAO();
            albumsDAO.insert(new Albums(1,"News of the world","Apple","40:00","apple","Georeg Martin","Abbey Road is the eleventh studio album by the English rock band the Beatles, released on 26 September 1969. It is the last album the group recorded,[2] although Let It Be was the last album completed before the band's break-up in April 1970.[3] It was mostly recorded in April, July, and August 1969, and topped the record charts in both the United States and the United Kingdom. A double A-side single from the album, \"Something\" / \"Come Together\", was released in October, which also topped the charts in the US",
                    "","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/The_Beatles_members_at_New_York_City_in_1964.jpg/220px-The_Beatles_members_at_New_York_City_in_1964.jpg"));
            albumsDAO.insert(new Albums(2,"Abbey Road","","","","","Abbey Road is the eleventh studio album by the English rock band the Beatles, released on 26 September 1969. It is the last album the group recorded,[2] although Let It Be was the last album completed before the band's break-up in April 1970.[3] It was mostly recorded in April, July, and August 1969, and topped the record charts in both the United States and the United Kingdom. A double A-side single from the album, \"Something\" / \"Come Together\", was released in October, which also topped the charts in the US",
                    "","https://www.billboard.com/wp-content/uploads/media/Beatlemania-abbey-road-exhibit-billboard-1548.jpg"));
            albumsDAO.insert(new Albums(3,"The Freewheelin'","","","","","","","https://faroutmagazine.co.uk/static/uploads/1/2020/05/Bob-Dylan-Freewheelin.jpg"));
            albumsDAO.insert(new Albums(2,"New Album'","","","","","THis is a trial album","","https://faroutmagazine.co.uk/static/uploads/1/2020/05/Bob-Dylan-Freewheelin.jpg"));
            albumsDAO.insert(new Albums(3,"The Freewheelin'","","","","","A album by Bob Dylan","","https://faroutmagazine.co.uk/static/uploads/1/2020/05/Bob-Dylan-Freewheelin.jpg"));


        });
    }

}
