package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListFragment extends Fragment {
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter myAdapter;
    public static RecyclerView.LayoutManager layoutManager;

    public ListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView=view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
    public static void notifyDataSetChanged(){
        myAdapter.notifyDataSetChanged();
    }
}