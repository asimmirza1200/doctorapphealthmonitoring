package com.d.healthmonitoring.Model;


import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ECG {

    @SerializedName("ecg")
    @Expose
    private String ecg;
    @SerializedName("time")
    @Expose
    private String time;

    public String getEcg() {
        return ecg;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}