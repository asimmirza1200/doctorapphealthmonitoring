package com.d.healthmonitoring.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DHT {

    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("time")
    @Expose
    private String time;

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}