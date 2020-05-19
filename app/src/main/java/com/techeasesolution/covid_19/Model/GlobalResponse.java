
package com.techeasesolution.covid_19.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GlobalResponse {

    @SerializedName("active")
    private Long mActive;
    @SerializedName("activePerOneMillion")
    private Double mActivePerOneMillion;
    @SerializedName("affectedCountries")
    private Long mAffectedCountries;
    @SerializedName("cases")
    private Long mCases;
    @SerializedName("casesPerOneMillion")
    private Long mCasesPerOneMillion;
    @SerializedName("critical")
    private Long mCritical;
    @SerializedName("criticalPerOneMillion")
    private Double mCriticalPerOneMillion;
    @SerializedName("deaths")
    private Long mDeaths;
    @SerializedName("deathsPerOneMillion")
    private Double mDeathsPerOneMillion;
    @SerializedName("population")
    private Long mPopulation;
    @SerializedName("recovered")
    private Long mRecovered;
    @SerializedName("recoveredPerOneMillion")
    private Double mRecoveredPerOneMillion;
    @SerializedName("tests")
    private Long mTests;
    @SerializedName("testsPerOneMillion")
    private Double mTestsPerOneMillion;
    @SerializedName("todayCases")
    private Long mTodayCases;
    @SerializedName("todayDeaths")
    private Long mTodayDeaths;
    @SerializedName("updated")
    private Long mUpdated;

    public Long getActive() {
        return mActive;
    }

    public void setActive(Long active) {
        mActive = active;
    }

    public Double getActivePerOneMillion() {
        return mActivePerOneMillion;
    }

    public void setActivePerOneMillion(Double activePerOneMillion) {
        mActivePerOneMillion = activePerOneMillion;
    }

    public Long getAffectedCountries() {
        return mAffectedCountries;
    }

    public void setAffectedCountries(Long affectedCountries) {
        mAffectedCountries = affectedCountries;
    }

    public Long getCases() {
        return mCases;
    }

    public void setCases(Long cases) {
        mCases = cases;
    }

    public Long getCasesPerOneMillion() {
        return mCasesPerOneMillion;
    }

    public void setCasesPerOneMillion(Long casesPerOneMillion) {
        mCasesPerOneMillion = casesPerOneMillion;
    }

    public Long getCritical() {
        return mCritical;
    }

    public void setCritical(Long critical) {
        mCritical = critical;
    }

    public Double getCriticalPerOneMillion() {
        return mCriticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(Double criticalPerOneMillion) {
        mCriticalPerOneMillion = criticalPerOneMillion;
    }

    public Long getDeaths() {
        return mDeaths;
    }

    public void setDeaths(Long deaths) {
        mDeaths = deaths;
    }

    public Double getDeathsPerOneMillion() {
        return mDeathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Double deathsPerOneMillion) {
        mDeathsPerOneMillion = deathsPerOneMillion;
    }

    public Long getPopulation() {
        return mPopulation;
    }

    public void setPopulation(Long population) {
        mPopulation = population;
    }

    public Long getRecovered() {
        return mRecovered;
    }

    public void setRecovered(Long recovered) {
        mRecovered = recovered;
    }

    public Double getRecoveredPerOneMillion() {
        return mRecoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
        mRecoveredPerOneMillion = recoveredPerOneMillion;
    }

    public Long getTests() {
        return mTests;
    }

    public void setTests(Long tests) {
        mTests = tests;
    }

    public Double getTestsPerOneMillion() {
        return mTestsPerOneMillion;
    }

    public void setTestsPerOneMillion(Double testsPerOneMillion) {
        mTestsPerOneMillion = testsPerOneMillion;
    }

    public Long getTodayCases() {
        return mTodayCases;
    }

    public void setTodayCases(Long todayCases) {
        mTodayCases = todayCases;
    }

    public Long getTodayDeaths() {
        return mTodayDeaths;
    }

    public void setTodayDeaths(Long todayDeaths) {
        mTodayDeaths = todayDeaths;
    }

    public Long getUpdated() {
        return mUpdated;
    }

    public void setUpdated(Long updated) {
        mUpdated = updated;
    }

}
