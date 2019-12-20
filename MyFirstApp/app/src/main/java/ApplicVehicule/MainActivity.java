package ApplicVehicule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Applic_Vehicule.R;

import ClassesCONTROLID.Login;
import ClassesRequeteViews.ConnectToServer;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    //Différent composant de l'activité
    private Button log;
    private Button connect;
    private EditText Ip;
    private EditText Port;
    private MainActivity MainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.log = findViewById(R.id.buttonlogin);
        this.connect = findViewById(R.id.buttonconnect);
        this.Ip = findViewById(R.id.IP);
        this.Port = findViewById(R.id.Port);
        this.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if(Ip.getText().toString().isEmpty() || Port.getText().toString().isEmpty())
                        Toast.makeText(MainActivity, "Champs Obligatoire", Toast.LENGTH_LONG).show();
                    else{
                        requete_from_views rfv = new requete_from_views();
                        ConnectToServer cts = new ConnectToServer(Integer.parseInt(Port.getText().toString()), Ip.getText().toString());
                        rfv.setRequete(cts);
                        rfv.setType(requete_from_views.CONNECT);
                        if((boolean)rfv.execute().get()){
                            Toast.makeText(MainActivity, "Connexion effectuer", Toast.LENGTH_LONG).show();
                            log.setEnabled(true);
                            connect.setEnabled(false);
                        }
                        else
                            Toast.makeText(MainActivity, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        this.log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    requete_from_views rfv = new requete_from_views();
                    RequeteCONTROLID req = new RequeteCONTROLID();
                    Login log = new Login("Miguel","1234");
                    req.setTypeRequete(RequeteCONTROLID.LOGIN);
                    req.setObjectClasse(log);
                    rfv.setType(requete_from_views.SEND_REQUEST);
                    rfv.setRequete(req);
                    ReponseCONTROLID rep = (ReponseCONTROLID) rfv.execute().get();
                    if(rep.getTypeRequete() == ReponseCONTROLID.LOGIN_OK){
                        Toast.makeText(MainActivity, "Login effectuer", Toast.LENGTH_SHORT).show();
                        Intent otherActivity = new Intent(getBaseContext(), CustomsPostActivity.class);
                        startActivity(otherActivity);
                    }
                    else
                        Toast.makeText(MainActivity, "Login Fail", Toast.LENGTH_LONG).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
