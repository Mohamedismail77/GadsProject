package com.ismail.gads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {


    @SerializedName("name")
    @Expose
    private String leaderName;

    @SerializedName("score")
    @Expose
    private int score;

    @SerializedName("hours")
    @Expose
    private int hours;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;


    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription(){
        if (hours != 0) {
            return hours + " learning hours, " + country;
        } else {
            return score + "skill IQ score, " + country;
        }
    }
}
