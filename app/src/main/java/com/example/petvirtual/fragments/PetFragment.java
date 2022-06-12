package com.example.petvirtual.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.petvirtual.IdiomaActivity;
import com.example.petvirtual.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView btnIdioma, btnBanho, btnBrincar, imgPet, imgLimpeza, imgBrincar;

    protected View vista;

    public PetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PetFragment newInstance(String param1, String param2) {
        PetFragment fragment = new PetFragment();
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
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_pet, container, false);

        btnIdioma = (ImageView) vista.findViewById(R.id.btnIdiomaPet);
        btnBanho = (ImageView) vista.findViewById(R.id.btnBanho);
        btnBrincar = (ImageView) vista.findViewById(R.id.btnBrincar);
        imgPet = (ImageView) vista.findViewById(R.id.imgPet);
        imgLimpeza = (ImageView) vista.findViewById(R.id.imgLimpeza);
        imgBrincar = (ImageView) vista.findViewById(R.id.imgBrincar);

        btnBanho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPet.setImageResource(R.drawable.pet_triste);
                imgLimpeza.setImageResource(R.drawable.barra_75);
            }
        });

        btnBrincar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPet.setImageResource(R.drawable.pet_feliz);
                imgBrincar.setImageResource(R.drawable.barra_50);
            }
        });

        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), IdiomaActivity.class);
                i.putExtra("TelaAnterior", "Menu");
                startActivity(i);
            }
        });
        return vista;
    }
}