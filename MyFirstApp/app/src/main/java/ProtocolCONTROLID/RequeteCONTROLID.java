/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocolCONTROLID;

import ClassesCONTROLID.Login;
import ClassesCONTROLID.Voiture;
import ClassesCONTROLID.Voyageur;
import interface_req_rep.Reponse;
import interface_req_rep.Requete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dos Santos
 */
//SERVEUR RECOIT UNE REQUETE ET ENVOIE UNE REPONSE
//CLIENT ENVOIE UNE REQUETE ET RECOIT UNE REPONSE
public class RequeteCONTROLID implements Requete, Serializable{
    
    public static int LOGIN = 1;
    public static int VERIF_IMMATRICULATION = 2;
    public static int VERIF_VOYAGEUR = 3;
    public static int GET_POST = 4;
    
    
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
    public Runnable createRunnable(final Socket s, final Socket Sock_internat, final Statement instruc) {
        return new Runnable() 
        {
            public void run() {
                TraitementRequete(s,Sock_internat, instruc);
            }
        };
    }
    
    public void TraitementRequete(Socket s, Socket Sock_internat, Statement instruct) 
    {
        int Login = 0;
        try 
        {
            
            while(this.getTypeRequete() != -1)
            {
                while (Login == 0)
                {
                    Login = TraiterRequeteLogin(s, instruct);
                    this.RecevoirRequete(s);
                }
                
                switch(this.getTypeRequete())
                {
                    case 2:
                        System.out.println("Dans verif immat");
                        verif_immatriculation(s, Sock_internat,instruct);
                        
                        break;
                    case 3 : 
                        System.out.println("Dans verif voyageur");
                        verif_voyageur(s, Sock_internat, instruct);
                        break;
                    case 4:
                        System.out.println("Dans get post");
                        get_post(s);
                        break;

                      
                }
                this.RecevoirRequete(s);

            } 
        } catch (IOException ex ) {
            Logger.getLogger(RequeteCONTROLID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RequeteCONTROLID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RequeteCONTROLID.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void get_post(Socket Sock) throws IOException {
         int num = (int)getObjectClasse();
         System.out.println("Le portier c'est connecter au post: " + num);
         ReponseCONTROLID rep = new ReponseCONTROLID(0, true);
         rep.EnvoieReponse(Sock);
    }

    public int TraiterRequeteLogin(Socket sock, Statement instruc) throws IOException
    {


        return 0;
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
