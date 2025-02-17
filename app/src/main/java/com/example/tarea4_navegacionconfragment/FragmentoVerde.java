package com.example.tarea4_navegacionconfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class FragmentoVerde extends Fragment {

    public FragmentoVerde() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle datosInstancia) {
        // Inflar el diseño correspondiente para este fragmento
        return inflador.inflate(R.layout.fragmento_verde, contenedor, false);
    }
}
