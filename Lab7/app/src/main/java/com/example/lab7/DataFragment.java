package com.example.lab7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DataFragment extends Fragment {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private EditText nameEditText, ageEditText;
    private Button addButton;

    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataAdapter = new DataAdapter();
        recyclerView.setAdapter(dataAdapter);

        nameEditText = view.findViewById(R.id.nameEditText);
        ageEditText = view.findViewById(R.id.ageEditText);
        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                dbHelper.insertData(name, age);
                updateData();
                nameEditText.setText("");
                ageEditText.setText("");
            }
        });

        dbHelper = new DBHelper(getActivity());

        displayData();

        return view;
    }

    public void updateData() {
        displayData();
    }

    private void displayData() {
        dataAdapter.setCursor(dbHelper.getAllData());
    }
}