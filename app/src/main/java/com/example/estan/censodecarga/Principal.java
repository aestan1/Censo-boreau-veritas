package com.example.estan.censodecarga;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Aparato> aparatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Principal.this,AgregarAparato.class);
                startActivity(i);
                finish();

            }
        });



        tabla = (TableLayout)findViewById(R.id.tabla);
        aparatos=Datos.obtener();

        for (int i = 0; i <aparatos.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);


            c1.setText(aparatos.get(i).getNombre());
            c2.setText(""+aparatos.get(i).getCantidad());
            c3.setText(""+aparatos.get(i).getTotal());
            c2.setTextAlignment(3);
            c3.setTextAlignment(3);



            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);

            tabla.addView(fila);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_resultado) {
            Intent i = new Intent(Principal.this,Resultado.class);
            startActivity(i);

            return true;
        }



        return super.onOptionsItemSelected(item);
    }





}
