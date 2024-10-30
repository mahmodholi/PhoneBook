package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements personAdapter.ItemSelected{
    public static ArrayList<Person> people;
    TextView tvDate;
    String CurrentDate;
    Calendar calender=Calendar.getInstance();
    FragmentManager fragmentManager;
    ListFragment listFrag;
    DetalsFragment detailFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate=findViewById(R.id.textView6);
        fragmentManager=this.getSupportFragmentManager();
        CurrentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        tvDate.setText(CurrentDate);
        listFrag=(ListFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView3);
        initArray();
        detailFrag=(DetalsFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
    }
    public static void initArray (){
people=new ArrayList<>();
people.add(new Person("mahmod","05678987",R.drawable.brekingbad));
people.add(new Person("ahmed","038392284",R.drawable.strangerthings));
        people.add(new Person("ahmed","038392284",R.drawable.prisonbreak));
        people.add(new Person("ahmed","038392284",R.drawable.vikings));
        people.add(new Person("ahmed","038392284",R.drawable.winsday));

    }

    @Override
    public void onItemSelected(int index) {
        if(!people.isEmpty()) {
            detailFrag.updateTexts(people.get(index).getName(), people.get(index).getPhone());
        }
        else
            return ;
    }
}