package it.antresol.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.List;

import it.antresol.model.database.tables.AdsTable;
import it.antresol.model.database.tables.CommentsTable;
import it.antresol.model.database.tables.ITable;
import it.antresol.model.database.tables.UsersTable;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolSQLiteHelper extends SQLiteOpenHelper {

    private static final String ANTRESOL_DB_NAME = "antresol_db";
    private static final int ANTERSOL_DB_VERSION = 1;

    private List<ITable> mTableList = Arrays.asList(new AdsTable(), new CommentsTable(), new UsersTable());

    public AntresolSQLiteHelper(Context context) {

        super(context, ANTRESOL_DB_NAME, null, ANTERSOL_DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        for (ITable table : mTableList) {

            table.create(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        for (ITable table : mTableList) {

            table.update(db);
        }
    }
}