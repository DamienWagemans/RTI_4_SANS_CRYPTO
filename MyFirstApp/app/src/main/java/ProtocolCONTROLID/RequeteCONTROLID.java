/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocolCONTROLID;

import interface_req_rep.Requete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.*;
import java.util.Properties;


//SERVEUR RECOIT UNE REQUETE ET ENVOIE UNE REPONSE
//CLIENT ENVOIE UNE REQUETE ET RECOIT UNE REPONSE
public class RequeteCONTROLID implements Requete , Serializable{
    
    public static int LOGIN = 1;
    public static int VERIF_IMMATRICULATION = 2;
    public static int VERIF_VOYAGEUR = 3;
    public static int GET_POST = 4;
    public static int DECLARER_ACCIDENT = 5;
    public static int STICKERS = 6;

    
    
    public static int STOP = -1;
    
    private int type;
    private Object classe = null;
    private Properties myProperties;
    
     public RequeteCONTROLID() 
    {
        setTypeRequete(0);
        setObjectClasse(null); 
    }
    public RequeteCONTROLID(int t, Object classe) 
    {
        setTypeRequete(t);
        setObjectClasse(classe); 
    }

    
    public int getTypeRequete() { return type; }
    public void setTypeRequete(int type) {
        this.type = type; 
    }
    
    public Object getObjectClasse() { return classe; }
    public void setObjectClasse(Object classe) {
        this.classe = classe; 
    }

    @Override
    public Runnable createRunnable(Socket s, Socket Sock_internat, Statement instruc) {
        return new Runnable() 
        {
            public void run() {

            }
        };
    }
    
    public void TraitementRequete(Socket s, Socket Sock_internat, Statement instruct) 
    {

    }
    
    public void aposer_stickers(Socket s) throws IOException
    {

    }
    
    public void declarer_accident(Socket sock) throws IOException
    {

    }
    
    public void get_post(Socket Sock) throws IOException 
    {

    }
    
    public int TraiterRequeteLogin(Socket sock, Statement instruc) throws IOException
    {
        return 1;

    }
    
    public void verif_voyageur(Socket sock, Socket sock_internat, Statement instruc) throws IOException, SQLException, ClassNotFoundException {

        
    }
    
    
    public void verif_immatriculation(Socket sock, Socket sock_internat, Statement instruc) throws SQLException, IOException, ClassNotFoundException
    {

    }
    
    
   
    public void EnvoieRequete(Socket cliSocket) throws IOException 
    { 
        ObjectOutputStream oos; 
        oos = new ObjectOutputStream(cliSocket.getOutputStream());
        oos.writeObject(this); 
        oos.flush();
    }
    
    public void RecevoirRequete(Socket CSocket) throws IOException, ClassNotFoundException
    { 
        ObjectInputStream ois=null; 
        RequeteCONTROLID temp = new RequeteCONTROLID();
        System.out.println("En attente d'une requete" + CSocket.toString());
        ois = new ObjectInputStream(CSocket.getInputStream());
        temp= (RequeteCONTROLID)ois.readObject();
        this.setTypeRequete(temp.getTypeRequete());
        this.setObjectClasse(temp.getObjectClasse());
        System.out.println("Requete lue par le serveur, instance de " + this.getClass().getName());
    }
    
    public int random(int high, int low) {
            return((int)(Math.random() * (high+1-low)) + low);
    }
        
}
