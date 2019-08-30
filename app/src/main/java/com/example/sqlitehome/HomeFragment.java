package com.example.sqlitehome;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

Button Btnsave,Btnadd,Btnupdate,Btnview,Btndelete;

OnDbopListener dbopListener;
    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbopListener {

        void dBOpPerformed(int method);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        Btnsave = view.findViewById(R.id.button);
        Btnadd = view.findViewById(R.id.buttonadd);
        Btnview = view.findViewById(R.id.buttonview);
        Btndelete= view.findViewById(R.id.buttondel);
        Btnupdate= view.findViewById(R.id.buttonupdate);

        Btnadd.setOnClickListener(this);
        Btnview.setOnClickListener(this);
        Btnupdate.setOnClickListener(this);
        Btndelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id. buttonadd:
            dbopListener.dBOpPerformed(0);
            break;

            case R.id.buttonview:
                dbopListener.dBOpPerformed(1);
                break;case R.id.buttonupdate:
                dbopListener.dBOpPerformed(2);
                break;
            case R.id. buttondel:
                dbopListener.dBOpPerformed(3);
                break;


        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            dbopListener = (OnDbopListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implement the interface method");
        }
    }
}
