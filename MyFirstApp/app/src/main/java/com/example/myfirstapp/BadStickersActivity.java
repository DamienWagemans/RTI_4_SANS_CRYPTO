package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import ClassesCONTROLID.Voiture;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;

public class BadStickersActivity extends AppCompatActivity {
    private Button confirmer;
    private TextView welcome;
    private TextView immatriculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_stickers);

        this.confirmer = findViewById( R.id.CONFIRMATION);
        this.welcome = findViewById(R.id.bad_activity_welcome);
        this.immatriculation = findViewById(R.id.immat_texte);


        Voiture voiture = new Voiture((Voiture)getIntent().getSerializableExtra("voiture"));

        this.immatriculation.setText(voiture.getImmatriculation());


        this.confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Voiture voiture = new Voiture((Voiture)getIntent().getSerializableExtra("voiture"));
                voiture.setEtat("ROUGE");
                RequeteCONTROLID req = new RequeteCONTROLID();
                ReponseCONTROLID rep = new ReponseCONTROLID();
                requete_from_views rfv;
                req.setObjectClasse(voiture);
                req.setTypeRequete(RequeteCONTROLID.STICKERS);
                rfv = new requete_from_views(req, requete_from_views.SEND_REQUEST);
                try
                {
                    rep = (ReponseCONTROLID) rfv.execute().get();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(rep.getTypeRequete() == ReponseCONTROLID.ACK){
                    //vert
                    Toast.makeText(BadStickersActivity.this, "OK !", Toast.LENGTH_LONG).show();
                    Intent otherActivity = new Intent(getBaseContext(), TaskActivity.class);
                    otherActivity.putExtra("numero_poste",getIntent().getIntExtra("numero_poste", 0));
                    startActivity(otherActivity);
                }
                else
                {
                    Toast.makeText(BadStickersActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
