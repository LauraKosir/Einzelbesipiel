package com.example.einzelabgabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonBerechnen;
    private Button buttonAbschicken;
    private TextView textViewAntwort;
    private EditText editTextMatrikel;

    private String response;

    public void abschicken(View view){
        TCPTask tcpTask = new TCPTask(textViewAntwort, editTextMatrikel.getText().toString());
        tcpTask.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbschicken = findViewById(R.id.buttonAbschicken);
        buttonBerechnen = findViewById(R.id.buttonBerechnen);
        textViewAntwort = findViewById(R.id.textViewAntwort);
        editTextMatrikel = findViewById(R.id.editTextMatrikel);
        response = null;

        buttonAbschicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abschicken(view);
            }
        });
    }


}
