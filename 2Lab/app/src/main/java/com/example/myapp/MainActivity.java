package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button button1;
    TextView TextView1;
    EditText EditText1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        TextView1 = findViewById(R.id.Text1);
        EditText1 = findViewById(R.id.editTextText);
        button2 = findViewById(R.id.button);


    }

    public void onMyButtonClick(View view)
    {
        TextView1.setText(EditText1.getText().toString());
    }
    ///
    public void onMyButtonClick1(View view)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}