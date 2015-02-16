package antresol.it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class UsersTable implements ITable {

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USERS (INTEGER PRIMARY KEY _ID, TEXT LAST_NAME, TEXT FIRST_NAME, TEXT AVATAR)");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }
}
