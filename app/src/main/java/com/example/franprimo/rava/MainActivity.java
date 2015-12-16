package com.example.franprimo.rava;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements BotonesFragment.ListaListener, BotonesFragment.PalabraListener, BotonesFragment.PuntuacionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Colocamos los fragments es sus respectivos contenedores
        LetrasFragment lf = (LetrasFragment) getFragmentManager().findFragmentById(R.id.letras_fragm);
        BotonesFragment bf = (BotonesFragment) getFragmentManager().findFragmentById(R.id.botones_fragm);
        PuntosFragment pf = (PuntosFragment) getFragmentManager().findFragmentById(R.id.puntos_fragm);
    }

    //Metodo que recibe los datos que nos envia el fragment de los botones y este ejecuta la accion
    //que tenga que hacer.
    public void onItemPressed(int id){

    }

    //Metodo que recibe la palabra que se ha generado en el fragment botones y que se le envia al
    //fragment palabra.
    public void wordToShow(String word){
        String palabraAMostrar = word;
        //Comunicacion del activity con el fragment letras.
        LetrasFragment lf = (LetrasFragment) getFragmentManager().findFragmentById(R.id.letras_fragm);
        lf.texto(palabraAMostrar);
    }

    //Metodo que recibe la puntuacion del fragment botones y la envia al fragment puntuacion.
    public void puntosToShow(int p){
        int ptos = p;
        PuntosFragment pf = (PuntosFragment) getFragmentManager().findFragmentById(R.id.puntos_fragm);
        pf.puntos(ptos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
