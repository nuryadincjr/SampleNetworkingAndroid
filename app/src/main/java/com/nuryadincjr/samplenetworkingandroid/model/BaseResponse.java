package com.nuryadincjr.samplenetworkingandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<ResultsItem> results;


    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public int getCount() {
        return count;
    }

    public List<ResultsItem> getResults() {
        return results;
    }
}
