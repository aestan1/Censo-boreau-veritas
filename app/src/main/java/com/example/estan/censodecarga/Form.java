package com.example.estan.censodecarga;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Form extends AppCompatActivity {
    private ArrayList<Aparato> aparatos;
    private Intent i;
    private Bundle b;
    private EditText txtAuditor, txtCiudad,txtNic, txtOrden,  txtCensoReport, txtTotal,
            txtResultado, txtDesviacion, txtUsuario, txtObservaciones;
    private Spinner cmbTipoCenso;
    private String[] tipoCenso;
    private Resources r;
    private Uri uri;
    private LinearLayout layoutForm;
    private ImageButton btnGuardar;
    private String FullPath;
    String auditor, ciudad, nic, orden, tipo, report, tot, res, desv, user, obs, resu, desvi, rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        r=this.getResources();
        aparatos=Datos.obtener();
        b = getIntent().getExtras();
        tipoCenso = r.getStringArray(R.array.tipoCenso);
        resu = b.getString("res");
        desvi=b.getString("des");
        rep=b.getString("rep");
        layoutForm=findViewById(R.id.layoutForm);
        btnGuardar=findViewById(R.id.btnGuardar);
        txtAuditor=findViewById(R.id.txtAuditor);
        txtCiudad=findViewById(R.id.txtCiudad);
        txtNic=findViewById(R.id.txtNic);
        txtOrden=findViewById(R.id.txtOrden);
        cmbTipoCenso=findViewById(R.id.cmbTipoCenso);
        txtCensoReport=findViewById(R.id.txtCensoReport);
        txtTotal=findViewById(R.id.txtTotal);
        txtResultado=findViewById(R.id.txtResultado);
        txtDesviacion=findViewById(R.id.txtDesviacion);
        txtUsuario=findViewById(R.id.txtUsuario);
        txtObservaciones=findViewById(R.id.txtObservaciones);

        ArrayAdapter<CharSequence> adapterTipo =  ArrayAdapter.createFromResource(this, R.array.tipoCenso, android.R.layout.simple_spinner_item);
        cmbTipoCenso.setAdapter(adapterTipo);
        int totalizador = Metodos.totalizador();
        //if(totalizador!=0) {
            txtTotal.setText(""+totalizador);
            txtResultado.setText(resu);
            txtDesviacion.setText(desvi);
            txtCensoReport.setText(rep);
        //}else{
          //  txtTotal.setText("0");
        //}
        layoutForm.setVisibility(View.INVISIBLE);
        btnGuardar.setVisibility(View.INVISIBLE);
    }

    public void generar (View r){
        if(validar()) {
            ArrayList<Celda> celdas;
            celdas = listaCeldas.obtener();
            auditor = "" + txtAuditor.getText();
            ciudad = "" + txtCiudad.getText();
            nic = "" + txtNic.getText();
            orden = "" + txtOrden.getText();
            tipo = "" + cmbTipoCenso.getSelectedItem();
            report = "" + txtCensoReport.getText();
            tot=""+txtTotal.getText();
            res=""+txtResultado.getText();
            desv=""+txtDesviacion.getText();
            // tot=""+txtTotal.getText();
            user = "" + txtUsuario.getText();
            obs = "" + txtObservaciones.getText();
            celdas.add(new Celda(1, 5, auditor, false));
            celdas.add(new Celda(2, 5, ciudad, false));
            celdas.add(new Celda(3, 5, nic, false));
            celdas.add(new Celda(4, 5, orden, false));
            celdas.add(new Celda(5, 5, tipo, false));
            celdas.add(new Celda(6, 5, report, false));
            celdas.add(new Celda(51, 5, user, false));
            celdas.add(new Celda(55, 1, obs, false));
            celdas.add(new Celda(51, 1, tot, true));
            celdas.add(new Celda(52, 1, res, true));
            celdas.add(new Celda(53, 1, desv, true));



            Toast.makeText(this, "Procesando", Toast.LENGTH_SHORT).show();
            Metodos.escribirXls(celdas, this, FullPath );
        }
    }

    public boolean validar() {
        String aux = r.getString(R.string.error1);
        String mensajeOs = "La O.S. debe ser de 8 digitos";
        String mensajeNic = "El Nic debe ser de 7 digitos";
        if (Metodos.validar_aux(txtAuditor, aux)) return false;
        else if (Metodos.validar_aux(txtCiudad, aux)) return false;
        else if (Metodos.validar_aux(txtNic, aux)) return false;
        else if (Metodos.validar_nic(txtNic, mensajeNic)) return false;
        else if (Metodos.validar_aux(txtOrden, aux)) return false;
        else if (Metodos.validar_os(txtOrden, mensajeOs)) return false;
        else if (Metodos.validar_spiner(cmbTipoCenso)){
            Toast.makeText(this, R.string.error4, Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (Metodos.validar_aux(txtUsuario, aux)) return false;
        else if (Metodos.validar_aux(txtObservaciones, aux)) return false;

        return true;

    }

    public void seleccionar_plantilla(View v){
        Intent i = new Intent();
        i.setType("document/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Ubique el archivo plantilla.xls"),1);

    }
    protected void onActivityResult(int requesCode, int resultCode, Intent data){
        super.onActivityResult(requesCode,resultCode,data);
        if(requesCode==1&&resultCode == RESULT_OK){
            uri = data.getData();
            if(uri!=null){
                FullPath = uri.getPath();

               // String path = fullpath.substring(0,fullpath.length()-13);
                Toast.makeText(this, FullPath, Toast.LENGTH_SHORT).show();
                layoutForm.setVisibility(View.VISIBLE);
                btnGuardar.setVisibility(View.VISIBLE);
            }else if (resultCode == Activity.RESULT_CANCELED){
                Intent i = new Intent(this,Form.class);
                startActivity(i);
                finish();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(Form.this,Resultado.class);
        startActivity(i);
        finish();
    }



}
