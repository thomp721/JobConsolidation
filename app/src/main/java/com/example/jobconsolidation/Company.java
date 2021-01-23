package com.example.jobconsolidation;

public class Company {
    private String name;
    private String url;
    private String field;
    private String responseDate;
    private String competitiveness;
    private boolean hasPreference;
    private String preference;
    private boolean requiresPriorExperience;

    public Company (String name, String url, String field, String responseDate, String competitiveness,
                    boolean hasPreference, String preference, boolean requiresPriorExperience) {
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

    public boolean isHasPreference() {
        return hasPreference;
    }

    public void setHasPreference(boolean hasPreference) {
        this.hasPreference = hasPreference;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public boolean isRequiresPriorExperience() {
        return requiresPriorExperience;
    }

    public void setRequiresPriorExperience(boolean requiresPriorExperience) {
        this.requiresPriorExperience = requiresPriorExperience;
    }
}
