package com.example.tarea4_navegacionconfragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle datosInstancia) {
        super.onCreate(datosInstancia);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, insets) -> {
            Insets bordesSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(bordesSistema.left, bordesSistema.top, bordesSistema.right, bordesSistema.bottom);
            return insets;
        });

        // Inicializar el BottomNavigationView
        BottomNavigationView barraNavegacion = findViewById(R.id.bottom_navigation);

        // Obtener el administrador de fragmentos
        FragmentManager administradorFragmentos = getSupportFragmentManager();

        // Configurar el fragmento inicial (Rojo)
        administradorFragmentos.beginTransaction()
                .replace(R.id.fragment_container, new FragmentoRojo())
                .commit();

        // Configurar el listener para la barra de navegación
        barraNavegacion.setOnItemSelectedListener(item -> {
            Fragment fragmentoSeleccionado = null;

            // Lógica de navegación entre los fragmentos
            if (item.getItemId() == R.id.nav_rojo) {
                fragmentoSeleccionado = new FragmentoRojo();
            } else if (item.getItemId() == R.id.nav_azul) {
                fragmentoSeleccionado = new FragmentoAzul();
            } else if (item.getItemId() == R.id.nav_verde) {
                fragmentoSeleccionado = new FragmentoVerde();
            }

            // Reemplazar el fragmento actual
            if (fragmentoSeleccionado != null) {
                FragmentTransaction transaccion = administradorFragmentos.beginTransaction();
                transaccion.replace(R.id.fragment_container, fragmentoSeleccionado);
                transaccion.addToBackStack(null); // Permitir retroceso entre fragmentos
                transaccion.commit();
            }

            return true; // Indicar que el ítem fue seleccionado correctamente
        });
    }
}
