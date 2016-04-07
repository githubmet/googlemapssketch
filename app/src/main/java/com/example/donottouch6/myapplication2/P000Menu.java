package com.example.donottouch6.myapplication2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P000Menu extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(P000Menu.this,
                android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        String activityNames[]=getResources().getStringArray(R.array.activity_names);
        arrayAdapter.addAll(activityNames);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
             Class classClass= Class.forName("com.example.donottouch6.myapplication2."+l.getItemAtPosition(position));
            Intent intent=new Intent(P000Menu.this,classClass);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
