package com.example.ichanghyeon.todolist;

import java.io.Serializable;

/**
 * Created by ichanghyeon on 2018. 7. 11..
 */

public class Data implements Serializable {
    public String title;
    public String info;
    public String extraInfo;

    public Data(String title, String info, String extraInfo) {
        this.title = title;
        this.info = info;
        this.extraInfo = extraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
