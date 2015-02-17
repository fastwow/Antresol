package it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class CommentsTable implements ITable {

    public static final String TABLE_NAME = "Comments";

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (INTEGER PRIMARY KEY " + ITable._ID + ", INTEGER " +
             ITable.USER_ID + ", INTEGER " + ITable.COMMENT_ID + ", INTEGER " + ITable.CREATE_AT + ", TEXT " + ITable.MESSAGE + ")");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }

}
