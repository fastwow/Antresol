package it.antresol.ui;

/**
 * Created by artem on 2/18/15.
 */
public interface IUIEventListener {

    void showProgressBar();

    void dismissProgressBar();

    void showErrorMessage(String text);

    void showErrorMessage();

    void hideErrorMessage();
}
