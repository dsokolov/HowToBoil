package me.ilich.howtoboil.gui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.ilich.howtoboil.R;
import me.ilich.howtoboil.model.Dish;

public class DishListFragment extends BaseFragment {

    private static final String ARG_DISH_LIST = "dish_list";

    public static DishListFragment newInstance(ArrayList<Dish> dishList) {
        DishListFragment dishListFragment = new DishListFragment();
        Bundle b = new Bundle();
        b.putSerializable(ARG_DISH_LIST, dishList);
        dishListFragment.setArguments(b);
        return dishListFragment;
    }

    private RecyclerView recyclerView;
    private List<Dish> dishList;
    private Adapter adapter = new Adapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dishList = (ArrayList) getArguments().getSerializable(ARG_DISH_LIST);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_dish_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.dishTitle);
        }

    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.i_dish, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Dish dish = dishList.get(position);
            holder.titleTextView.setText(dish.getTitle());
        }

        @Override
        public int getItemCount() {
            return dishList.size();
        }

    }

}
