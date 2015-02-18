package it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/18/15.
 */
public class Links {

    @Expose
    private Link self;

    @Expose
    private Link next;

    @Expose
    private Link last;

    public Links() {

    }

    public Links(Link self, Link next, Link last) {

        this.self = self;
        this.next = next;
        this.last = last;
    }

    public Link getSelf() {

        return self;
    }

    public void setSelf(Link self) {

        this.self = self;
    }

    public Link getNext() {

        return next;
    }

    public void setNext(Link next) {

        this.next = next;
    }

    public Link getLast() {

        return last;
    }

    public void setLast(Link last) {

        this.last = last;
    }
}
