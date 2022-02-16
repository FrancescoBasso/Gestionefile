package com.example.gestionefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    Button btnLeggi;
    Button btnScrivi;
    EditText edtText;
    TextView txtView;
    GestoreMetodi gest;
    Context c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeggi = (Button) findViewById(R.id.btnLeggi);
        btnScrivi = (Button) findViewById(R.id.btnScrivi);
        edtText = (EditText) findViewById(R.id.edtText);
        txtView = (TextView) findViewById(R.id.txtView);

        gest = new GestoreMetodi();

        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = getApplicationContext();
                //String percorso = c.getPackageCodePath();
                String risultato = gest.leggiFile("filedaleggere.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(),risultato,Toast.LENGTH_LONG).show();

            }
        });

        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ritorno = gest.scriviFile("filedaleggere.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(),ritorno, Toast.LENGTH_LONG).show();
            }
        });


    }

}