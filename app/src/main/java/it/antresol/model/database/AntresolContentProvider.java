package it.antresol.model.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import it.antresol.model.database.tables.AdsTable;
import it.antresol.model.database.tables.ITable;
import it.antresol.model.database.tables.UsersTable;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolContentProvider extends ContentProvider {

    // AUTHORITY OF CONTENT PROVIDER
    private static final String AUTHORITY = "it.antresol.contentprovider";

    // USERS TALBE
    private static final String USERS_PATH = "users";
    public static final Uri USERS_CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + USERS_PATH);
    private static final int USERS = 100;
    private static final int USER_ID = 101;

    // ADS TABLE
    private static final String ADS_PATH = "ads";
    public static final Uri ADS_CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + ADS_PATH);
    private static final int ADS = 102;
    private static final int AD_ID = 103;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // DATABASE
    private AntresolSQLiteHelper mDatabase;

    // INIT URIMATCHER
    static {

        // USERS
        sURIMatcher.addURI(AUTHORITY, USERS_PATH, USERS);
        sURIMatcher.addURI(AUTHORITY, USERS_PATH + "/#", USER_ID);

        // ADS
        sURIMatcher.addURI(AUTHORITY, ADS_PATH, AD_ID);
        sURIMatcher.addURI(AUTHORITY, ADS_PATH + "/#", ADS);
    }

    @Override
    public boolean onCreate() {

        mDatabase = new AntresolSQLiteHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        // Uisng SQLiteQueryBuilder instead of query() method
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        int uriType = sURIMatcher.match(uri);

        switch (uriType) {

            case ADS:

                queryBuilder.setTables(AdsTable.TABLE_NAME);
                break;
            case USERS:

                queryBuilder.setTables(UsersTable.TABLE_NAME);
                break;
            case USER_ID:
            case AD_ID:
                // adding the ID to the original query
                queryBuilder.appendWhere(ITable._ID + "="
                        + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        SQLiteDatabase db = mDatabase.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        // make sure that potential listeners are getting notified
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {

        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = mDatabase.getWritableDatabase();
        int rowsDeleted = 0;
        long id = 0;

        String path = "";
        String tableName = "";
        switch (uriType) {

            case USER_ID:

                path = USERS_PATH;
                tableName = UsersTable.TABLE_NAME;
                break;

            case AD_ID:

                path = ADS_PATH;
                tableName = AdsTable.TABLE_NAME;
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        id = sqlDB.insert(tableName, null, values);
        getContext().getContentResolver().notifyChange(uri, null);

        return Uri.parse(path + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = mDatabase.getWritableDatabase();
        int rowsDeleted = 0;
        switch (uriType) {

            case USERS:

                rowsDeleted = sqlDB.delete(UsersTable.TABLE_NAME, selection,
                        selectionArgs);
                break;
            case USER_ID:

                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {

                    rowsDeleted = sqlDB.delete(UsersTable.TABLE_NAME,
                            UsersTable._ID + "=" + id,
                            null);
                } else {

                    rowsDeleted = sqlDB.delete(UsersTable.TABLE_NAME,
                            UsersTable._ID + "=" + id
                                    + " and " + selection,
                            selectionArgs);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);

        SQLiteDatabase sqlDB = mDatabase.getWritableDatabase();
        int rowsUpdated = 0;
        switch (uriType) {

            case USERS:
                rowsUpdated = sqlDB.update(UsersTable.TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);
                break;
            case USER_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {

                    rowsUpdated = sqlDB.update(UsersTable.TABLE_NAME,
                            values,
                            ITable._ID + "=" + id,
                            null);
                } else {

                    rowsUpdated = sqlDB.update(UsersTable.TABLE_NAME,
                            values,
                            ITable._ID + "=" + id
                                    + " and "
                                    + selection,
                            selectionArgs);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return rowsUpdated;
    }
}
