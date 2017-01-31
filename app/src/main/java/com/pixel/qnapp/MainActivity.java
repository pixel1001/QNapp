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

package com.pixel.qnapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.pixel.arch.AdmArch;
import com.pixel.util.Utileria;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setListenersBotones();

        //this.actualizaTotales();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        //return super.onOptionsItemSelected(item);
        return Utileria.getInstance().cargaMenuOpciones(item, this);

    }

    /**
     * Actualiza los totales a solicitud
     * Establece valor de archivo totales en caja de texto de entradas y salidas
     */
    public void muestraTotales(){
        AdmArch admArch = new AdmArch();
        String[] archTotales=admArch.getTotales();
        ((EditText) findViewById(R.id.etxtEntradas)).setText(archTotales[0]);
        ((EditText) findViewById(R.id.etxtSalidas)).setText(archTotales[1]);
        ((EditText) findViewById(R.id.etxtSaldo)).setText(archTotales[2]);
        admArch=null;
    }

    private void actualizaTotales(){
        AdmArch admArch = new AdmArch();
        String[] archTotales=new String[2];
        archTotales[0] = ((EditText) findViewById(R.id.etxtEntradas)).getText().toString();
        archTotales[1] = ((EditText) findViewById(R.id.etxtSalidas)).getText().toString();
        archTotales[2] = ((EditText) findViewById(R.id.etxtSaldo)).getText().toString();
        admArch.setTotales(archTotales);
    }

    private void setListenersBotones(){
        final String valorOrigEnt = ((EditText)findViewById(R.id.etxtEntradas)).getText().toString();
        final String valorOrigSal = ((EditText)findViewById(R.id.etxtSalidas)).getText().toString();
        final String valorOrigSld = ((EditText)findViewById(R.id.etxtSaldo)).getText().toString();
        FloatingActionButton floatingConfMain = (FloatingActionButton) findViewById(R.id.floatingConfMain);
        floatingConfMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FloatingActionButton) findViewById(R.id.floatingConfCanel)).setVisibility(View.VISIBLE);
                ((FloatingActionButton) findViewById(R.id.floatingConfigGuard)).setVisibility(View.VISIBLE);
                ((FloatingActionButton) findViewById(R.id.floatingConfMain)).setVisibility(View.GONE);
                ((EditText) findViewById(R.id.etxtEntradas)).setEnabled(true);
                ((EditText) findViewById(R.id.etxtSalidas)).setEnabled(true);
                ((EditText) findViewById(R.id.etxtSaldo)).setEnabled(true);
                // invocar el llamado para restablecer los datos
            }
        });

        FloatingActionButton floatingConfigGuard = (FloatingActionButton) findViewById(R.id.floatingConfigGuard);
        floatingConfigGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FloatingActionButton) findViewById(R.id.floatingConfCanel)).setVisibility(View.GONE);
                ((FloatingActionButton) findViewById(R.id.floatingConfigGuard)).setVisibility(View.GONE);
                ((FloatingActionButton) findViewById(R.id.floatingConfMain)).setVisibility(View.VISIBLE);
                ((EditText) findViewById(R.id.etxtEntradas)).setEnabled(false);
                ((EditText) findViewById(R.id.etxtSalidas)).setEnabled(false);
                ((EditText) findViewById(R.id.etxtSaldo)).setEnabled(false);
                // invocar el llamado para guardar los datos

            }
        });

        FloatingActionButton floatingConfigCancel = (FloatingActionButton) findViewById(R.id.floatingConfCanel);
        floatingConfigGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FloatingActionButton) findViewById(R.id.floatingConfCanel)).setVisibility(View.GONE);
                ((FloatingActionButton) findViewById(R.id.floatingConfigGuard)).setVisibility(View.GONE);
                ((FloatingActionButton) findViewById(R.id.floatingConfMain)).setVisibility(View.VISIBLE);
                // invocar el llamado para restablecer los datos.
                ((EditText)findViewById(R.id.etxtEntradas)).setText(valorOrigEnt);
                ((EditText)findViewById(R.id.etxtSalidas)).setText(valorOrigSal);
                ((EditText)findViewById(R.id.etxtSaldo)).setText(valorOrigSld);
                ((EditText) findViewById(R.id.etxtEntradas)).setEnabled(false);
                ((EditText) findViewById(R.id.etxtSalidas)).setEnabled(false);
                ((EditText) findViewById(R.id.etxtSaldo)).setEnabled(false);
            }
        });

    }

}
