package me.ilich.howtoboil.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.ilich.howtoboil.Navigator;
import me.ilich.howtoboil.R;

public class ToolbarFragment extends BaseFragment implements Navigator.Navigable {

    public static ToolbarFragment newInstance() {
        return new ToolbarFragment();
    }

    private Navigator.Navigable navigable;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigable = new Navigator.NavigableImpl(getChildFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_toolbar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        getBaseActivity().setSupportActionBar(toolbar);
    }

    @Override
    public void replace(BaseFragment fragment) {
        navigable.replace(fragment);
    }

}
