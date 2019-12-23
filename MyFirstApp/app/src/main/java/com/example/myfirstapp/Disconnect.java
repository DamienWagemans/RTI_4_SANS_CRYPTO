package com.example.myfirstapp;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

import ClassesRequeteViews.Server_Information;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;

public class Disconnect extends AsyncTask <Void, Void, Object>{

    public Disconnect()
    {

    }

    @Override
    protected Object doInBackground(Void... voids) {
        try {
            Reseaux.getCli_Socket().close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
