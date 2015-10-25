package me.ilich.howtoboil.model;

import org.json.JSONObject;

public class Dish {

    public static Dish fromJson(JSONObject jsonObject) {
        int id = jsonObject.optInt("id");
        String title = jsonObject.optString("title");
        Dish d = new Dish(id, title);
        return d;
    }

    private final int id;
    private final String title;

    public Dish(int id, String title) {
        this.id = id;
        this.title = title;
    }

}
