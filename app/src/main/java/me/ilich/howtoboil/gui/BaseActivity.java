package me.ilich.howtoboil.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.ilich.howtoboil.Navigator;

public abstract class BaseActivity extends AppCompatActivity implements Navigator.Navigable {

    private Navigator navigator;
    private Navigator.Navigable navigable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator = new Navigator(this);
        navigable = new Navigator.NavigableImpl(getSupportFragmentManager());
    }

    public Navigator getNavigator() {
        return navigator;
    }

    @Override
    public void replace(BaseFragment fragment) {
        navigable.replace(fragment);
    }

}
