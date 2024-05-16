package com.example.a.Modal;

import androidx.recyclerview.widget.RecyclerView;

public class notificationModel {

    String note , time;

    public notificationModel(String note, String time) {

        this.note = note;
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
