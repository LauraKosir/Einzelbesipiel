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
            //int tempInt = tempChar;
            int tempInt;

            if(i%2 == 0) {
                ascii += tempChar+",";
            } else {
                switch (tempChar) {
                    case '1':
                        tempInt = 'a';
                        break;
                    case '2':
                        tempInt = 'b';
                        break;
                    case '3':
                        tempInt = 'c';
                        break;
                    case '4':
                        tempInt = 'd';
                        break;
                    case '5':
                        tempInt = 'e';
                        break;
                    case '6':
                        tempInt = 'f';
                        break;
                    case '7':
                        tempInt = 'g';
                        break;
                    case '8':
                        tempInt = 'h';
                        break;
                    case '9':
                        tempInt = 'i';
                        break;
                    default:
                        tempInt = tempChar;
                        break;
                }
                ascii += tempInt+",";
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
