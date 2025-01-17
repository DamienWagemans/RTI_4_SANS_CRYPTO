package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import ClassesCONTROLID.Voiture;
import ProtocolCONTROLID.ReponseCONTROLID;
import ProtocolCONTROLID.RequeteCONTROLID;
import interface_req_rep.Reponse;
import interface_req_rep.Requete;

public class TaskActivity extends AppCompatActivity {
    private Button change;
    private Button send;
    private Button check;

    private EditText numPlate;

    private TaskActivity TaskActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        this.change = findViewById(R.id.buttonChangePost);
        this.send = findViewById(R.id.buttonSend);
        this.check = findViewById(R.id.buttonCheck);
        this.numPlate = findViewById(R.id.numPlate);


        this.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent otherActivity = new Intent(getBaseContext(), CustomsPostActivity.class);
                startActivity(otherActivity);
            }
        });

        this.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    RequeteCONTROLID req = new RequeteCONTROLID();
                    ReponseCONTROLID rep = new ReponseCONTROLID();
                    requete_from_views rfv;
                    Voiture voiture = new Voiture(numPlate.getText().toString());
                    req.setObjectClasse(voiture);
                    req.setTypeRequete(RequeteCONTROLID.VERIF_IMMATRICULATION);
                    rfv = new requete_from_views(req, requete_from_views.SEND_REQUEST);
                    rep = (ReponseCONTROLID) rfv.execute().get();
                    if(rep.getTypeRequete() == ReponseCONTROLID.IMMAT_OK){
                        //vert
                        Intent otherActivity = new Intent(getBaseContext(), GoodStickersActivity.class);
                        otherActivity.putExtra("voiture", voiture);
                        otherActivity.putExtra("numero_poste",getIntent().getIntExtra("numero_poste", 0));
                        startActivity(otherActivity);
                    }else{
                        //rouge
                        Intent otherActivity = new Intent(getBaseContext(), BadStickersActivity.class);
                        otherActivity.putExtra("voiture", voiture);
                        otherActivity.putExtra("numero_poste",getIntent().getIntExtra("numero_poste", 0));
                        startActivity(otherActivity);
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        this.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getBaseContext(), IncidentActivity.class);
                otherActivity.putExtra("numero_poste",getIntent().getIntExtra("numero_poste", 0));
                startActivity(otherActivity);
            }
        });
    }
}
