package ru.egoraganin.githubmvp.DataBase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Егор on 21.09.2017.
 */

public class Plan extends RealmObject{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("space")
    @Expose
    private int space;
    @SerializedName("collaborators")
    @Expose
    private int collaborators;
    @SerializedName("private_repos")
    @Expose
    private int privateRepos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(int collaborators) {
        this.collaborators = collaborators;
    }

    public int getPrivateRepos() {
        return privateRepos;
    }

    public void setPrivateRepos(int privateRepos) {
        this.privateRepos = privateRepos;
    }

}