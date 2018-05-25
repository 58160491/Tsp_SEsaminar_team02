package com.palapol.tsp_sesaminar_team02.model;

import com.google.gson.annotations.SerializedName;

public class ResObj {
    private String message;
    private String IdUser;
    private String UsName;
    private String WgNameT;
    @SerializedName("pro_index")
    private String proIndex;

    @SerializedName("pro_title")
    private String proTitle;

    @SerializedName("jou_index")
    private String jouIndex;

    @SerializedName("jou_title")
    private String jouTitle;

    public String getProIndex() {
        return proIndex;
    }

    public void setProIndex(String proIndex) {
        this.proIndex = proIndex;
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }


    public String getJouIndex() {
        return jouIndex;
    }

    public void setJouIndex(String jouIndex) {
        this.jouIndex = jouIndex;
    }

    public String getJouTitle() {
        return jouTitle;
    }

    public void setJouTitle(String jouTitle) {
        this.jouTitle = jouTitle;
    }

    public String getWgID() {
        return WgID;
    }

    public void setWgID(String wgID) {
        WgID = wgID;
    }

    private String WgID;
    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public String getUsName() {
        return UsName;
    }

    public void setUsName(String usName) {
        UsName = usName;
    }

    public String getWgNameT() {
        return WgNameT;
    }

    public void setWgNameT(String wgNameT) {
        WgNameT = wgNameT;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
//iับตัว Return