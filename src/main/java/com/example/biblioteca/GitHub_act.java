package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clase.Plan;

public class GitHub_act extends AppCompatActivity {

    private Spinner spin;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_act);

        spin = (Spinner)findViewById(R.id.spn);
        text = (TextView)findViewById(R.id.tv1);

        ArrayList<String> listaLibro = (ArrayList<String>) getIntent().getSerializableExtra("listaLibros");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLibro);
        spin.setAdapter(adapt);
    }
    public void Calcular(View v)
    {
        String Libros = spin.getSelectedItem().toString();
        Plan plan = new Plan();

        int resultFarenheith = plan.getFarenheith();
        int resulRevival = plan.getRevival();
        int resultAlquimista = plan.getAlquimista();

        if(Libros.equals("Farenheith"))
        {
            text.setText("El Valor Del Libro Farenheith es: "+ resultFarenheith);
        }
        if(Libros.equals("Revival"))
        {
            text.setText("El Valor Del Libro Revival es: "+ resulRevival);
        }
        if(Libros.equals("Alquimista"))
        {
            text.setText("El Valor Del Libro Alquimista es: "+ resultAlquimista);
        }
    }
}