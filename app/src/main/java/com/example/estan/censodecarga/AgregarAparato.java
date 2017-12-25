package com.example.estan.censodecarga;

import android.content.Intent;
import android.content.res.Resources;
import android.icu.text.Collator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AgregarAparato extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Resources resources;
    private Spinner cmbCategoria;
    private Spinner cmbItem;
    private EditText txtCantidad;
    private String cat[];
    private String itemAlumbrado[];
    private String itemClimatizacion[];
    private String itemCocina[];
    private String itemElectro[];
    private String itemComercial[];
    private String itemIndustrial[];
    private String itemTvs[];
    private Intent i;
    private ArrayList<Aparato> aparatos;
    private ArrayList<Celda> celdas;
    private Resources r;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_aparato);
        resources = this.getResources();
        cmbCategoria = (Spinner)findViewById(R.id.cmbCategoria);
        cmbItem=(Spinner)findViewById(R.id.cmbItem);
        txtCantidad=(EditText)findViewById(R.id.txtCantidad);
        cat = resources.getStringArray(R.array.cat);
        r=this.getResources();


        ArrayAdapter<CharSequence> adapterCat =  ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbCategoria.setAdapter(adapterCat);
        cmbCategoria.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    int[] item = {R.array.itemVacio, R.array.itemAlumbrado, R.array.itemClimatizacion, R.array.itemCocina, R.array.itemElectrodomesticos, R.array.itemComercial, R.array.itemIndustrial, R.array.itemTvS};
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, item[i], android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbItem.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void agregarAparato(View v) {
        aparatos = Datos.obtener();

        if (validar()) {
            int cant, aux, w, total, pos = 0;
            String it;
            Boolean buscar = false;
            aux = cmbItem.getSelectedItemPosition();
            cant = Integer.parseInt(txtCantidad.getText().toString());
            it = cmbItem.getItemAtPosition(aux).toString();
            w = Metodos.valorCargaItem(it);

            for (int i = 0; i < aparatos.size(); i++) {
                if (it.equalsIgnoreCase(aparatos.get(i).getNombre())) {
                    buscar = true;
                    pos = i;

                }
            }

            if (buscar) {
                aparatos.get(pos).setCantidad(cant);
                total = aparatos.get(pos).getCantidad() * w;
                aparatos.get(pos).setTotal(total);
                Toast.makeText(this, R.string.mensaje1, Toast.LENGTH_SHORT).show();
            } else {
                total = cant * w;
                Aparato a = new Aparato(it, cant, total);
                Toast.makeText(this, R.string.mensaje1, Toast.LENGTH_SHORT).show();
                a.guardar();
                Metodos.agregarAlArray(aparatos);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(AgregarAparato.this,Principal.class);
        startActivity(i);
        finish();
    }


    public boolean validar() {
        int se=cmbCategoria.getSelectedItemPosition();
        String aux = r.getString(R.string.error1);
        String cero = r.getString(R.string.error2);

        if (se==0){
            if(se==0) {
                Toast.makeText(this, r.getString(R.string.error3), Toast.LENGTH_SHORT ).show();
                return false;
            }
        }
        else if (Metodos.validar_aux(txtCantidad, aux) ) return false;
        return true;

    }
}
