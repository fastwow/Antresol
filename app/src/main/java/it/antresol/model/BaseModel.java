package it.antresol.model;

import android.content.ContentValues;
import android.util.Log;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import it.antresol.R;

/**
 * Created by artem on 2/16/15.
 */
public class BaseModel {

    public BaseModel() {

    }

    public static <T> ContentValues toContentValues(T object) throws IllegalAccessException {

        ContentValues cv = new ContentValues();

        for (Field field : object.getClass().getFields()) {

            Object value = field.get(object);

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

    public static <T> ContentValues[] toContentValues(List<T> list) throws IllegalAccessException {

        List<ContentValues> cvList = new LinkedList<ContentValues>();
        ContentValues cv = null;
        for (Object object : cvList) {

            cv = new ContentValues();
            for (Field field : object.getClass().getFields()) {

                Object value = field.get(object);

                if (value instanceof Double || value instanceof Integer || value instanceof R.string || value instanceof Boolean
                        || value instanceof Long || value instanceof Float || value instanceof Short) {

                    cv.put(field.getName(), value.toString());
                    Log.d("CVLOOP", field.getName() + ":" + value.toString());
                } else if (value instanceof Date) {

                    cv.put(field.getName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value));
                }
            }
            cvList.add(cv);
        }

        return cvList.toArray(new ContentValues[cvList.size()]);
    }
}
