package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationActivity extends AppCompatActivity {

    Intent intent;
    ListView listView;
    String[] menu_list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        menu_list = getApplicationContext().getResources().getStringArray(R.array.tasks_list);
        listView = (ListView) findViewById(R.id.listViewNav);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                menu_list
        );
        //Set the array adapter to listView
        listView.setAdapter(listViewAdapter);

        //Add event listener for list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    intent = new Intent(NavigationActivity.this,NewApplicantActivity.class);
                } else if (position == 1) {
                    intent = new Intent(NavigationActivity.this, SearchApplicantActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}