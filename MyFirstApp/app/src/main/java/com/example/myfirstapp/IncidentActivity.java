package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;

public class IncidentActivity extends AppCompatActivity {
    private EditText contenu_accident;
    private Button bouton_envoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);

        this.bouton_envoyer = findViewById(R.id.buttonsend_declarer_accident);
        this.contenu_accident = findViewById (R.id.contenu_accident);

        this.bouton_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accident = contenu_accident.getText().toString();
                accident = (getIntent().getIntExtra("numero_poste", 0) + " : " + accident);

                RequeteCONTROLID req = new RequeteCONTROLID(RequeteCONTROLID.DECLARER_ACCIDENT, accident);

                requete_from_views rfv = new requete_from_views();
                rfv.setType(requete_from_views.SEND_REQUEST);
                rfv.setRequete(req);

                ReponseCONTROLID rep = null;
                try
                {
                    rep = (ReponseCONTROLID)rfv.execute().get();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(rep.getTypeRequete() == ReponseCONTROLID.ACK){
                    //next view
                    Toast.makeText(IncidentActivity.this, "Accident déclaré", Toast.LENGTH_SHORT).show();
                    Intent otherActivity = new Intent(getBaseContext(), TaskActivity.class);
                    otherActivity.putExtra("numero_poste",getIntent().getIntExtra("numero_poste", 0));
                    startActivity(otherActivity);
                }
                else
                {
                    Toast.makeText(IncidentActivity.this, "Erreur lors de l'envoi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
