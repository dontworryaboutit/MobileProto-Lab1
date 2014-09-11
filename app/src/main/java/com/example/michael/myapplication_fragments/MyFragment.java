package com.example.michael.myapplication_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyFragment extends Fragment {

    public static class PlaceholderFragment extends android.support.v4.app.Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);

//            FIXME - these are hardcoded
            String[] listChats = {"Chat", "List", "So", "Yea"};

            myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_item,
                    new ArrayList<String>(Arrays.asList(listChats))
            ));

            return rootView;
        }
    }
}
