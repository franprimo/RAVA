package com.example.franprimo.rava;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BotonesFragment extends Fragment {

    ListaListener mCallBack;
    PalabraListener mPalabra;
    PuntuacionListener mPuntos;

    public interface ListaListener{
        public void onItemPressed(int id);
    }

    public interface PalabraListener{
        public void wordToShow(String word);
    }

    public interface PuntuacionListener{
        public void puntosToShow(int puntos);
    }

    //Declaracion de los colores de los botones como constantes
    public static final String RED = "#ff2b2e";
    public static final String YELLOW = "#fffc39";
    public static final String GREEN = "#37ff21";
    public static final String BLUE = "#2b29ff";

    LetrasFragment lf = new LetrasFragment();

    private int puntuacion;
    private String item;
    private String palabra;
    private String[] elementos = {"Rojo", "Amarillo", "Verde", "Azul"};
    private Integer[] numeros = new Integer[4];

    public BotonesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //CREACION DE LOS ELEMENTOS DE LA LISTA Y LO QUE ESTA NECESITA PARA FUNCIONAR.

        ArrayList<String> elemLista = new ArrayList<String>(Arrays.asList(elementos));
        //Falta crear el adaptador, la lista y pasarle a la lista el adaptador. Hacemos los botonoes mediante lista.
        //De esta forma, usare el listener de la lista.
        MenuAdapter adapter = new MenuAdapter(getActivity(), elemLista);
        ListView lista = (ListView) getActivity().findViewById(R.id.listView);
        lista.setAdapter(adapter);
        //Listener de la lista
        lista.setOnItemClickListener(new miListener());
        //----------------------------------------------------------------------------

        actualizar();
    }

    //Este metodo genera la palabra que aparece en el fragment letras, y cada vez que pulsas un
    //boton, vuelve a generar otra palabra para que siga el juego.
    public void actualizar(){
        //INSTRUCCIONES PARA COLOCAR LA PALABRA EN SU FRAGMENT CORRESPONDIENTE
        //Del array de elementos de la lista, cojo uno de ellos al azar mediante un numero aleatorio
        //y lo guardo en la variable palabra.
        int posicion = numeroAleatorio();
        palabra = elementos[posicion];
        //Le envio al activity Main la palabra que tiene que mostrar el otro fragment.
        mPalabra.wordToShow(palabra);
        //---------------------------------------------------------------------
    }

    //Listener propio para la lista.
    private class miListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            item = (String) parent.getItemAtPosition(position);
            check(item);
            Log.i("TAG: ", item);
            Log.i("Palabra: ", palabra);
        }
    }

    //Metodo que devuelve un numero aleatorio entre 0 y 4, este ultimo excluido.
    public int numeroAleatorio(){
        int num = 0;
        Random r = new Random();
        num = r.nextInt(4);
        return num;
    }

    public void check(String aComprobar){
        String seleccion = aComprobar;
        boolean correcto = seleccion.equals(palabra);
        if(correcto){
            Log.i("Check: ", "correcto");
            puntuacion = puntuacion + 5;
            mPuntos.puntosToShow(puntuacion);
            actualizar();
        }else{
            Log.i("Check: ", "no iguales");
            puntuacion = puntuacion - 5;
            mPuntos.puntosToShow(puntuacion);
            actualizar();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mPalabra = (PalabraListener) activity;
            mPuntos = (PuntuacionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ListFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPalabra = null;
        mPuntos = null;
    }

}
