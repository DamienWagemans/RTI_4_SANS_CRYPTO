/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_frontiere.serveurpoolthreads;

import ProtocolCONTROLID.RequeteCONTROLID;
import interface_req_rep.Requete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damien
 */
public class ThreadServeur extends Thread{
    private int port;
    private int nbr_client;
    private SourceTaches tachesAExecuter;
    private ServerSocket SSocket = null;
    private Socket socket_serv = null;
    private RequeteCONTROLID req = new RequeteCONTROLID();
    private Statement instruc;

    public ServerSocket getSSocket() {
        return SSocket;
    }

    public void setSSocket(ServerSocket SSocket) {
        this.SSocket = SSocket;
    }

    public Socket getSocket_carte() {
        return socket_serv;
    }

    public void setSocket_carte(Socket Socket_serv) {
        this.socket_serv = Socket_serv;
    }

    public Statement getInstruc() {
        return instruc;
    }

    public void setInstruc(Statement instruc) {
        this.instruc = instruc;
    }
    
    
    public ThreadServeur(int p, int nbr_c, SourceTaches st, Socket socket_c)
    {
        nbr_client = nbr_c;
        port = p; 
        tachesAExecuter = st; 
        socket_serv = socket_c;
    }
    
    @Override
    public void run() 
    {
        try 
        {
            SSocket = new ServerSocket(port); 
        }
        catch (IOException e) 
        {
            System.err.println("Erreur de port d'écoute ! ? [" + e + "]"); 
            System.exit(1); 
        }
        // Démarrage du pool de threads
        for (int i=0; i<nbr_client; i++)
        {
            ThreadClient thr = new ThreadClient(tachesAExecuter, "Thread du pool n°" + String.valueOf(i));
            thr.start(); 
        }
        try{
            //Connexion à la base de donnée
            System.out.println("Essai de connexion JDBC");
            Class leDriver= Class.forName("oracle.jdbc.driver.OracleDriver");
            //connexion a la db
            
            //Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL","BD_REGNAT","Damien");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","RTI5","unizuniz1999");
            con.setAutoCommit(false);
            System.out.println("Connexion à la BDD RTI réalisée");
            instruc= con.createStatement();
            System.out.println("Création d'une instance d'instruction pour cette connexion");
            
            Socket CSocket;
            while (!Thread.interrupted()) 
            {
               
                System.out.println("************ Serveur en attente");
               
                CSocket = SSocket.accept(); 
                System.out.println(CSocket.getRemoteSocketAddress().toString()+ " / accept / thread serveur");
                
                ObjectInputStream ois=null; 
                ois = new ObjectInputStream(CSocket.getInputStream());
                Requete temp= (Requete) ois.readObject();
                
                System.out.println(temp.getClass().getName());
                Runnable travail = temp.createRunnable(CSocket, socket_serv, instruc); 
                if (travail != null)
                {
                    
                    tachesAExecuter.recordTache(travail);


                     System.out.println("Travail mis dans la file"); 
                }
                else System.out.println("Pas de mise en file"); 
            }
        }catch (SQLException  e) {
            Logger.getLogger(ThreadServeur.class.getName()).log(Level.SEVERE, null, e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServeur.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException e) 
        {
            System.err.println("Erreur d'accept ! ? [" + e.getMessage() + "]"); 
            System.exit(1); 
        }

        

    } 
}
