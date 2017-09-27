package soni.prince.android_apis.arrayadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper implements DatabaseConstants {

    public static final int DB_VERSION = 2;

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        getWritableDatabase();
    }

    private static void insertLanguage(SQLiteDatabase db, String language) {
        db.execSQL("INSERT INTO " + TABLE_LANG + " (" + COL_LANG_NAME + ") VALUES ('" + language + "');");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_LANG + "(" + COL_LANG_ID
                + " INTEGER PRIMARY KEY NOT NULL, " + " " + COL_LANG_NAME
                + " VARCHAR(50) NOT NULL);");

        insertLanguage(db, "Java");
        insertLanguage(db, "Perl");
        insertLanguage(db, "Python");
        insertLanguage(db, "Ruby");
        insertLanguage(db, "Scala");
        insertLanguage(db, "C");
        insertLanguage(db, "C++");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}