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

    public void berechnen(View view) {
        String matrikelnummer = editTextMatrikel.getText().toString();
        String ascii = "";

        for(int i = 0; i < matrikelnummer.length(); i++) {
            char tempChar = matrikelnummer.charAt(i);

            if(i%2 == 0) {
                ascii += tempChar+",";
            } else {
                switch (tempChar) {
                    case '1':
                        tempChar = 'a';
                        break;
                    case '2':
                        tempChar = 'b';
                        break;
                    case '3':
                        tempChar = 'c';
                        break;
                    case '4':
                        tempChar = 'd';
                        break;
                    case '5':
                        tempChar = 'e';
                        break;
                    case '6':
                        tempChar = 'f';
                        break;
                    case '7':
                        tempChar = 'g';
                        break;
                    case '8':
                        tempChar = 'h';
                        break;
                    case '9':
                        tempChar = 'i';
                        break;
                    default:
                        tempChar = 'j';
                        break;
                }
                ascii += tempChar+",";
            }
        }

        textViewAntwort.setText(ascii);
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
        buttonBerechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                berechnen(view);
            }
        });
    }


}
