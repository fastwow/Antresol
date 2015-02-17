package it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class AdsTable implements ITable {

    public static final String TABLE_NAME = "Ads";

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (INTEGER PRIMARY KEY " + ITable._ID + ", TEXT " + ITable.TITLE + ", TEXT " + ITable.DESC + ", " +
                "INTEGER " + ITable.PRICE + ", INTEGER " + ITable.LAT + ", INTEGER " + ITable.LON + ", INTEGER " + ITable.CREATE_AT + ", INTEGER " + ITable.RANK + "," +
                " INTEGER " + ITable.CATEGORY_ID + ", INTEGER " + ITable.COUNTRY_ID + ", INTEGER " + ITable.LIKES_COUNT + "," +
                " INTEGER " + ITable.IS_DELETED + ", INTEGER " + ITable.IS_DEACTIVATED + ", INTEGER " + ITable.COMMENTS_COUNT + ")");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }
}