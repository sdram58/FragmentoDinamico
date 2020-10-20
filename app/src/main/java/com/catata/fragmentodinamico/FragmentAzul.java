package com.catata.fragmentodinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAzul#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAzul extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAzul() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAzul.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAzul newInstance(String param1, String param2) {
        FragmentAzul fragment = new FragmentAzul();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment y lo cargamos en una variable
        // v de tipo View
        View v = inflater.inflate(R.layout.fragment_azul, container, false);

        // A partir de v (View) obtenemos los elementos del layout que queramos
        // usar o modificar.
        TextView tvAzul = (TextView)v.findViewById(R.id.tvAzul);
        tvAzul.setText(mParam1);

        Button btnAzul = (Button)v.findViewById(R.id.btnAzul);


        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Pulsado botón del frg azul", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}