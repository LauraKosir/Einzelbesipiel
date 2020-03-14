package com.example.einzelabgabe;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String ip;
    private int port;
    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;
    private Socket socket;
    private String response;

    public Client(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
        this.socket = null;
        this.response = "";
    }

    public String communicate(String matrikelnummer) {
        try {
            socket = new Socket(ip, port); //hier übergeben
            Log.i("TestingClient", Boolean.toString(socket.isConnected()));

            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeBytes(matrikelnummer + "\n");
            outputStream.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Log.i("TestingClient", "Recieve message");
            response = bufferedReader.readLine();
            Log.i("TestingClient", response);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void closeClient() {
        if(socket != null) {
            try {
                outputStream.close();
                bufferedReader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
