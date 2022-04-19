package com.example.promise.retrofit;


import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    private Long id;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("user_pass")
    private String user_pass;
    @SerializedName("user_name")
    private String user_name;


    public Model(String user_id, String user_pass, String user_name) {
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_name = user_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
