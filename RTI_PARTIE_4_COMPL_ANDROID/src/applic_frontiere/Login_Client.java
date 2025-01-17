/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_frontiere;

import ClassesCONTROLID.Voiture;
import ClassesCONTROLID.Login;
import ClassesCONTROLID.Voyageur;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;
import static divers.Config_Applic.pathConfig;
import divers.Persistance_Properties;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dos Santos
 */
public class Login_Client extends javax.swing.JFrame {

    /**
     * Creates new form Login_Client
     */
    private Properties myProperties;
    private Socket cliSock = null;
    private boolean vehicule_ok = false;
    
    public Login_Client() {
        initComponents();
        
        
        
        UsernameLogin.setText("GrosZZ");
        PasswordLogin.setText("Vilvens");
        
        myProperties = Persistance_Properties.LoadProp(pathConfig);
        IpServeurTF.setText(myProperties.getProperty("ip"));
        PortTF.setText(myProperties.getProperty("port"));
 
        this.setTitle("Login-User");
        UsernameLogin.setEnabled(false);
        PasswordLogin.setEnabled(false);
        jButton1.setEnabled(false);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UsernameLogin = new javax.swing.JTextField();
        PasswordLogin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LabelException = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonConnect = new javax.swing.JButton();
        IpServeurTF = new javax.swing.JTextField();
        PortTF = new javax.swing.JTextField();
        Button_Verif_immat = new javax.swing.JButton();
        BookingEx = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_quitter = new javax.swing.JButton();
        jButton_verif_passager = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Login");

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Username:");

        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Password:");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Sign in");
        jButton1.setMaximumSize(new java.awt.Dimension(69, 32));
        jButton1.setMinimumSize(new java.awt.Dimension(69, 32));
        jButton1.setPreferredSize(new java.awt.Dimension(69, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LabelException.setBackground(new java.awt.Color(255, 255, 255));
        LabelException.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Port :");

        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Ip Serveur:");

        ButtonConnect.setBackground(new java.awt.Color(51, 51, 51));
        ButtonConnect.setText("Connect");
        ButtonConnect.setPreferredSize(new java.awt.Dimension(94, 32));
        ButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConnectActionPerformed(evt);
            }
        });

        Button_Verif_immat.setBackground(new java.awt.Color(51, 51, 51));
        Button_Verif_immat.setText("VERIFICATION IMMATRICULATION");
        Button_Verif_immat.setEnabled(false);
        Button_Verif_immat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Verif_immatActionPerformed(evt);
            }
        });

        jButton_quitter.setText("Quitter");
        jButton_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_quitterActionPerformed(evt);
            }
        });

        jButton_verif_passager.setText("VERIFICATION PASSAGER");
        jButton_verif_passager.setEnabled(false);
        jButton_verif_passager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_verif_passagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelException, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(IpServeurTF, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PortTF, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_quitter)
                                .addGap(44, 44, 44))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton_verif_passager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Button_Verif_immat, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BookingEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(LabelException, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IpServeurTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PortTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton_quitter))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(UsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(BookingEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Verif_immat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_verif_passager)
                        .addGap(6, 6, 6)))
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username = UsernameLogin.getText();
        String password = PasswordLogin.getText();
        Login log;
        RequeteCONTROLID req;
        ReponseCONTROLID rep;
        try{
            if(username.equals("") || password.equals(""))
                throw new Exception("CV");
            log = new Login(username, password);
            req = new RequeteCONTROLID(RequeteCONTROLID.LOGIN, log);
            
            req.EnvoieRequete(cliSock); 
            rep = new ReponseCONTROLID();
            rep.RecevoirReponse(cliSock);

            if(rep.getTypeRequete() == ReponseCONTROLID.LOGIN_OK){
                Button_Verif_immat.setEnabled(true);
                jButton_verif_passager.setEnabled(false);
                UsernameLogin.setEnabled(false);
                PasswordLogin.setEnabled(false);
                jButton1.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Login OK", "Login OK", JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Mauvais mot de pass", "Mot de pass incorrect", JOptionPane.ERROR_MESSAGE);
            
        }catch(Exception e){
            if(e.getMessage().equals("CV"))
                LabelException.setText("Veuillez remplir l'ensemble des champs");
            else
                LabelException.setText("Le nom d'utilisateur ou le mot de passe est incorrecte");   
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConnectActionPerformed
        // TODO add your handling code here:
        try
        {
            //gérer exception
            
            String adresse  = IpServeurTF.getText();
            int port = Integer.parseInt(PortTF.getText());
            cliSock = new Socket(adresse, port);
            
            //oos = new ObjectOutputStream(cliSock.getOutputStream());
            //ois = new ObjectInputStream(cliSock.getInputStream());
            
            System.out.println(cliSock.getInetAddress().toString());
            JOptionPane.showMessageDialog(null, "Connexion etablie avec succes", "Connexion", JOptionPane.PLAIN_MESSAGE);
            
            UsernameLogin.setEnabled(true);
            PasswordLogin.setEnabled(true);
            jButton1.setEnabled(true);
            PortTF.setEnabled(false);
            IpServeurTF.setEnabled(false);
            ButtonConnect.setEnabled(false);
        }
        catch (UnknownHostException e)
            { System.err.println("Erreur ! Host non trouvé [" + e + "]"); } 
        
        catch (IOException e)
            { System.err.println("Erreur ! Pas de connexion ? [" + e + "]");}
        
    }//GEN-LAST:event_ButtonConnectActionPerformed

    private void Button_Verif_immatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Verif_immatActionPerformed
        // TODO add your handling code here:
        vehicule_ok = false;
        RequeteCONTROLID req;
        ReponseCONTROLID rep;
        verif_immat vi = new verif_immat(this, true);
        vi.pack();
        vi.show();
        Object [] retour = vi.getObject();
        String mot = (String)retour[0];

        try{

            Voiture voiture = new Voiture(mot);
                    
            req = new RequeteCONTROLID(RequeteCONTROLID.VERIF_IMMATRICULATION, voiture);
            req.EnvoieRequete(cliSock);
            
            rep = new ReponseCONTROLID();
            rep.RecevoirReponse(cliSock);
            
            
            
            
            if(rep.getTypeRequete() == ReponseCONTROLID.IMMAT_FAIL)
            {
               voiture = (Voiture)rep.getObjectClasse();
               if(voiture.getEtat().equals("CONTROLE"))
               {
                   JOptionPane.showMessageDialog(null, "Controle nécessaire, la voiture n'est pas en règle  !!", "Controle!", JOptionPane.ERROR_MESSAGE);
               }
               if(voiture.getEtat().equals("INCONNU"))
               {
                   JOptionPane.showMessageDialog(null, "Cette plaque n'existe pas  !!", "Inconnu!", JOptionPane.ERROR_MESSAGE);
               }
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Voiture en règle, vous pouvez proceder aux controle des passagers", "OK", JOptionPane.INFORMATION_MESSAGE);
                jButton_verif_passager.setEnabled(true);
                vehicule_ok = true;
            }
        }catch(IOException e){
            System.err.println("Erreur ? [" + e.getMessage() + "]"); 
        }catch(ClassNotFoundException e){
            System.out.println("--- erreur sur la classe = " + e.getMessage());
        }
       
    }//GEN-LAST:event_Button_Verif_immatActionPerformed

    private void jButton_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_quitterActionPerformed
        try {
            cliSock.close();
        } catch (IOException ex) {
            Logger.getLogger(Login_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton_quitterActionPerformed

    private void jButton_verif_passagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_verif_passagerActionPerformed
        if(vehicule_ok == true)
        {
            try {
                RequeteCONTROLID req;
                ReponseCONTROLID rep;
                verif_passager vp = new verif_passager(this, true);
                vp.pack();
                vp.show();
                Object [] retour = vp.getObject();
                String mot = (String)retour[0];
                Voyageur voyageur = new Voyageur((String)retour[0], (boolean)retour[1]);
                req = new RequeteCONTROLID(RequeteCONTROLID.VERIF_VOYAGEUR, voyageur);
                req.EnvoieRequete(cliSock);
                
                rep = new ReponseCONTROLID();
                rep.RecevoirReponse(cliSock);
                
                Voyageur voyageur_recu = new Voyageur();
                voyageur_recu = (Voyageur)rep.getObjectClasse();
                //dans le cas ou le voyageur n'existe pas dans la base d edonnée, je met son champs n_reg a "INCONNU"
                if(!voyageur_recu.getN_REG().equals("INCONNU"))
                {
                    //si le voyageur existe, je regarde si il est sensé avoir un permis
                    if(voyageur.isPermis()== true)
                    {
                        if(voyageur_recu.isPermis()==true)
                        {
                            //je verifie si il a bien son permis
                            JOptionPane.showMessageDialog(null, "Voyageur existant et il a bien son permis", "OK", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Le voyageur existe mais il n'a pas son permis", "Pas de permis", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Voyageur existant dans la base de donnée !", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ce voyageur n'existe dans aucune base de donnée", "Voyageur inconnu !! ", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
                
                
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Login_Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vous devez d'abord authentifier le vehicule", "Vehicule a verifier", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton_verif_passagerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookingEx;
    private javax.swing.JButton ButtonConnect;
    private javax.swing.JButton Button_Verif_immat;
    private javax.swing.JTextField IpServeurTF;
    private javax.swing.JLabel LabelException;
    private javax.swing.JTextField PasswordLogin;
    private javax.swing.JTextField PortTF;
    private javax.swing.JTextField UsernameLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_quitter;
    private javax.swing.JButton jButton_verif_passager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
