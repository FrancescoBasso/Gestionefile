package com.example.gestionefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GestoreMetodi {
    String nomeFile;
    StringBuilder sb;
    Context c;
    final String TAG = "FM";


    public GestoreMetodi(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public GestoreMetodi() {

    }

    public String leggiFile(String nomeFile, Context c){
        String str= "";
        sb = new StringBuilder();

        try {
            //!) Apertura del file.
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));

            //Stream di Byte --> Stream a caratteri --> bufferizzazione
            String inputString;

            while ((inputString = inputReader.readLine()) != null){

                sb.append(inputString);
            }

            //Eccezioni
        } catch (FileNotFoundException e) {
            Log.e( TAG , "Errore nell'apertura del file");
            return "FNF";
        } catch (IOException e) {
            Log.e(TAG ,e.toString());
            return "IO ERROR";
        }
        //Buffered Reader --> Stream orientato a caratteri per leggere le righe
        //Input Stream --> classe astratta che non si può orientare
        //2) ciclo sulle righe per leggere riga per riga
        // accordo ogni riga alla stringa


        return sb.toString();



    }

    public String scriviFile(String nomeFile, Context c ){
        FileOutputStream fileO;
        String esito = "";
        String testo = "Questo è il testo del file";
        try{
            fileO = c.openFileOutput(nomeFile,Context.MODE_PRIVATE);
            fileO.write(testo.getBytes());
            fileO.close();
            esito = "Scrittura corretta";
        }
        catch(FileNotFoundException e){
            esito = "Attenzione errore in apertura";

        }
        catch (IOException e){
            esito = "Errore in scrittura";
        }
        return esito;


    }
}
