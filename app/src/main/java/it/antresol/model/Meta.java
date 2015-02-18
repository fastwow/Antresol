package it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/18/15.
 */
public class Meta {

    @Expose
    private long totalCount;

    @Expose
    private long pageCount;

    @Expose
    private long currentPage;

    @Expose
    private long perPage;
}
