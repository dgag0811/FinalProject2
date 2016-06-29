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
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment{
    private RecyclerView recyclerView;
    List<Event>eventList = new ArrayList<>();
    private EventsAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;

    EditText title;
    Button bn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        linearLayoutManager= new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        mAdapter = new EventsAdapter(eventList,getContext());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareEventData();
        return rootView;
    }

    private void prepareEventData() {

        Event event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_a);
        eventList.add(event);

        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_a);
        eventList.add(event);
        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_a);
        eventList.add(event);

        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_b);
        eventList.add(event);
        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_b);
        eventList.add(event);

        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_c);
        eventList.add(event);
        event = new Event("MEETING","11.30","LHC","With group 12","Group13",R.drawable.label_c);
        eventList.add(event);



        mAdapter.notifyDataSetChanged();
    }
}


