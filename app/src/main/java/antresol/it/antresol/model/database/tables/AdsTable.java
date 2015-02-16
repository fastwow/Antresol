package antresol.it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class AdsTable implements ITable {

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE ADS (INTEGER PRIMARY KEY _ID, TEXT TITLE, TEXT DESC, " +
                "INTEGER PRICE, INTEGER LAT, INTEGER LON, INTEGER CREATE_AT, INTEGER RANK," +
                " INTEGER CATEGORY_ID, INTEGER COUNTRY_ID, INTEGER LIKES_COUNT," +
                " INTEGER IS_DELETED, INTEGER IS_DEACTIVATED, INTEGER COMMENTS_COUNT)");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }
}