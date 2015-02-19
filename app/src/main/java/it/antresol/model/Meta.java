package it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/18/15.
 */
public class Meta extends BaseModel {

    @Expose
    private long totalCount;

    @Expose
    private long pageCount;

    @Expose
    private long currentPage;

    @Expose
    private long perPage;

    public Meta() {

    }

    public Meta(long totalCount, long pageCount, long currentPage, long perPage) {

        this.totalCount = totalCount;
        this.pageCount = pageCount;
        this.currentPage = currentPage;
        this.perPage = perPage;
    }

    public long getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(long totalCount) {

        this.totalCount = totalCount;
    }

    public long getPageCount() {

        return pageCount;
    }

    public void setPageCount(long pageCount) {

        this.pageCount = pageCount;
    }

    public long getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(long currentPage) {

        this.currentPage = currentPage;
    }

    public long getPerPage() {

        return perPage;
    }

    public void setPerPage(long perPage) {

        this.perPage = perPage;
    }
}
