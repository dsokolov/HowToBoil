package me.ilich.howtoboil.gui;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
