package com.example.monikagarg.finalproject;

/**
 * Created by DELL on 6/24/2016.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Fragment4 extends Fragment {
    private RecyclerView recyclerView;
    List<Note> noteList = new ArrayList<>();
    private NoteAdapter mAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    Notesdao notesdao= new Notesdao();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment4, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        //staggeredGridLayoutManager= new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new NoteAdapter(noteList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        noteList=notesdao.retrieveRecords(getContext());
        return rootView;
    }
}

