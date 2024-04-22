package com.raj.sqlitedemo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "demo_db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, pass TEXT, gender TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS register");
        onCreate(db);
    }

    public void registerUserHelper(String name1, String email1, String pass1, String gender1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

//        insert() multiple "values" leta hai,
//        so array use krna padega but android provide something better than array, i.e ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name1); // columnName and value
        contentValues.put("email", email1);
        contentValues.put("pass", pass1);
        contentValues.put("gender", gender1);

        sqLiteDatabase.insert("register", null, contentValues);
        sqLiteDatabase.close();

    }
}
