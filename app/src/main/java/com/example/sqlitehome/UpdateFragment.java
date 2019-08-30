package com.example.sqlitehome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link UpdateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText update_id,update_name,update_email;
    Button btnsave;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UpdateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateFragment newInstance(String param1, String param2) {
        UpdateFragment fragment = new UpdateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        update_email = view.findViewById(R.id.editTextemail1);
        update_id = view .findViewById(R.id.editTextid1);
        update_name = view.findViewById(R.id.editTextname1);
        btnsave= view.findViewById(R.id.button1);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateContact();
            }
        });




        return view;
    }



    public  void updateContact()
    {

        int id = Integer.parseInt(update_id.getText().toString());
        String name = update_name.getText().toString();
        String email = update_email.getText().toString();


        ContactDbhelper contactDbhelper = new ContactDbhelper(getActivity());
        SQLiteDatabase database = contactDbhelper.getReadableDatabase();

        contactDbhelper.updateContacts(id,name,email,database);

        contactDbhelper.close();

        Toast.makeText(getActivity(), "Contact updated", Toast.LENGTH_SHORT).show();

        update_name.setText("");
        update_id.setText("");
        update_email.setText("");
    }









    }

