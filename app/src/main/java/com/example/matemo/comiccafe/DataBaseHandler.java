package com.example.matemo.comiccafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    private static final String TABLE_MANGA_HAS_CHAPTER[] = new String[]{"manga_has_chapter","id","id_manga","title","number"};
    private static final String CREATE_TABLE_MANGA_HAS_CHAPTER = "CREATE TABLE "+TABLE_MANGA_HAS_CHAPTER[0]+" ("+TABLE_MANGA_HAS_CHAPTER[1]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_MANGA_HAS_CHAPTER[2]+" INTEGER, "+TABLE_MANGA_HAS_CHAPTER[3]+" TEXT, "+TABLE_MANGA_HAS_CHAPTER[4]+" INTEGER)";

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

    //MANGA
    public void addManga(Manga manga)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_MANGA[2], manga.getTitle());
        values.put(TABLE_MANGA[3], manga.getAuthor());
        values.put(TABLE_MANGA[4], manga.getStatus());
        values.put(TABLE_MANGA[5], manga.getImg_cover());
        values.put(TABLE_MANGA[6], manga.getDescription());
        db.insert(TABLE_MANGA[0], null, values);
        db.close();
    }

    public void updateManga(Manga manga)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_MANGA[2], manga.getTitle());
        values.put(TABLE_MANGA[3], manga.getTitle());
        values.put(TABLE_MANGA[4], manga.getTitle());
        values.put(TABLE_MANGA[5], manga.getTitle());
        values.put(TABLE_MANGA[6], manga.getTitle());

        String whereFields = TABLE_MANGA[2] + " = ?";
        String[] whereValues = {manga.getTitle()};

        db.update(TABLE_MANGA[0], values, whereFields, whereValues);
        db.close();
    }

    public void deleteAllManga()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MANGA[0], null, null);
        db.close();
    }

    public ArrayList<Manga> getAllManga()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{TABLE_MANGA[2], TABLE_MANGA[3], TABLE_MANGA[4], TABLE_MANGA[5], TABLE_MANGA[6]};
        Cursor cursor = db.query(TABLE_MANGA[0], column, null, null, null, null, null);
        ArrayList<Manga> allManga = new ArrayList<Manga>();
        while(cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[2]));
            String author = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[3]));
            String status = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[4]));
            String img_cover = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[5]));
            String description = cursor.getString(cursor.getColumnIndex(TABLE_MANGA[6]));
            Manga manga = new Manga(name, author, status, description, 0, img_cover);
            allManga.add(manga);
        }
        cursor.close();
        db.close();
        return allManga;
    }
    //GENRE
    public void addGenre(Genre genre)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_GENRE[1], genre.getId());
        values.put(TABLE_GENRE[2], genre.getName());
        db.insert(TABLE_GENRE[0], null, values);
        db.close();
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
    public void addMangaHasGenre(MangaHasGenre mangaHasGenre)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_MANGA_HAS_GENRE[1], mangaHasGenre.getId());
        values.put(TABLE_MANGA_HAS_GENRE[2], mangaHasGenre.getId_manga());
        values.put(TABLE_MANGA_HAS_GENRE[3], mangaHasGenre.getId_genre());
        db.insert(TABLE_MANGA_HAS_GENRE[0], null, values);
        db.close();
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
}
