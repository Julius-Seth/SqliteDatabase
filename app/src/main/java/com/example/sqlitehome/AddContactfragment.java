package com.example.sqlitehome;


import android.database.sqlite.SQLiteDatabase;
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
 */
public class AddContactfragment extends Fragment {

    Button btnsave;
    EditText Id,Name,Email;


    public AddContactfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_contactfragment, container, false);

        btnsave= view.findViewById(R.id.button);
        Id = view .findViewById(R.id.editTextid);
        Name = view.findViewById(R.id.editTextname);
        Email = view.findViewById(R.id.editTextemail);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();



                ContactDbhelper contactDbhelper = new ContactDbhelper(getActivity());
                SQLiteDatabase database = contactDbhelper.getWritableDatabase();
                contactDbhelper.addContact(Integer.parseInt(id),name,email,database);
                contactDbhelper.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");

                Toast.makeText(getActivity(), "Contact saved", Toast.LENGTH_SHORT).show();



            }
        });

        return view;
    }

}
