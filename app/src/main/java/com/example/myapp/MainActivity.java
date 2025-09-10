package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la interfaz
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // Configurar el Spinner con categorías principales (Sobres, Paquetes, Cajas)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Envio_Category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Configurar el botón para mostrar los tipos específicos de la categoría seleccionada
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la categoría seleccionada
                String selectedCategory = spinner.getSelectedItem().toString();

                // Mostrar los tipos de envíos según la categoría seleccionada
                switch (selectedCategory) {
                    case "Cajas":
                        textView.setText(getFormattedEnvios(R.array.Cajas));
                        break;
                    case "Paquetes":
                        textView.setText(getFormattedEnvios(R.array.Paquetes));
                        break;
                    case "Sobres":
                        textView.setText(getFormattedEnvios(R.array.Sobres));
                        break;
                    default:
                        textView.setText("Selecciona una categoría válida");
                        break;
                }
            }
        });
    }

    // Método para formatear la lista de tipos de envíos
    private String getFormattedEnvios(int enviosArrayId) {
        String[] envios = getResources().getStringArray(enviosArrayId);
        StringBuilder formattedEnvios = new StringBuilder();
        for (String envio : envios) {
            formattedEnvios.append("• ").append(envio).append("\n");
        }
        return formattedEnvios.toString().trim(); // Eliminar el último salto de línea
    }
}
