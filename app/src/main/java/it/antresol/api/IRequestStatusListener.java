package it.antresol.api;

/**
 * Created by artem on 2/19/15.
 */
public interface IRequestStatusListener {

    void onSuccess();

    void onError();

    void onError(String text);
}
