package it.antresol.model;

import android.content.ContentValues;
import android.util.Log;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;

import it.antresol.R;

/**
 * Created by artem on 2/16/15.
 */
public class BaseModel {

    public ContentValues objectToContentValues() throws IllegalAccessException {

        ContentValues cv = new ContentValues();

        for (Field field : getClass().getFields()) {

            Object value = field.get(this);

            if (value instanceof Double || value instanceof Integer || value instanceof R.string || value instanceof Boolean
                    || value instanceof Long || value instanceof Float || value instanceof Short) {

                cv.put(field.getName(), value.toString());
                Log.d("CVLOOP", field.getName() + ":" + value.toString());
            } else if (value instanceof Date) {

                cv.put(field.getName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value));
            }
        }

        return cv;
    }
}
