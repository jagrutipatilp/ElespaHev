package com.example.a.Modal;

public class shopModal {
String name,descr;
int image;


    public shopModal(String name, String descr, int image) {
        this.name = name;
        this.descr = descr;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
