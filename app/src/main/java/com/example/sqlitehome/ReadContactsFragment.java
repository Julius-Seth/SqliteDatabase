package com.example.sqlitehome;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

private TextView TXT_display;
    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contacts, container, false);

        TXT_display = view.findViewById(R.id.txt_display);
           readContacts();
        return view;
    }

    public void readContacts()

    {

         ContactDbhelper contactDbhelper = new ContactDbhelper(getActivity());
        SQLiteDatabase database =  contactDbhelper.getReadableDatabase();

        Cursor cursor = contactDbhelper.readContacts(database);
      String info = "";

        while (cursor.moveToNext())


        {

            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            //String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info+"\n\n"+"Id :" +id+"\nName :  "+"\nEmail : "+email;

        }

        TXT_display.setText(info);
        contactDbhelper.close();
    }

}
