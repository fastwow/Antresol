package antresol.it.antresol.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.List;

import antresol.it.antresol.model.database.tables.AdsTable;
import antresol.it.antresol.model.database.tables.CommentsTable;
import antresol.it.antresol.model.database.tables.ITable;
import antresol.it.antresol.model.database.tables.UsersTable;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolSQLiteHelper extends SQLiteOpenHelper {

    private List<ITable> mTableList = Arrays.asList(new AdsTable(), new CommentsTable(), new UsersTable());

    public AntresolSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


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