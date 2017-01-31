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

package com.pixel.arch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by pixel on 06/11/2016.
 */

public class AdmArch {

    String[] arrArch = new String[4];

    public AdmArch(){

        arrArch[0] = "/qnapp/config.data";
        arrArch[1] = "/qnapp/totales/totales.data";
        arrArch[2] = "/qnapp/entradas/";
        arrArch[3] = "/qnapp/salidas/";


        // Validacion de existencia de archivo para su creación.
        for(int i = 0; i<arrArch.length;i++){
            File archivo = new File(arrArch[i]);
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                }catch(IOException exception){
                    exception.printStackTrace();
                    System.out.print("Exception en la creacion del archivo " + arrArch[i]);
                }
            }
        }

    }

    /**
     * Obtener el total de entradas
     * @return
     */
    public String[] getTotales(){
        String arrTotales[] = new String[2];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(arrArch[1]));
            arrTotales[0] = br.readLine();
            arrTotales[1] = br.readLine();
            arrTotales[2] = br.readLine();
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
            System.out.print("No se encontro archivo " + arrArch[1]);
        }catch(IOException exception){
            exception.printStackTrace();
            System.out.print("Error al leer archivo " + arrArch[1]);
        }finally {
            if(br!=null) {
                try{br.close();}catch(IOException exception){exception.printStackTrace();}
            }
        }
        return arrTotales;
    }

    /**
     * Establece el totales en archivo.
     * @param arrTotales
     */
    public void setTotales(String[] arrTotales){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(arrArch[1]));
            bw.write(arrTotales[0]);
            bw.newLine();
            bw.write(arrTotales[1]);
            bw.newLine();
            bw.write(arrTotales[2]);
            bw.flush();
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
            System.out.print("No se encontro archivo " + arrArch[1]);
        }catch(IOException exception){
            exception.printStackTrace();
            System.out.print("Error al leer archivo " + arrArch[1]);
        }finally {
            if(bw!=null) {
                try{bw.flush();bw.close();}catch(IOException exception){exception.printStackTrace();}
            }
        }
    }

    /**
     * Generar corte del mes, cuando el usuario solicite.
     */
    public void generaCorteMes(){

    }

    /**
     * Registra la entrada de dinero
     */
    public void saveEntrada(){

    }

    /**
     *
     * @return
     */
    public List getEntradas(){
        return null;
    }

    /**
     * Registra la salida de diner, recibe la fecha de generación,
     * @fecha recibe la fecha de generacion y en caso de no existir archivo, lo crea.
     * @importe importe de la salida
     * @formapago la forma de pago de la salida
     * @descripcion descripcion y concept del pago.
     */
    public void saveSalida(){

    }

    /**
     *
     * @return
     */
    public List getSalidas(){
        return null;
    }

}
