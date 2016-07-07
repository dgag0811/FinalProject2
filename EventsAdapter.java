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
 * Created by monikagarg on 6/26/2016.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private List<Event> eventsList;
    private Context mContext;
    boolean check= false;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, time, venue, description, attendees;
        public ImageView image, image1;

        public MyViewHolder(final View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.DisplayTitle);
            time = (TextView) view.findViewById(R.id.DisplayTime);
            venue = (TextView) view.findViewById(R.id.displayVenue);
            description = (TextView) view.findViewById(R.id.displayDiscription);
            attendees = (TextView) view.findViewById(R.id.DisplayAttendees);
            image = (ImageView) view.findViewById(R.id.islabel);
            image1 = (ImageView) view.findViewById(R.id.isfav);

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
    public EventsAdapter(List<Event> eventsList, Context context) {
        this.eventsList = eventsList;
        mContext = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.title.setText(event.getTitle());
        holder.time.setText(event.getTime());
        holder.venue.setText(event.getVenue());
        holder.image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.label_a));
        holder.description.setText(event.getDescription());
        holder.attendees.setText(event.getAttendees());
        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){
                    holder.image1.setImageDrawable(mContext.getResources().getDrawable(R.drawable.fav_c));
                    check=false;
                }
                else
                {
                    holder.image1.setImageDrawable(mContext.getResources().getDrawable(R.drawable.fav_a));
                    check=true;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}


