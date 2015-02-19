package it.antresol.api;

import it.antresol.model.BaseModel;

/**
 * Created by artem on 2/19/15.
 */
public interface IRequestStatusListener<T extends BaseModel> {

    void startFetchDataFromServer();

    void onSuccess(T result);

    void onError();

    void onError(String text);
}
