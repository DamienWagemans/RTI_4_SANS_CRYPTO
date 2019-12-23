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
import interface_req_rep.Requete;

public class CustomsPostActivity extends AppCompatActivity {

    private Button buttonOk;
    private EditText numPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customs_post);


        this.buttonOk = findViewById(R.id.buttonOk);
        this.numPost  = findViewById(R.id.numPost);


        this.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num = Integer.parseInt(numPost.getText().toString());
                    requete_from_views rfv = new requete_from_views();
                    RequeteCONTROLID req = new RequeteCONTROLID();
                    req.setObjectClasse(num);
                    if(num == 0)
                    {
                        Disconnect stop = new Disconnect();
                        if((boolean)stop.execute().get()==true)
                        {
                            Toast.makeText(CustomsPostActivity.this, "OK", Toast.LENGTH_SHORT).show();
                            Intent otherActivity = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(otherActivity);
                        }
                        else
                        {
                            Toast.makeText(CustomsPostActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        req.setTypeRequete(RequeteCONTROLID.GET_POST);

                        rfv.setType(requete_from_views.SEND_REQUEST);
                        rfv.setRequete(req);
                        ReponseCONTROLID rep = (ReponseCONTROLID) rfv.execute().get();
                        if ((boolean) rep.getObjectClasse() == true) {
                            //next view
                            Toast.makeText(CustomsPostActivity.this, "Connecté au poste", Toast.LENGTH_SHORT).show();
                            Intent otherActivity = new Intent(getBaseContext(), TaskActivity.class);
                            otherActivity.putExtra("numero_poste", num);
                            startActivity(otherActivity);
                        }
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
