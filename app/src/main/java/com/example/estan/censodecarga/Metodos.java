package com.example.estan.censodecarga;

import android.content.Context;
import android.os.Environment;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Format;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by Estan on 19/12/2017.
 */

public class Metodos {
    private ArrayList<Aparato>aparatos;

    public static int valorCargaItem (String itemem){
        int w=0, t=0;
        if(itemem.equalsIgnoreCase("Foco (Bombillo) 60w"))w=60;
        if(itemem.equalsIgnoreCase("Foco (Bombillo) 100w"))w=100;
        if(itemem.equalsIgnoreCase("Lámpara fluorescente 20w"))w=20;
        if(itemem.equalsIgnoreCase("Lámpara Fluorescente 40w"))w=40;
        if(itemem.equalsIgnoreCase("Lámpara fluorescente 75w"))w=75;
        if(itemem.equalsIgnoreCase("Lámpara Fluorescente 96w"))w=96;
        if(itemem.equalsIgnoreCase("Abanico de techo"))w=167;
        if(itemem.equalsIgnoreCase("Abanico de mesa"))w=57;
        if(itemem.equalsIgnoreCase("Abanico patton pequeño"))w=160;
        if(itemem.equalsIgnoreCase("Abanico patton grande"))w=240;
        if(itemem.equalsIgnoreCase("Aire acondiciondo 3/4 HP"))w=560;
        if(itemem.equalsIgnoreCase("Aire acondicionado 1 HP"))w=746;
        if(itemem.equalsIgnoreCase("Aire acondicionado 1.5 HP"))w=1120;
        if(itemem.equalsIgnoreCase("Aire acondicionado 2 HP"))w=1492;
        if(itemem.equalsIgnoreCase("Calentador"))w=1755;
        if(itemem.equalsIgnoreCase("Estufa 1 hornilla"))w=1085;
        if(itemem.equalsIgnoreCase("Estufa 2 hornilla"))w=2170;
        if(itemem.equalsIgnoreCase("Estufa 3 hornilla"))w=3255;
        if(itemem.equalsIgnoreCase("Estufa 4 hornilla"))w=4340;
        if(itemem.equalsIgnoreCase("Nevera pequeña"))w=140;
        if(itemem.equalsIgnoreCase("Nevera mediana"))w=189;
        if(itemem.equalsIgnoreCase("Nevera grande"))w=227;
        if(itemem.equalsIgnoreCase("Horno eléctrico"))w=2400;
        if(itemem.equalsIgnoreCase("Horno microondas"))w=1040;
        if(itemem.equalsIgnoreCase("Batidora"))w=151;
        if(itemem.equalsIgnoreCase("Lavador platos automática"))w=1050;
        if(itemem.equalsIgnoreCase("Licuadora"))w=350;
        if(itemem.equalsIgnoreCase("Exprimidor"))w=125;
        if(itemem.equalsIgnoreCase("Tostadora de pan"))w=900;
        if(itemem.equalsIgnoreCase("Tritemuradora"))w=550;
        if(itemem.equalsIgnoreCase("Lavadora de ropa pequeña"))w=590;
        if(itemem.equalsIgnoreCase("Lavadora de ropa grande"))w=1050;
        if(itemem.equalsIgnoreCase("Secadora de ropa"))w=1500;
        if(itemem.equalsIgnoreCase("Plancha"))w=367;
        if(itemem.equalsIgnoreCase("Aspiradora"))w=700;
        if(itemem.equalsIgnoreCase("Máquina de coser"))w=110;
        if(itemem.equalsIgnoreCase("Secador de pelo"))w=800;
        if(itemem.equalsIgnoreCase("Registradora"))w=40;
        if(itemem.equalsIgnoreCase("Congelador pequeño"))w=250;
        if(itemem.equalsIgnoreCase("Congelador grande"))w=417;
        if(itemem.equalsIgnoreCase("Enfriador 2 cuerpos"))w=987;
        if(itemem.equalsIgnoreCase("Enfriador 3 cuerpo"))w=2831;
        if(itemem.equalsIgnoreCase("Nevera mostrador sencilla"))w=426;
        if(itemem.equalsIgnoreCase("Nevera mostrador doble"))w=776;
        if(itemem.equalsIgnoreCase("Botellero pequeño 7 pies"))w=303;
        if(itemem.equalsIgnoreCase("Botellero mediano 10 pies"))w=464;
        if(itemem.equalsIgnoreCase("Botellero grande 19 pies"))w=493;
        if(itemem.equalsIgnoreCase("Vitemrina Calentadora"))w=100;
        if(itemem.equalsIgnoreCase("Vitemrina enfriadora"))w=278;
        if(itemem.equalsIgnoreCase("Cafetera"))w=625;
        if(itemem.equalsIgnoreCase("Asador"))w=1500;
        if(itemem.equalsIgnoreCase("Waflera"))w=1100;
        if(itemem.equalsIgnoreCase("Fotocopiadora pequeña"))w=700;
        if(itemem.equalsIgnoreCase("Fotocopiadora grande"))w=1102;
        if(itemem.equalsIgnoreCase("Soldador"))w=2000;
        if(itemem.equalsIgnoreCase("Taladro"))w=150;
        if(itemem.equalsIgnoreCase("Brilladora"))w=150;
        if(itemem.equalsIgnoreCase("Motobomba 1 HP"))w=740;
        if(itemem.equalsIgnoreCase("Motobomba 1.5 HP"))w=1200;
        if(itemem.equalsIgnoreCase("Motobomba 2 HP"))w=1500;
        if(itemem.equalsIgnoreCase("Televisor pequeño"))w=80;
        if(itemem.equalsIgnoreCase("Televisor grande"))w=200;
        if(itemem.equalsIgnoreCase("Televisor LCD 19"))w=100;
        if(itemem.equalsIgnoreCase("Televisor LCD 26"))w=124;
        if(itemem.equalsIgnoreCase("Televisor LCD 32"))w=155;
        if(itemem.equalsIgnoreCase("Televisor PLASMA 32"))w=190;
        if(itemem.equalsIgnoreCase("Televisor PLASMA 47"))w=330;
        if(itemem.equalsIgnoreCase("Computador"))w=100;
        if(itemem.equalsIgnoreCase("Radio"))w=22;
        if(itemem.equalsIgnoreCase("Video"))w=60;
        if(itemem.equalsIgnoreCase("Reproductor DVD"))w=25;
        if(itemem.equalsIgnoreCase("Grabadora"))w=22;
        if(itemem.equalsIgnoreCase("Equipo de sonido"))w=100;
        if(itemem.equalsIgnoreCase("Impresora residencial"))w=180;

        return w;
    }

    public static int filaItem (String item){
        int f=0;
        if(item.equalsIgnoreCase("Foco (Bombillo) 60w"))f=10;
        if(item.equalsIgnoreCase("Foco (Bombillo) 100w"))f=11;
        if(item.equalsIgnoreCase("Lámpara fluorescente 20w"))f=12;
        if(item.equalsIgnoreCase("Lámpara Fluorescente 40w"))f=13;
        if(item.equalsIgnoreCase("Lámpara fluorescente 75w"))f=14;
        if(item.equalsIgnoreCase("Lámpara Fluorescente 96w"))f=15;
        if(item.equalsIgnoreCase("Abanico de techo"))f=17;
        if(item.equalsIgnoreCase("Abanico de mesa"))f=18;
        if(item.equalsIgnoreCase("Abanico patton pequeño"))f=19;
        if(item.equalsIgnoreCase("Abanico patton grande"))f=20;
        if(item.equalsIgnoreCase("Aire acondiciondo 3/4 HP"))f=21;
        if(item.equalsIgnoreCase("Aire acondicionado 1 HP"))f=22;
        if(item.equalsIgnoreCase("Aire acondicionado 1.5 HP"))f=23;
        if(item.equalsIgnoreCase("Aire acondicionado 2 HP"))f=24;
        if(item.equalsIgnoreCase("Calentador"))f=25;
        if(item.equalsIgnoreCase("Estufa 1 hornilla"))f=27;
        if(item.equalsIgnoreCase("Estufa 2 hornilla"))f=28;
        if(item.equalsIgnoreCase("Estufa 3 hornilla"))f=29;
        if(item.equalsIgnoreCase("Estufa 4 hornilla"))f=30;
        if(item.equalsIgnoreCase("Nevera pequeña"))f=31;
        if(item.equalsIgnoreCase("Nevera mediana"))f=32;
        if(item.equalsIgnoreCase("Nevera grande"))f=33;
        if(item.equalsIgnoreCase("Horno eléctrico"))f=34;
        if(item.equalsIgnoreCase("Horno microondas"))f=35;
        if(item.equalsIgnoreCase("Batidora"))f=36;
        if(item.equalsIgnoreCase("Lavador platos automática"))f=37;
        if(item.equalsIgnoreCase("Licuadora"))f=38;
        if(item.equalsIgnoreCase("Exprimidor"))f=39;
        if(item.equalsIgnoreCase("Tostadora de pan"))f=40;
        if(item.equalsIgnoreCase("Tritemuradora"))f=41;
        if(item.equalsIgnoreCase("Lavadora de ropa pequeña"))f=43;
        if(item.equalsIgnoreCase("Lavadora de ropa grande"))f=44;
        if(item.equalsIgnoreCase("Secadora de ropa"))f=45;
        if(item.equalsIgnoreCase("Plancha"))f=46;
        if(item.equalsIgnoreCase("Aspiradora"))f=47;
        if(item.equalsIgnoreCase("Máquina de coser"))f=48;
        if(item.equalsIgnoreCase("Secador de pelo"))f=49;
        if(item.equalsIgnoreCase("Registradora"))f=10;
        if(item.equalsIgnoreCase("Congelador pequeño"))f=11;
        if(item.equalsIgnoreCase("Congelador grande"))f=12;
        if(item.equalsIgnoreCase("Enfriador 2 cuerpos"))f=13;
        if(item.equalsIgnoreCase("Enfriador 3 cuerpo"))f=14;
        if(item.equalsIgnoreCase("Nevera mostrador sencilla"))f=15;
        if(item.equalsIgnoreCase("Nevera mostrador doble"))f=16;
        if(item.equalsIgnoreCase("Botellero pequeño 7 pies"))f=17;
        if(item.equalsIgnoreCase("Botellero mediano 10 pies"))f=18;
        if(item.equalsIgnoreCase("Botellero grande 19 pies"))f=19;
        if(item.equalsIgnoreCase("Vitemrina Calentadora"))f=20;
        if(item.equalsIgnoreCase("Vitemrina enfriadora"))f=21;
        if(item.equalsIgnoreCase("Cafetera"))f=22;
        if(item.equalsIgnoreCase("Asador"))f=23;
        if(item.equalsIgnoreCase("Waflera"))f=24;
        if(item.equalsIgnoreCase("Fotocopiadora pequeña"))f=25;
        if(item.equalsIgnoreCase("Fotocopiadora grande"))f=26;
        if(item.equalsIgnoreCase("Soldador"))f=28;
        if(item.equalsIgnoreCase("Taladro"))f=29;
        if(item.equalsIgnoreCase("Brilladora"))f=30;
        if(item.equalsIgnoreCase("Motobomba 1 HP"))f=31;
        if(item.equalsIgnoreCase("Motobomba 1.5 HP"))f=32;
        if(item.equalsIgnoreCase("Motobomba 2 HP"))f=33;
        if(item.equalsIgnoreCase("Televisor pequeño"))f=35;
        if(item.equalsIgnoreCase("Televisor grande"))f=36;
        if(item.equalsIgnoreCase("Televisor LCD 19"))f=37;
        if(item.equalsIgnoreCase("Televisor LCD 26"))f=38;
        if(item.equalsIgnoreCase("Televisor LCD 32"))f=39;
        if(item.equalsIgnoreCase("Televisor PLASMA 32"))f=40;
        if(item.equalsIgnoreCase("Televisor PLASMA 47"))f=41;
        if(item.equalsIgnoreCase("Computador"))f=42;
        if(item.equalsIgnoreCase("Radio"))f=43;
        if(item.equalsIgnoreCase("Video"))f=44;
        if(item.equalsIgnoreCase("Reproductor DVD"))f=45;
        if(item.equalsIgnoreCase("Grabadora"))f=46;
        if(item.equalsIgnoreCase("Equipo de sonido"))f=47;
        if(item.equalsIgnoreCase("Impresora residencial"))f=48;

        return f;
    }

    public static int columnaItem (String item){
        int c=0;
        if(item.equalsIgnoreCase("Foco (Bombillo) 60w"))c=2;
        if(item.equalsIgnoreCase("Foco (Bombillo) 100w"))c=2;
        if(item.equalsIgnoreCase("Lámpara fluorescente 20w"))c=2;
        if(item.equalsIgnoreCase("Lámpara Fluorescente 40w"))c=2;
        if(item.equalsIgnoreCase("Lámpara fluorescente 75w"))c=2;
        if(item.equalsIgnoreCase("Lámpara Fluorescente 96w"))c=2;
        if(item.equalsIgnoreCase("Abanico de techo"))c=2;
        if(item.equalsIgnoreCase("Abanico de mesa"))c=2;
        if(item.equalsIgnoreCase("Abanico patton pequeño"))c=2;
        if(item.equalsIgnoreCase("Abanico patton grande"))c=2;
        if(item.equalsIgnoreCase("Aire acondiciondo 3/4 HP"))c=2;
        if(item.equalsIgnoreCase("Aire acondicionado 1 HP"))c=2;
        if(item.equalsIgnoreCase("Aire acondicionado 1.5 HP"))c=2;
        if(item.equalsIgnoreCase("Aire acondicionado 2 HP"))c=2;
        if(item.equalsIgnoreCase("Calentador"))c=2;
        if(item.equalsIgnoreCase("Estufa 1 hornilla"))c=2;
        if(item.equalsIgnoreCase("Estufa 2 hornilla"))c=2;
        if(item.equalsIgnoreCase("Estufa 3 hornilla"))c=2;
        if(item.equalsIgnoreCase("Estufa 4 hornilla"))c=2;
        if(item.equalsIgnoreCase("Nevera pequeña"))c=2;
        if(item.equalsIgnoreCase("Nevera mediana"))c=2;
        if(item.equalsIgnoreCase("Nevera grande"))c=2;
        if(item.equalsIgnoreCase("Horno eléctrico"))c=2;
        if(item.equalsIgnoreCase("Horno microondas"))c=2;
        if(item.equalsIgnoreCase("Batidora"))c=2;
        if(item.equalsIgnoreCase("Lavador platos automática"))c=2;
        if(item.equalsIgnoreCase("Licuadora"))c=2;
        if(item.equalsIgnoreCase("Exprimidor"))c=2;
        if(item.equalsIgnoreCase("Tostadora de pan"))c=2;
        if(item.equalsIgnoreCase("Tritemuradora"))c=2;
        if(item.equalsIgnoreCase("Lavadora de ropa pequeña"))c=2;
        if(item.equalsIgnoreCase("Lavadora de ropa grande"))c=2;
        if(item.equalsIgnoreCase("Secadora de ropa"))c=2;
        if(item.equalsIgnoreCase("Plancha"))c=2;
        if(item.equalsIgnoreCase("Aspiradora"))c=2;
        if(item.equalsIgnoreCase("Máquina de coser"))c=2;
        if(item.equalsIgnoreCase("Secador de pelo"))c=2;
        if(item.equalsIgnoreCase("Registradora"))c=6;
        if(item.equalsIgnoreCase("Congelador pequeño"))c=6;
        if(item.equalsIgnoreCase("Congelador grande"))c=6;
        if(item.equalsIgnoreCase("Enfriador 2 cuerpos"))c=6;
        if(item.equalsIgnoreCase("Enfriador 3 cuerpo"))c=6;
        if(item.equalsIgnoreCase("Nevera mostrador sencilla"))c=6;
        if(item.equalsIgnoreCase("Nevera mostrador doble"))c=6;
        if(item.equalsIgnoreCase("Botellero pequeño 7 pies"))c=6;
        if(item.equalsIgnoreCase("Botellero mediano 10 pies"))c=6;
        if(item.equalsIgnoreCase("Botellero grande 19 pies"))c=6;
        if(item.equalsIgnoreCase("Vitemrina Calentadora"))c=6;
        if(item.equalsIgnoreCase("Vitemrina enfriadora"))c=6;
        if(item.equalsIgnoreCase("Cafetera"))c=6;
        if(item.equalsIgnoreCase("Asador"))c=6;
        if(item.equalsIgnoreCase("Waflera"))c=6;
        if(item.equalsIgnoreCase("Fotocopiadora pequeña"))c=6;
        if(item.equalsIgnoreCase("Fotocopiadora grande"))c=6;
        if(item.equalsIgnoreCase("Soldador"))c=6;
        if(item.equalsIgnoreCase("Taladro"))c=6;
        if(item.equalsIgnoreCase("Brilladora"))c=6;
        if(item.equalsIgnoreCase("Motobomba 1 HP"))c=6;
        if(item.equalsIgnoreCase("Motobomba 1.5 HP"))c=6;
        if(item.equalsIgnoreCase("Motobomba 2 HP"))c=6;
        if(item.equalsIgnoreCase("Televisor pequeño"))c=6;
        if(item.equalsIgnoreCase("Televisor grande"))c=6;
        if(item.equalsIgnoreCase("Televisor LCD 19"))c=6;
        if(item.equalsIgnoreCase("Televisor LCD 26"))c=6;
        if(item.equalsIgnoreCase("Televisor LCD 32"))c=6;
        if(item.equalsIgnoreCase("Televisor PLASMA 32"))c=6;
        if(item.equalsIgnoreCase("Televisor PLASMA 47"))c=6;
        if(item.equalsIgnoreCase("Computador"))c=6;
        if(item.equalsIgnoreCase("Radio"))c=6;
        if(item.equalsIgnoreCase("Video"))c=6;
        if(item.equalsIgnoreCase("Reproductor DVD"))c=6;
        if(item.equalsIgnoreCase("Grabadora"))c=6;
        if(item.equalsIgnoreCase("Equipo de sonido"))c=6;
        if(item.equalsIgnoreCase("Impresora residencial"))c=6;



        return c;
    }

    public static void agregarAlArray(ArrayList<Aparato>aparatos){
        aparatos=Datos.obtener();
        for (int i = 0; i < aparatos.size(); i++) {
                String item = aparatos.get(i).getNombre().toString();
               Celda c = new Celda(filaItem(item), columnaItem(item), ""+aparatos.get(i).getCantidad(), true);
               Celda t = new Celda(filaItem(item), columnaItem(item)+1, ""+aparatos.get(i).getTotal(), true);


               c.guardar();
               t.guardar();



        }
    }

    public static int totalizador(){
        ArrayList<Aparato> aparatos;
        aparatos=Datos.obtener();
        int sumatoria =0;

        for (int i = 0; i <aparatos.size() ; i++) {
            sumatoria = sumatoria+aparatos.get(i).getTotal();
        }
        return  sumatoria;
    }

    public static int  desviacion(int rep){
        int tot =totalizador();
        int desv = rep-tot;
        return desv;
    }

    public static String resultado(int rep){
        if(rep==totalizador()){
            return "CONFORME";
        }
        else {
            return "NO CONFORME";
        }
    }


    public static void escribirXls (ArrayList<Celda> celdas, Context context){
        celdas=listaCeldas.obtener();
        File sd = Environment.getExternalStorageDirectory();
        String in = "/sdcard/test.xls";
        String out = "/sdcard/test2.xls";
        File in_file = new File(in);
        File out_file = new File(out);

        try {


            WorkbookSettings settings=new WorkbookSettings();
            settings.setEncoding("iso-8859-1");
            Workbook workbook = Workbook.getWorkbook(in_file,settings);
            WritableWorkbook copyWorkbook = workbook.createWorkbook(out_file, workbook);
            workbook.close();
            WritableSheet sheet = copyWorkbook.getSheet(0);
            for (int i = 0; i < celdas.size(); i++) {
                if(celdas.get(i).getEsNumero()==true) {
                    sheet.addCell(new Number(celdas.get(i).getColumna(), celdas.get(i).getFila(), Double.parseDouble(celdas.get(i).getDato())));
                }else{
                    sheet.addCell(new Label(celdas.get(i).getColumna(), celdas.get(i).getFila(), celdas.get(i).getDato()));
                }


            }
            copyWorkbook.write();
            copyWorkbook.close();


            Toast.makeText(context, "Datos Actualizados", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "No encuentro el archivo", Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean validar_aux(TextView t, String mensaje) {
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return false;
    }

    public static boolean validar_cero(TextView t, String mensaje) {
        if (Integer.parseInt(t.getText().toString())==0){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return false;
    }

}
