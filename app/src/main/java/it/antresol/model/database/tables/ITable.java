package it.antresol.model.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by artem on 2/16/15.
 */
public interface ITable {

    public static String _ID = "_id";
    public static String TITLE = "title";
    public static String DESC = "desc";
    public static String PRICE = "price";
    public static String LAT = "lat";
    public static String LON = "lon";
    public static String CREATE_AT = "create_at";
    public static String RANK = "rank";
    public static String CATEGORY_ID = "category_id";
    public static String COUNTRY_ID = "country_id";
    public static String LIKES_COUNT = "likes_count";
    public static String IS_DELETED = "is_deleted";
    public static String IS_DEACTIVATED = "is_deactivated";
    public static String COMMENTS_COUNT = "comments_count";
    public static String USER_ID = "user_id";
    public static String COMMENT_ID = "comment_id";
    public static String MESSAGE = "message";
    public static String LAST_NAME = "last_name";
    public static String FIRST_NAME = "first_name";
    public static String AVATAR = "avatar";
    public static String URL = "url";

    void create(SQLiteDatabase db);

    void update(SQLiteDatabase db);

}