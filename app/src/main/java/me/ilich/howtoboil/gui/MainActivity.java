package me.ilich.howtoboil.gui;

import android.os.Bundle;

import java.util.ArrayList;

import me.ilich.howtoboil.R;
import me.ilich.howtoboil.model.Dish;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        getNavigator().dishes();
    }

}
