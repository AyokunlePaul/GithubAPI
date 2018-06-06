package com.dev.eipeks.graymergetest.core.api.models;

import com.google.gson.annotations.SerializedName;

public class RepositoryModel {
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("description")
    private String description;
    @SerializedName("stargazers_count")
    private Long stars;
    @SerializedName("watchers")
    private Long watchers;
    @SerializedName("forks")
    private Long forks;
    @SerializedName("owner")
    private RepositoryOwnerModel owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }

    public Long getWatchers() {
        return watchers;
    }

    public void setWatchers(Long watchers) {
        this.watchers = watchers;
    }

    public Long getForks() {
        return forks;
    }

    public void setForks(Long forks) {
        this.forks = forks;
    }

    public RepositoryOwnerModel getOwner() {
        return owner;
    }

    public void setOwner(RepositoryOwnerModel owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "RepositoryModel{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", stars=" + stars +
                ", watchers=" + watchers +
                ", forks=" + forks +
                ", owner=" + owner +
                '}';
    }
}
