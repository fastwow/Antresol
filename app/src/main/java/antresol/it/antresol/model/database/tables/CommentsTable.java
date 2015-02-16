package antresol.it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public class CommentsTable implements ITable {

    @Override
    public void create(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE COMMENTS (INTEGER PRIMARY KEY _ID, INTEGER USER_ID, INTEGER COMMENT_ID, INTEGER CREATE_AT, TEXT MESSAGE)");
    }

    @Override
    public void update(SQLiteDatabase db) {

    }

}
