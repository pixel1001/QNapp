/*
    Copyright (C) 2017  Ulises Lamas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/

package com.pixel.util;

import com.pixel.qnapp.MainActivity;
import com.pixel.qnapp.R;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.pixel.qnapp.Entradas;
import com.pixel.qnapp.Salidas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase de utileria..
 * Funciones:
 * 1.-Carga Menu de opciones de forma dinamica para las actividades de la app.
 */
public class Utileria {

    private static Utileria utileria;

    private Utileria(){
        // Singleton
    }

    /**
     * Obtener instancia de la clase
     * @return
     */
    public static Utileria getInstance(){
        if(utileria==null){
            utileria = new Utileria();
        }
        return utileria;
    }

    /**
     * Alimenta Menu de opciones, generico para todas las ventanas
     * @param item
     * @param actividad
     * @return
     */
    public boolean cargaMenuOpciones(MenuItem item, Activity actividad){

        int id = item.getItemId();
        System.out.println("id : " + id);
        Intent entrada;
        switch(id) {
            case R.id.action_settings:
                System.out.println("Opcion Settings");
                return true;
            case R.id.action_entradas:
                System.out.println("Opcion Entradas");
                entrada = new Intent(actividad, Entradas.class);
                actividad.startActivity(entrada);
                return true;
            case R.id.action_salidas:
                System.out.println("Opcion Salidas");
                entrada = new Intent(actividad, Salidas.class);
                actividad.startActivity(entrada);
                return true;
        }
        return ((Activity)actividad).onOptionsItemSelected(item);
    }

    /**
     * Obtene mes y dia
     * @return el mes en dia forma MMDD
     */
    public String getMMDD(){
        String mmdd = "";
        Calendar fecha = Calendar.getInstance();
        int mm = fecha.get(Calendar.MONTH)+1;
        int dd = fecha.get(Calendar.DATE);
        if(mm<10)mmdd="0"+mm;
        else mmdd=""+mm;
        if(dd <10)mmdd.concat("0"+dd);
        else mmdd.concat(Integer.toString(dd));
        System.out.println(mmdd);
        return mmdd;
    }

    /**
     *
     * @param yyyy
     * @param mm
     * @param dd
     * @return
     */
    public String formatoFechas(int yyyy, int mm, int dd){
        String fecha = yyyy+"/";
        if(mm<10) fecha.concat("0" + mm +"/");
        else fecha.concat(Integer.toString(mm));
        if(dd<10) fecha.concat("0" + mm + "/");
        else fecha.concat(Integer.toString(dd));
        fecha.concat(yyyy+"/"+mm+"/"+dd);
        return fecha;
    }

}
