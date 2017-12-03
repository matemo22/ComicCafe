package com.example.matemo.comiccafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Matemo on 12/2/2017.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "comic_cafe";

    private static final String TABLE_MANGA[] = new String[]{"manga","id","name","author","status","img_cover","description"};
    private static final String CREATE_TABLE_MANGA = "CREATE TABLE "+TABLE_MANGA[0]+" ("+TABLE_MANGA[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_MANGA[2]+" TEXT, "+TABLE_MANGA[3]+" TEXT, "+TABLE_MANGA[4]+" TEXT, "+TABLE_MANGA[5]+" TEXT, "+TABLE_MANGA[6]+" TEXT)";

    private static final String TABLE_GENRE[] = new String[]{"genre","id","name"};
    private static final String CREATE_TABLE_GENRE = "CREATE TABLE "+TABLE_GENRE[0]+" ("+TABLE_GENRE[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_GENRE[2]+" TEXT)";

    private static final String TABLE_MANGA_HAS_GENRE[] = new String[]{"manga_has_genre","id","id_manga","id_genre"};
    private static final String CREATE_TABLE_MANGA_HAS_GENRE = "CREATE TABLE "+TABLE_MANGA_HAS_GENRE[0]+" ("+TABLE_MANGA_HAS_GENRE[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_MANGA_HAS_GENRE[2]+" INTEGER, "+TABLE_MANGA_HAS_GENRE[3]+" INTEGER)";

    private static final String TABLE_MANGA_HAS_CHAPTER[] = new String[]{"manga_has_chapter","id","id_manga","title","number","status"};
    private static final String CREATE_TABLE_MANGA_HAS_CHAPTER = "CREATE TABLE "+TABLE_MANGA_HAS_CHAPTER[0]+" ("+TABLE_MANGA_HAS_CHAPTER[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_MANGA_HAS_CHAPTER[2]+" INTEGER, "+TABLE_MANGA_HAS_CHAPTER[3]+" TEXT, "+TABLE_MANGA_HAS_CHAPTER[4]+" INTEGER, "+TABLE_MANGA_HAS_CHAPTER[5]+" INTEGER NULL)";

    private static final String TABLE_CHAPTER_HAS_IMAGES[] = new String[]{"chapter_has_images","id","id_chapter","url"};
    private static final String CREATE_TABLE_CHAPTER_HAS_IMAGES = "CREATE TABLE "+TABLE_CHAPTER_HAS_IMAGES[0]+" ("+TABLE_CHAPTER_HAS_IMAGES[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_CHAPTER_HAS_IMAGES[2]+" INTEGER, "+TABLE_CHAPTER_HAS_IMAGES[3]+" TEXT)";

    private static final String TABLE_USER[] = new String[]{"user","id","username","password","email","img_profile"};
    private static final String CREATE_TABLE_USER = "CREATE TABLE "+TABLE_USER[0]+" ("+TABLE_USER[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_USER[2]+" VARCHAR(15), "+TABLE_USER[3]+" VARCHAR(15), "+TABLE_USER[4]+" TEXT, "+TABLE_USER[5]+" INTEGER)";

    private static final String TABLE_USER_FAVORITES_MANGA[] = new String[]{"user_favorites_manga","id","id_user","id_manga"};
    private static final String CREATE_TABLE_USER_FAVORITES_MANGA = "CREATE TABLE "+TABLE_USER_FAVORITES_MANGA[0]+" ("+TABLE_USER_FAVORITES_MANGA[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_USER_FAVORITES_MANGA[2]+" INTEGER, "+TABLE_USER_FAVORITES_MANGA[3]+" INTEGER)";

    private static final String TABLE_USER_LIKES_MANGA[] = new String[]{"user_likes_manga","id","id_user","id_manga"};
    private static final String CREATE_TABLE_USER_LIKES_MANGA = "CREATE TABLE "+TABLE_USER_LIKES_MANGA[0]+" ("+TABLE_USER_LIKES_MANGA[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_USER_LIKES_MANGA[2]+" INTEGER, "+TABLE_USER_LIKES_MANGA[3]+" INTEGER)";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MANGA);
        db.execSQL(CREATE_TABLE_GENRE);
        db.execSQL(CREATE_TABLE_MANGA_HAS_GENRE);
        db.execSQL(CREATE_TABLE_MANGA_HAS_CHAPTER);
        db.execSQL(CREATE_TABLE_CHAPTER_HAS_IMAGES);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_USER_FAVORITES_MANGA);
        db.execSQL(CREATE_TABLE_USER_LIKES_MANGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void cleanDB()
    {
        deleteAllUserLikesManga();
        deleteAllUserFavoritesManga();
        deleteAllUser();
        deleteAllChapterHasImages();
        deleteAllMangaHasChapter();
        deleteAllMangaHasGenre();
        deleteAllGenre();
        deleteAllManga();
    }

    public void addDB(ArrayList<Manga> mangas, ArrayList<Genre> genres, ArrayList<MangaHasGenre> mangaHasGenres, ArrayList<MangaHasChapter> mangaHasChapters,
                        ArrayList<ChapterHasImages> chapterHasImages, ArrayList<UserFavoritesManga> userFavoritesMangas, ArrayList<UserLikesManga> userLikesMangas)
    {
        addManga(mangas);
        addGenre(genres);
        addMangaHasGenre(mangaHasGenres);
        addMangaHasChapter(mangaHasChapters);
        addChapterHasImages(chapterHasImages);
        addUserFavoritesManga(userFavoritesMangas);
        addUserLikesManga(userLikesMangas);
    }

    //MANGA
    public void addManga(ArrayList<Manga>mangas)
    {
        for(Manga manga:mangas) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_MANGA[1], manga.getId());
            values.put(TABLE_MANGA[2], manga.getTitle());
            values.put(TABLE_MANGA[3], manga.getAuthor());
            values.put(TABLE_MANGA[4], manga.getStatus());
            values.put(TABLE_MANGA[5], manga.getImg_cover());
            values.put(TABLE_MANGA[6], manga.getDescription());
            db.insert(TABLE_MANGA[0], null, values);
            db.close();
        }
    }

    public void deleteAllManga()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MANGA[0], null, null);
        db.close();
    }

    public ArrayList<Manga> getAllManga()
    {
        ArrayList<UserFavoritesManga> userFavoritesMangas = getAllUserFavoritesManga();
        ArrayList<User> currentUser = getAllUser();
        ArrayList<Genre> genres = getAllGenre();
        ArrayList<MangaHasGenre> mangaHasGenres = getAllMangaHasGenre();
        ArrayList<MangaHasChapter> mangaHasChapters = getAllMangaHasChapter();
        ArrayList<ChapterHasImages> chapterHasImages = getAllChapterHasImages();
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Manga> allManga = new ArrayList<Manga>();
        try {
            String[] column = new String[]{TABLE_MANGA[1], TABLE_MANGA[2], TABLE_MANGA[3], TABLE_MANGA[4], TABLE_MANGA[5], TABLE_MANGA[6]};
            Cursor cursor = db.query(TABLE_MANGA[0], column, null, null, null, null, null);
            while (cursor.moveToNext()) {
                boolean found = false;
                int id = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA[1]));
                String name = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[2]));
                String author = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[3]));
                String status = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[4]));
                String img_cover = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[5]));
                String description = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[6]));
                if(currentUser.size()!=0)
                {
                    for (UserFavoritesManga a : userFavoritesMangas) {
                        if (currentUser.get(0).getId() == a.getId_user() && id == a.getId_manga()) {
                            found = true;
                            break;
                        }
                    }
                }
                ArrayList<String> tag = new ArrayList<String>();
                ArrayList<Chapter> chapters = new ArrayList<Chapter>();
                for (MangaHasGenre a:mangaHasGenres) {
                    if(id==a.getId_manga())
                    {
                        for (Genre b:genres)
                        {
                            if(a.getId_genre()==b.getId())
                            {
                                tag.add(b.getName());
                            }
                        }
                    }
                }
                for (MangaHasChapter a:mangaHasChapters)
                {
                    if(id==a.getId_manga())
                    {
                        Chapter chapter = new Chapter(a.getTitle(), a.getNum_chapter());
                        ArrayList<String> addImages = new ArrayList<String>();
                        for (ChapterHasImages b:chapterHasImages)
                        {
                            if(b.getId_chapter()==a.getId())
                            {
                                addImages.add(b.getUrl());
                            }
                        }
//                                                    Toast.makeText(SplashScreen.this, String.valueOf(addImages.size()), Toast.LENGTH_SHORT).show();
                        chapter.setUrlImg(addImages);
                        chapters.add(chapter);
                    }
                }
                Manga manga;
                if (found) manga = new Manga(id, name, author, status, description, 1, img_cover);
                else manga = new Manga(id, name, author, status, description, 0, img_cover);
                manga.setTag(tag);
                manga.setChapters(chapters);
                allManga.add(manga);
            }
            cursor.close();
        }
        finally {
            db.close();
        }
        return allManga;
    }
    //GENRE
    public void addGenre(ArrayList<Genre> genres)
    {
        for(Genre genre:genres) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_GENRE[1], genre.getId());
            values.put(TABLE_GENRE[2], genre.getName());
            db.insert(TABLE_GENRE[0], null, values);
            db.close();
        }
    }

    public void deleteAllGenre()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GENRE[0], null, null);
        db.close();
    }

    public ArrayList<Genre> getAllGenre()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_GENRE[1], TABLE_GENRE[2]};
        Cursor cursor = db.query(TABLE_GENRE[0], column, null, null, null, null, null);
        ArrayList<Genre> allGenre = new ArrayList<Genre>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_GENRE[1]));
            String name = cursor.getString(cursor.getColumnIndex(TABLE_GENRE[2]));
            Genre genre = new Genre(id, name);
            allGenre.add(genre);
        }
        cursor.close();
        db.close();
        return allGenre;
    }

    //MANGA_HAS_GENRE
    public void addMangaHasGenre(ArrayList<MangaHasGenre> mangaHasGenres)
    {
        for(MangaHasGenre mangaHasGenre : mangaHasGenres) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_MANGA_HAS_GENRE[1], mangaHasGenre.getId());
            values.put(TABLE_MANGA_HAS_GENRE[2], mangaHasGenre.getId_manga());
            values.put(TABLE_MANGA_HAS_GENRE[3], mangaHasGenre.getId_genre());
            db.insert(TABLE_MANGA_HAS_GENRE[0], null, values);
            db.close();
        }
    }

    public void deleteAllMangaHasGenre()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MANGA_HAS_GENRE[0], null, null);
        db.close();
    }

    public ArrayList<MangaHasGenre> getAllMangaHasGenre()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_MANGA_HAS_GENRE[1], TABLE_MANGA_HAS_GENRE[2], TABLE_MANGA_HAS_GENRE[3]};
        Cursor cursor = db.query(TABLE_MANGA_HAS_GENRE[0], column, null, null, null, null, null);
        ArrayList<MangaHasGenre> allMangaHasGenre = new ArrayList<MangaHasGenre>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_GENRE[1]));
            int id_manga = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_GENRE[2]));
            int id_genre = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_GENRE[3]));
            MangaHasGenre mangaHasGenre = new MangaHasGenre(id, id_manga, id_genre);
            allMangaHasGenre.add(mangaHasGenre);
        }
        cursor.close();
        db.close();
        return allMangaHasGenre;
    }

    //MANGA HAS CHAPTER
    public void addMangaHasChapter(ArrayList<MangaHasChapter> mangaHasChapters)
    {
        for(MangaHasChapter mangaHasChapter : mangaHasChapters) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_MANGA_HAS_CHAPTER[1], mangaHasChapter.getId());
            values.put(TABLE_MANGA_HAS_CHAPTER[2], mangaHasChapter.getId_manga());
            values.put(TABLE_MANGA_HAS_CHAPTER[3], mangaHasChapter.getTitle());
            values.put(TABLE_MANGA_HAS_CHAPTER[4], mangaHasChapter.getNum_chapter());
            db.insert(TABLE_MANGA_HAS_CHAPTER[0], null, values);
            db.close();
        }
    }

    public void updateChapterStatus(Chapter chapter, int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_MANGA_HAS_CHAPTER[5], chapter.getStatus());

        String whereFields = TABLE_MANGA_HAS_CHAPTER[1] + " = ?";
        String[] whereValues = {String.valueOf(id)};

        db.update(TABLE_MANGA_HAS_CHAPTER[0], values, whereFields, whereValues);
        db.close();
    }

    public void deleteAllMangaHasChapter()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MANGA_HAS_CHAPTER[0], null, null);
        db.close();
    }

    public ArrayList<MangaHasChapter> getAllMangaHasChapter()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_MANGA_HAS_CHAPTER[1], TABLE_MANGA_HAS_CHAPTER[2], TABLE_MANGA_HAS_CHAPTER[3], TABLE_MANGA_HAS_CHAPTER[4]};
        Cursor cursor = db.query(TABLE_MANGA_HAS_CHAPTER[0], column, null, null, null, null, null);
        ArrayList<MangaHasChapter> allMangaHasChapter = new ArrayList<MangaHasChapter>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_CHAPTER[1]));
            int id_manga = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_CHAPTER[2]));
            String title = cursor.getString(cursor.getColumnIndex(TABLE_MANGA_HAS_CHAPTER[3]));
            int num = cursor.getInt(cursor.getColumnIndex(TABLE_MANGA_HAS_CHAPTER[4]));
            MangaHasChapter mangaHasChapter = new MangaHasChapter(id, id_manga, num, title);
            allMangaHasChapter.add(mangaHasChapter);
        }
        cursor.close();
        db.close();
        return allMangaHasChapter;
    }

    //CHAPTER HAS IMAGES
    public void addChapterHasImages(ArrayList<ChapterHasImages> chapterHasImages)
    {
        for(ChapterHasImages chapterHasImage : chapterHasImages) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_CHAPTER_HAS_IMAGES[1], chapterHasImage.getId());
            values.put(TABLE_CHAPTER_HAS_IMAGES[2], chapterHasImage.getId_chapter());
            values.put(TABLE_CHAPTER_HAS_IMAGES[3], chapterHasImage.getUrl());
            db.insert(TABLE_CHAPTER_HAS_IMAGES[0], null, values);
            db.close();
        }
    }

    public void deleteAllChapterHasImages()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHAPTER_HAS_IMAGES[0], null, null);
        db.close();
    }

    public ArrayList<ChapterHasImages> getAllChapterHasImages()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_CHAPTER_HAS_IMAGES[1], TABLE_CHAPTER_HAS_IMAGES[2], TABLE_CHAPTER_HAS_IMAGES[3]};
        Cursor cursor = db.query(TABLE_CHAPTER_HAS_IMAGES[0], column, null, null, null, null, null);
        ArrayList<ChapterHasImages> allChapterHasImages = new ArrayList<ChapterHasImages>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_CHAPTER_HAS_IMAGES[1]));
            int id_chapter = cursor.getInt(cursor.getColumnIndex(TABLE_CHAPTER_HAS_IMAGES[2]));
            String url = cursor.getString(cursor.getColumnIndex(TABLE_CHAPTER_HAS_IMAGES[3]));
            ChapterHasImages chapterHasImages = new ChapterHasImages(id, id_chapter, url);
            allChapterHasImages.add(chapterHasImages);
        }
        cursor.close();
        db.close();
        return allChapterHasImages;
    }

    //USER
    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_USER[1], user.getId());
        values.put(TABLE_USER[2], user.getUsername());
        values.put(TABLE_USER[3], user.getPassword());
        values.put(TABLE_USER[4], user.getUserEmail());
        values.put(TABLE_USER[5], user.getProfileImage());
        db.insert(TABLE_USER[0], null, values);
        db.close();
    }

    public void deleteAllUser()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER[0], null, null);
        db.close();
    }

    public ArrayList<User> getAllUser()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_USER[1], TABLE_USER[2], TABLE_USER[3], TABLE_USER[4], TABLE_USER[5]};
        Cursor cursor = db.query(TABLE_USER[0], column, null, null, null, null, null);
        ArrayList<User> allUser = new ArrayList<User>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_USER[1]));
            String username = cursor.getString(cursor.getColumnIndex(TABLE_USER[2]));
            String password = cursor.getString(cursor.getColumnIndex(TABLE_USER[3]));
            String email = cursor.getString(cursor.getColumnIndex(TABLE_USER[4]));
            int img_profile = cursor.getInt(cursor.getColumnIndex(TABLE_USER[5]));
            User user = new User(id, username, password, email, img_profile);
            allUser.add(user);
        }
        cursor.close();
        db.close();
        return allUser;
    }

    //USER FAVORITES MANGA
    public void addUserFavoritesManga(ArrayList<UserFavoritesManga> userFavoritesMangas)
    {
        for (UserFavoritesManga userFavoritesManga : userFavoritesMangas) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_USER_FAVORITES_MANGA[1], userFavoritesManga.getId());
            values.put(TABLE_USER_FAVORITES_MANGA[2], userFavoritesManga.getId_user());
            values.put(TABLE_USER_FAVORITES_MANGA[3], userFavoritesManga.getId_manga());
            db.insert(TABLE_USER_FAVORITES_MANGA[0], null, values);
            db.close();
        }
    }

    public void deleteAllUserFavoritesManga()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_FAVORITES_MANGA[0], null, null);
        db.close();
    }

    public void deleteUserFavoritesManga(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereFields = TABLE_USER_FAVORITES_MANGA[1] + " = ?";
        String[] whereValues = {String.valueOf(id)};
        db.delete(TABLE_USER_FAVORITES_MANGA[0], whereFields, whereValues);
        db.close();
    }

    public ArrayList<UserFavoritesManga> getAllUserFavoritesManga()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_USER_FAVORITES_MANGA[1], TABLE_USER_FAVORITES_MANGA[2], TABLE_USER_FAVORITES_MANGA[3]};
        Cursor cursor = db.query(TABLE_USER_FAVORITES_MANGA[0], column, null, null, null, null, null);
        ArrayList<UserFavoritesManga> allUserFavoritesManga = new ArrayList<UserFavoritesManga>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_USER_FAVORITES_MANGA[1]));
            int id_user = cursor.getInt(cursor.getColumnIndex(TABLE_USER_FAVORITES_MANGA[2]));
            int id_manga = cursor.getInt(cursor.getColumnIndex(TABLE_USER_FAVORITES_MANGA[3]));
            UserFavoritesManga userFavoritesManga = new UserFavoritesManga(id, id_user, id_manga);
            allUserFavoritesManga.add(userFavoritesManga);
        }
        cursor.close();
        db.close();
        return allUserFavoritesManga;
    }

    //USER LIKES MANGA
    public void addUserLikesManga(ArrayList<UserLikesManga> userLikesMangas)
    {
        for(UserLikesManga userLikesManga : userLikesMangas) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TABLE_USER_LIKES_MANGA[1], userLikesManga.getId());
            values.put(TABLE_USER_LIKES_MANGA[2], userLikesManga.getId_user());
            values.put(TABLE_USER_LIKES_MANGA[3], userLikesManga.getId_manga());
            db.insert(TABLE_USER_LIKES_MANGA[0], null, values);
            db.close();
        }
    }

    public void deleteAllUserLikesManga()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_LIKES_MANGA[0], null, null);
        db.close();
    }

    public void deleteUserLikesManga(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereFields = TABLE_USER_LIKES_MANGA[1] + " = ?";
        String[] whereValues = {String.valueOf(id)};
        db.delete(TABLE_USER_LIKES_MANGA[0], whereFields, whereValues);
        db.close();
    }

    public ArrayList<UserLikesManga> getAllUserLikesManga()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_USER_LIKES_MANGA[1], TABLE_USER_LIKES_MANGA[2], TABLE_USER_LIKES_MANGA[3]};
        Cursor cursor = db.query(TABLE_USER_LIKES_MANGA[0], column, null, null, null, null, null);
        ArrayList<UserLikesManga> allUserLikesManga = new ArrayList<UserLikesManga>();
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_USER_LIKES_MANGA[1]));
            int id_user = cursor.getInt(cursor.getColumnIndex(TABLE_USER_LIKES_MANGA[2]));
            int id_manga = cursor.getInt(cursor.getColumnIndex(TABLE_USER_LIKES_MANGA[3]));
            UserLikesManga userLikesManga = new UserLikesManga(id, id_user, id_manga);
            allUserLikesManga.add(userLikesManga);
        }
        cursor.close();
        db.close();
        return allUserLikesManga;
    }
}
