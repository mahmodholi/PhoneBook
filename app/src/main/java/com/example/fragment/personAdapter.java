package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class personAdapter extends RecyclerView.Adapter<personAdapter.ViewHolder> {
    private ArrayList<Person> people;
    ItemSelected activity;

    public interface ItemSelected {
        void onItemSelected(int index);

    }
    public personAdapter (Context context, ArrayList<Person> list){
        this.people=list;
        activity=(ItemSelected)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView6);
            imageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemSelected(people.indexOf(v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowlayut,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvName.setText(people.get(position).getName());
        holder.imageView.setImageResource(people.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

}