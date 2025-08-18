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

        // Configurar el Spinner con las categorías de razas
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dog_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Configurar el botón para mostrar las razas específicas
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la categoría seleccionada
                String selectedCategory = spinner.getSelectedItem().toString();

                // Mostrar las razas específicas según la categoría seleccionada
                switch (selectedCategory) {
                    case "Pastores":
                        textView.setText(getFormattedBreeds(R.array.pastores_breeds));
                        break;
                    case "Terriers":
                        textView.setText(getFormattedBreeds(R.array.terriers_breeds));
                        break;
                    case "Bulldogs":
                        textView.setText(getFormattedBreeds(R.array.bulldogs_breeds));
                        break;
                    case "Perros de caza":
                        textView.setText(getFormattedBreeds(R.array.perros_de_caza_breeds));
                        break;
                    case "Perros pequeños":
                        textView.setText(getFormattedBreeds(R.array.perros_pequenos_breeds));
                        break;
                    default:
                        textView.setText("Selecciona una categoría");
                        break;
                }
            }
        });
    }

    // Método para formatear las razas como una cadena de texto
    private String getFormattedBreeds(int breedsArrayId) {
        String[] breeds = getResources().getStringArray(breedsArrayId);
        StringBuilder formattedBreeds = new StringBuilder();
        for (String breed : breeds) {
            formattedBreeds.append(breed).append("\n");
        }
        return formattedBreeds.toString().trim(); // Eliminar el último salto de línea
    }
}