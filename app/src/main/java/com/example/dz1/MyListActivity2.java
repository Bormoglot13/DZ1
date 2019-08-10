package com.example.dz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListActivity2 extends AppCompatActivity implements MyAdapter.OnMyDataEditListener {

    ArrayList<MyData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list2);
        RecyclerView recyclerView = findViewById(R.id.rc_view);
        data = MyData.dataGenerator(this,50);
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnMyDataEditListener(this);
    }

    @Override
    public void onEditData(ArrayList<MyData> data, int position) {
        Toast.makeText(this,"button edit click",Toast.LENGTH_SHORT).show();
    }
}
