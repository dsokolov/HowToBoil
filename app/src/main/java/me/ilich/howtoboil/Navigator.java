package me.ilich.howtoboil;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

import me.ilich.howtoboil.gui.BaseFragment;
import me.ilich.howtoboil.gui.DishListFragment;
import me.ilich.howtoboil.gui.ToolbarFragment;
import me.ilich.howtoboil.model.Dish;

public class Navigator {

    private final Navigable navigable;

    public Navigator(Navigable navigable) {
        this.navigable = navigable;
    }

    public void dishes() {
        ToolbarFragment toolbarFragment = ToolbarFragment.newInstance();
        navigable.replace(toolbarFragment);

        ArrayList<Dish> dishList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dishList.add(new Dish(i, i + ""));
        }
        toolbarFragment.replace(DishListFragment.newInstance(dishList));
    }

    public interface Navigable {

        void replace(BaseFragment fragment);

    }

    public static class NavigableImpl implements Navigable {

        private final FragmentManager fragmentManager;

        public NavigableImpl(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @Override
        public void replace(BaseFragment fragment) {
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            fragmentManager.executePendingTransactions();
        }

    }

}
