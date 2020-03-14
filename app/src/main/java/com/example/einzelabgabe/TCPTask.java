package com.example.einzelabgabe;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class TCPTask extends AsyncTask<String, String, String> {

    private String matrikelNummer;
    private String response;
    private MainActivity mainActivity;
    private TextView textViewAntwort;

    public TCPTask(TextView textViewAntwort, String matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
        this.response = null;
        this.textViewAntwort = textViewAntwort;
    }

    @Override
    protected String doInBackground(String... strings) {
        Client client = new Client("se2-isys.aau.at", 53212);
        response = client.communicate(matrikelNummer);
        Log.i("Testing DoInBackground", response);
        client.closeClient();
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("TestingPostExecute", response);
        textViewAntwort.setText(response);
    }
}
