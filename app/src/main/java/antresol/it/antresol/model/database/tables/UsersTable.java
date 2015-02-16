package antresol.it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class UsersTable implements ITable {

    public static final String USERS_TABLE_NAME = "Users";

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + USERS_TABLE_NAME + " (INTEGER PRIMARY KEY " + ITable._ID +
                ", TEXT " + ITable.LAST_NAME + ", TEXT " + ITable.FIRST_NAME + ", TEXT " + ITable.AVATAR + ")");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }
}
