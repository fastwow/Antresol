package it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/12/15.
 */
public class Country extends BaseModel {

    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private String nameEn;

    @Expose
    private String currency;

    @Expose
    private String codeCurrency;

    @Expose
    private String iso;

    public Country(long id, String iso, String codeCurrency, String currency, String nameEn, String name) {

        this.id = id;
        this.iso = iso;
        this.codeCurrency = codeCurrency;
        this.currency = currency;
        this.nameEn = nameEn;
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getIso() {

        return iso;
    }

    public void setIso(String iso) {

        this.iso = iso;
    }

    public String getCodeCurrency() {

        return codeCurrency;
    }

    public void setCodeCurrency(String codeCurrency) {

        this.codeCurrency = codeCurrency;
    }

    public String getCurrency() {

        return currency;
    }

    public void setCurrency(String currency) {

        this.currency = currency;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNameEn() {

        return nameEn;
    }

    public void setNameEn(String nameEn) {

        this.nameEn = nameEn;
    }
}
