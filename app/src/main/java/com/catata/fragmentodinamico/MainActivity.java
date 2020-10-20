package com.catata.fragmentodinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos instancia del gestor de fragmentos.
        fragmentManager = getSupportFragmentManager();

        //Cuando cargamos un fragmento o lo remplazamos debemos hacerlo en una
        //transaccion.
        //Empezamos la transaccion
        transaction = fragmentManager.beginTransaction();

        //Cargamos el fragmento en el contenedor que hemos creado en el layout
        transaction.add(R.id.contenedor_fragments,new FragmentInicio());

        //Añadimos este fragmento a la pila de fragmentos para cuando pulsamos
        //el botón de volver
        transaction.addToBackStack(null);

        //Como toda transacción la hemos de validar. Hacemos commit
        transaction.commit();
    }

    /*
    * Este método es el manejador onClick de los dos botones
    * Empezamos la transacción y en función del id del botón remplazamos un
    * fragmento u otro. Ojo al replace ya que ya teníamos un fragmento cargado.
    * */
    public void onClick(View view) {
        transaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.btnIrAzul:{
                transaction.replace(R.id.contenedor_fragments,FragmentAzul.newInstance("Esto es el titulo","sdfsd"));
                break;
            }

            case R.id.btnIrRojo:{

                transaction.replace(R.id.contenedor_fragments,new FragmentRojo());
                break;
            }
        }


        transaction.addToBackStack(null);
        transaction.commit();

    }
}