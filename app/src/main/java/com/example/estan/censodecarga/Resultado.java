package com.example.estan.censodecarga;

import android.content.Intent;
import android.content.res.Resources;
import android.mtp.MtpConstants;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
   private EditText txtTotal;
   private EditText txtDesviacion;
   private EditText txtReportado;
   private TextView lblResultado;
    private Intent i;
    private Bundle b;
    private Resources r;
    private Button diligenciar;
    private boolean evaluo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        r=this.getResources();
        i = new Intent(this, Form.class);
        b = new Bundle();
        txtTotal = (EditText)findViewById(R.id.txtTotal);
        txtDesviacion=(EditText)findViewById(R.id.txtDesviacion);
        lblResultado=(TextView)findViewById(R.id.lblResultado);
        txtReportado=(EditText)findViewById(R.id.txtReportado);
        txtReportado.setSelected(true);
        txtTotal.setText(""+Metodos.totalizador());
        diligenciar=(Button)findViewById(R.id.btnDiligenciar);
       // diligenciar.setClickable(false);
        evaluo=false;
    }

    public void Evaluar (View v) {

        int desviacion;
        int total;
        int report;
        String res;
        if (validar()) {
            total = Integer.parseInt(txtTotal.getText().toString());
            report = Integer.parseInt(txtReportado.getText().toString());
            desviacion = report - total;

            txtDesviacion.setText("" + desviacion);

            if (total == report) {
                res = "CONFORME";
            } else {
                res = "NO CONFORME";
            }
            lblResultado.setText(res);
            b.putString("res", res);
            b.putString("des", "" + desviacion);
            b.putString("rep", "" + report);
            i.putExtras(b);
            evaluo = true;
            diligenciar.setClickable(true);


        }
    }

        public void generar(View v){
            if(evaluo==false){
                Toast.makeText(this, "Debe evaluar primero", Toast.LENGTH_SHORT).show();
                diligenciar.setClickable(false);
            }else{
                startActivity(i);
            }

    }



    public boolean validar() {
        String aux = r.getString(R.string.error1);
        if (Metodos.validar_aux(txtReportado, aux)) return false;

        return true;

    }
}
