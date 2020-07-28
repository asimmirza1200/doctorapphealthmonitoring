package com.d.healthmonitoring.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BPM {

    @SerializedName("BPM")
    @Expose
    private String bPM;
    @SerializedName("Time")
    @Expose
    private String time;

    public String getBPM() {
        return bPM;
    }

    public void setBPM(String bPM) {
        this.bPM = bPM;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}