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

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "comic_cafe";

    private static final String TABLE_MANGA[] = new String[]{"manga","id","name","author","status","img_cover","description"};
    private static final String CREATE_TABLE_MANGA = "CREATE TABLE "+TABLE_MANGA[0]+" ("+TABLE_MANGA[1]+" INTEGER PRIMARY KEY, "+TABLE_MANGA[2]+" TEXT, "+TABLE_MANGA[3]+" TEXT, "+TABLE_MANGA[4]+" TEXT, "+TABLE_MANGA[5]+" TEXT, "+TABLE_MANGA[6]+" TEXT)";

    private static final String TABLE_GENRE[] = new String[]{"genre","id","name"};
    private static final String CREATE_TABLE_GENRE = "CREATE TABLE "+TABLE_GENRE[0]+" ("+TABLE_GENRE[1]+" INTEGER PRIMARY KEY, "+TABLE_GENRE[2]+" TEXT)";

//    private static final String TABLE_CONTACT = "manga";
//    private static final String FIELD_ID = "id";
//    private static final String FIELD_NAME = "name";
//    private static final String FIELD_PHONE = "phone";
//
//    private static final String CREATE_TABLE_CONTACT = "CREATE TABLE "+TABLE_CONTACT+" ("+FIELD_ID+" INTEGER PRIMARY KEY, "+FIELD_NAME+" VARCHAR(50), "+FIELD_PHONE+" VARCHAR(20))";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MANGA);
        db.execSQL(CREATE_TABLE_GENRE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addContact(Contact newContact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, newContact.getName());
        values.put(FIELD_PHONE, newContact.getPhone());
        db.insert(TABLE_CONTACT, null, values);
        db.close();
    }

    public ArrayList<Contact> getAllContact()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = {FIELD_ID, FIELD_NAME, FIELD_PHONE};
        Cursor cursor = db.query(TABLE_CONTACT, column, null, null, null, null, null);
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        while(cursor.moveToNext())
        {
            Contact contact = new Contact();
            contact.setId(cursor.getInt(cursor.getColumnIndex(FIELD_ID)));
            contact.setName(cursor.getString(cursor.getColumnIndex(FIELD_NAME)));
            contact.setPhone(cursor.getString(cursor.getColumnIndex(FIELD_PHONE)));
            contactList.add(contact);
        }
        cursor.close();
        db.close();
        return contactList;
    }

    public void updateContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, contact.getName());
        values.put(FIELD_PHONE, contact.getPhone());

        String whereFields = FIELD_ID + " = ?";
        String[] whereValues = {String.valueOf(contact.getId())};

        db.update(TABLE_CONTACT, values, whereFields, whereValues);
        db.close();
    }

    public void deleteContact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereField = FIELD_ID + " = ?";
        String[] whereValues = {String.valueOf(id)};
        db.delete(TABLE_CONTACT, whereField, whereValues);
        db.close();
    }
}
