package com.dev.eipeks.graymergetest.core.api.models;

import com.google.gson.annotations.SerializedName;

public class RepositoryOwnerModel {
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("login")
    private String login;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "RepositoryOwnerModel{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
