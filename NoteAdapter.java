package com.example.monikagarg.finalproject;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by monikagarg on 6/30/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {
private List<Note> noteList;
private Context mContext;
        boolean check= false;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView description;
    public ImageView image;

    public MyViewHolder(final View view) {
        super(view);
        description = (TextView) view.findViewById(R.id.displayDiscription);
        image = (ImageView) view.findViewById(R.id.islabel);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }


                            // continue with delete

                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}
    public NoteAdapter(List<Note> noteList, Context context) {
        this.noteList = noteList;
        mContext = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.description.setText(note.getDescription());
        holder.image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.label_a));

    }
    @Override
    public int getItemCount() {
        return noteList.size();}}



