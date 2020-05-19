package com.techeasesolution.covid_19.Model.AllCountriesModel;

public class CountryInfo {

    String naem , flag ;

    public CountryInfo(String naem, String flag) {
        this.naem = naem;
        this.flag = flag;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
