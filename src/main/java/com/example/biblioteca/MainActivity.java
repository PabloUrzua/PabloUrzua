package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(); // ejecuta mi tarea asíncrona.
            }
        });


        progress.setVisibility(View.INVISIBLE); // desaparece el elemento.
    }


    // Tarea Asíncrona.

    class Task extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... strings) {

            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), GitHub_act.class);
            startActivity(i);


        }
    }

    public void Mostrar(View v)
    {
        ArrayList<String> libros = new ArrayList<>();

        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("Alquimista");
        libros.add("Elpoder");
        libros.add("Despertar");


        Intent i = new Intent(this, GitHub_act.class);
        i.putExtra("listaLibros", libros);
        startActivity(i);


    }
}