package com.example.myfirstapp;

import android.os.AsyncTask;

import ClassesRequeteViews.Server_Information;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;

import java.io.IOException;
import java.net.Socket;

public class requete_from_views extends AsyncTask <Void, Void, Object>{

    private Object Requete;
    private int Type;
    public static int NONE = 0;
    public static int CONNECT = 1;
    public static int SEND_REQUEST = 2;
    public static int DISCONNECT = 3;

    public Object getRequete() {
        return Requete;
    }

    public void setRequete(Object Requete) {
        this.Requete = Requete;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }


    public requete_from_views(){
        Requete = null;
        Type = NONE;
    }

    public requete_from_views(Object Requete, int Type){
        this.Requete = Requete;
        this.Type = Type;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        switch(Type){
            case 1:
                Server_Information cts= (Server_Information) getRequete();
                try {
                    Reseaux.setCli_Socket(new Socket(cts.getIp(), cts.getPort()));
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            case 2:
                RequeteCONTROLID req = (RequeteCONTROLID) getRequete();
                ReponseCONTROLID rep = new ReponseCONTROLID();
                try {
                    req.EnvoieRequete(Reseaux.getCli_Socket());
                    rep.RecevoirReponse(Reseaux.getCli_Socket());
                    return rep;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Reseaux.getCli_Socket().close();
                    return true;
                } catch (IOException e) {
                    return false;
                }

        }
        return null;
    }
}
