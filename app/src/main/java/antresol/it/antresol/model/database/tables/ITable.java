package antresol.it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public interface ITable {

    void create(SQLiteDatabase db);

    void update(SQLiteDatabase db);

}