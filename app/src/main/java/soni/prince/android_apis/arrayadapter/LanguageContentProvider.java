package soni.prince.android_apis.arrayadapter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class LanguageContentProvider extends ContentProvider {
    private static final String AUTHORITY = "custom.content_provider.LanguageContentProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DatabaseConstants.TABLE_LANG);
    private SQLiteHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new SQLiteHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DatabaseConstants.TABLE_LANG);
        String orderBy = DatabaseConstants.COL_LANG_NAME + " asc";
        Cursor cursor = qb.query(dbHelper.getReadableDatabase(),
                new String[]{DatabaseConstants.COL_LANG_ID,
                        DatabaseConstants.COL_LANG_NAME}, null,
                null, null, null, orderBy);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.custom.content_provider.LanguageContentProvider";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}