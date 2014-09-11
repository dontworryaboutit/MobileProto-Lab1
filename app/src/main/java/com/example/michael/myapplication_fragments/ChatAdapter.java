package com.example.michael.myapplication_fragments;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<String> {

    public ChatAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }
}
