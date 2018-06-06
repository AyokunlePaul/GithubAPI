package com.dev.eipeks.graymergetest.core.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppBaseModel<T> {
    @SerializedName("total_count")
    private Long totalCount;
    @SerializedName("incomplete_results")
    private Boolean isIncomplete;
    @SerializedName("items")
    private List<T> responseList;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncomplete() {
        return isIncomplete;
    }

    public void setIncomplete(Boolean incomplete) {
        isIncomplete = incomplete;
    }

    public List<T> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<T> responseList) {
        this.responseList = responseList;
    }

    @Override
    public String toString() {
        return "AppBaseModel{" +
                "totalCount=" + totalCount +
                ", isIncomplete=" + isIncomplete +
                ", responseList=" + responseList +
                '}';
    }
}
