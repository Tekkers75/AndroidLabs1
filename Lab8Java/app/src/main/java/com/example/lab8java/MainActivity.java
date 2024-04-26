package com.example.lab8java;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.BoxInsetLayout;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
    private WearableRecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим WearableRecyclerView в макете
        recyclerView = findViewById(R.id.recycler_view);

        // Создаем и настраиваем WearableLinearLayoutManager
        WearableLinearLayoutManager layoutManager = new WearableLinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создаем массив данных для списка
        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        // Создаем адаптер и устанавливаем его для списка
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
