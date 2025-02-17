package com.example.tarea4_navegacionconfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class FragmentoRojo extends Fragment {

    public FragmentoRojo() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle datosInstancia) {
        // Inflar el diseño correspondiente para este fragmento
        return inflador.inflate(R.layout.fragmento_rojo, contenedor, false);
    }
}
