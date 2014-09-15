package com.example.michael.myapplication_fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatAdapter extends ArrayAdapter {
    private List<ModelChat> chats = new ArrayList<ModelChat>();
    private int resource;
    private Context context;

    public ChatAdapter(Context context, List<ModelChat> chats, int resource) {
        super(context, R.layout.chat_item);
        this.context = context;
        this.resource = resource;

        addChats(chats);
    }

    private class ChatHolder {
        TextView name, body, time;
        ImageView picture;
        View background;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ChatHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(resource, parent, false);
        holder = new ChatHolder();

        //TextViews
        holder.name = (TextView) view.findViewById(R.id.item_profile_name);
        holder.body = (TextView) view.findViewById(R.id.item_chat_body);
        holder.time = (TextView) view.findViewById(R.id.item_chat_time);

        //ImageViews
        holder.background = view.findViewById(R.id.item_profile_background);
        holder.picture = (ImageView) view.findViewById(R.id.item_profile_picture);
        fillViews(holder, chats.get(position));
        return view;
    }

    @Override
    public int getCount(){
        return this.chats.size();
    }

    private void fillViews(ChatHolder holder, ModelChat chat){
        holder.name.setText(chat.sender);
        holder.body.setText(chat.body);
        holder.time.setText(formatTime(chat.time));

        holder.background.setBackgroundResource(MyActivity.userColors.get(chat.sender));
        //holder.picture.setImageDrawable(getProfileDrawable(chat.userId));
    }

    private String formatTime(long time){
        if (DateUtils.isToday(time)){
            return new SimpleDateFormat("hh:mm:ss a").format(new Date(time));
        }
        return new SimpleDateFormat("MM/DD, hh:mm:ss a").format(new Date(time));
    }

    private Drawable getProfileDrawable(String id){
        return null;
    }

    public void addChats(List<ModelChat> newChats){
        this.chats.addAll(newChats);
        notifyDataSetChanged();
    }

    public void addChat(ModelChat chat){
        this.chats.add(chat);
        notifyDataSetChanged();
    }
}