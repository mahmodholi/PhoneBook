package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInfrmation extends Fragment {
    EditText etName,etPhone;
    Button btnAdd;


    public AddInfrmation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_add_infrmation, container, false);
        etName=view.findViewById(R.id.textView);
        etPhone=view.findViewById(R.id.textView2);
        btnAdd=view.findViewById(R.id.button2);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty()||etPhone.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Please fill all fields ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String name,phone;
                    name=etName.getText().toString().trim();
                    phone=etName.getText().toString().trim();
                    MainActivity.people.add(new Person(name,phone));
                    Toast.makeText(getActivity(), "Person added successfully", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etPhone.setText(null);
                    ListFragment.notifyDataSetChanged();



                }
            }
        });
        return view;
    }
}