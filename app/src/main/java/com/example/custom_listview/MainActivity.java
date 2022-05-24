package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String x="a0";
        int[] imageId = {R.drawable.a0+1,R.drawable.a10,R.drawable.a102,R.drawable.a104,R.drawable.a106};

        String[] title = {"ADIDAS ULTRA BOOST 2020 CORE BLACK ",
                "ADIDAS ULTRA BOOST 2020 CORE BLACK white",
                "ADIDAS ULTRA BOOST 2020 CORE BLACK WITH WHITELACES",
                "TATA PREMIUM TEA (POUCH) 1 KG PACK",
                "HOME MINI MULT USEABLE RAZER (3 PIECES)"};

        String[] sub = {"180$","150$","140$","0.75$","154$"};


        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(title[i],sub[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("title",title[position]);
                i.putExtra("sub",sub[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}