package com.eme.aelegant.model.javabean;

import java.util.ArrayList;

/**
 * Created by 蔡小木 on 2016/3/6 0006.
 */
public class ZhihuDaily {

    private String date;
    private ArrayList<ZhihuDailyItem> top_stories;
    private ArrayList<ZhihuDailyItem> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ZhihuDailyItem> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(ArrayList<ZhihuDailyItem> top_stories) {
        this.top_stories = top_stories;
    }

    public ArrayList<ZhihuDailyItem> getStories() {
        return stories;
    }

    public void setStories(ArrayList<ZhihuDailyItem> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "ZhihuDaily{" +
                "date='" + date + '\'' +
                ", top_stories=" + top_stories +
                ", stories=" + stories +
                '}';
    }
}
