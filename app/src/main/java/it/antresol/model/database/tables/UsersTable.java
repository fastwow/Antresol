package it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class UsersTable implements ITable {

    public static final String TABLE_NAME = "Users";

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + ITable._ID + " INTEGER PRIMARY KEY, "
                + ITable.LAST_NAME + " TEXT, " + ITable.FIRST_NAME + " TEXT, " + ITable.AVATAR + " TEXT )");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }
}
