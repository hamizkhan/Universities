package com.example.hamiz.universities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //get reference
        final TextView textView=(TextView) findViewById(R.id.textView);
        ListView listView=(ListView) findViewById(R.id.listView);

        String uArray[]={"UTA","UNT","UTD","TCU"};

      //creates a list from uArray Elements
        List<String> uList = new ArrayList<String>(Arrays.asList(uArray));


       //converts an ArrayList of objects into View items loaded into the ListView container.
        ArrayAdapter<String>uAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,uList);

        listView.setAdapter(uAdapter);

      //  set ClckListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);


                if(position==0)
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uta.edu/uta/")));
                else if(position==1)
                {
                    String url = "https://www.unt.edu/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.utdallas.edu/"));
                    startActivity(intent);
                }
                else if(position==3)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tcu.edu/")));
                }

                // Display the selected item text on TextView
                textView.setText("Redirecting To : " + selectedItem);
            }
        });








    }
}
