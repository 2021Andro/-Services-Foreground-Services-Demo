package com.example.foregroundservicesdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.CompletionService;

public class MainActivity extends AppCompatActivity {

    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);


        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = etName.getText().toString().trim();

                        Intent intent = new Intent(MainActivity.this, MyService.class);

                        intent.putExtra(MyApp.INPUT_KEY, name);

                        ContextCompat.startForegroundService(MainActivity.this, intent);



                    }
                });


    }
}