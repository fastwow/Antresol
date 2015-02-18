package it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/18/15.
 */
public class Link {

    @Expose
    String href;

    public Link() {

    }

    public Link(String href) {

        this.href = href;
    }

    public String getHref() {

        return href;
    }

    public void setHref(String href) {

        this.href = href;
    }
}