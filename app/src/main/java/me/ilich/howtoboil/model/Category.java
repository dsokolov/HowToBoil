package me.ilich.howtoboil.model;

import org.json.JSONObject;

public class Category {

    public Category fromJson(JSONObject jsonObject) {
        int id = jsonObject.optInt("id");
        String title = jsonObject.optString("title");
        Category c = new Category(id, title);
        return c;
    }

    private final int id;
    private final String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

}
