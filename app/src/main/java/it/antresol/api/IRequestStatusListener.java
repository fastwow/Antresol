package it.antresol.api;

/**
 * Created by artem on 2/19/15.
 */
public interface IRequestStatusListener<T> {

    void startFetchDataFromServer();

    void onSuccess(T result, boolean isNeedToRefreshData);

    void onError();

    void onError(String text);
}
