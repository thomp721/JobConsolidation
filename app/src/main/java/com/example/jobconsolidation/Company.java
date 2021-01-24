package com.example.jobconsolidation;

public class Company {
    private String name;
    private String url;
    private String field;
    private String responseDate;
    private String competitiveness;
    private String hasPreference;
    private String preference;
    private String requiresPriorExperience;

    public Company () {
        name = "failure";
    }

    public Company (String name, String url, String field, String responseDate, String competitiveness,
                    String hasPreference, String preference, String requiresPriorExperience) {
        this.name = name;
        this.url = url;
        this.field = field;
        this.responseDate = responseDate;
        this.competitiveness = competitiveness;
        this.hasPreference = hasPreference;
        this.preference = preference;
        this.requiresPriorExperience = requiresPriorExperience;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getCompetitiveness() {
        return competitiveness;
    }

    public void setCompetitiveness(String competitiveness) {
        this.competitiveness = competitiveness;
    }

    public String isHasPreference() {
        return hasPreference;
    }

    public void setHasPreference(String hasPreference) {
        this.hasPreference = hasPreference;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String isRequiresPriorExperience() {
        return requiresPriorExperience;
    }

    public void setRequiresPriorExperience(String requiresPriorExperience) {
        this.requiresPriorExperience = requiresPriorExperience;
    }

    public String toString() {
        return "URL: " + url + "\n" + "Field: " + field + "\n" + "Response Date: " + responseDate + "\n" + "Competetiveness: " + competitiveness + "\n" + "Preferences : " + preference + "\n" + "Requires Prior Experience? " + requiresPriorExperience;



    }
}
