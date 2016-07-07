package com.example.monikagarg.finalproject;

/**
 * Created by DELL on 6/24/2016.
 */


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class Fragment3 extends Fragment {
    private List<Meal> mealList = new ArrayList<>();
    private RecyclerView recyclerView;
    MealMenuAdapter mealMenuAdapter;
    Mealdao mealdao = new Mealdao();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment3, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mealMenuAdapter = new MealMenuAdapter(getActivity(),mealList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mealMenuAdapter);

        mealList = mealdao.retrieveRecords(getContext());
        return rootView;

    }



}