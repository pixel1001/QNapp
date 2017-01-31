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

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private EditText txtFecha;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar fecha = Calendar.getInstance();
        int yyyy = fecha.get(Calendar.YEAR);
        int mm = fecha.get(Calendar.MONTH);
        int dd = fecha.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, yyyy, mm, dd);
    }

    /**
     * Establece la fecha despues de la selecciòn del usuario.
     * @param view
     * @param yyyy
     * @param mm
     * @param dd
     */
    public void onDateSet(DatePicker view, int yyyy, int mm, int dd) {
        txtFecha.setText(Utileria.getInstance().formatoFechas(yyyy, mm, dd));
    }

    /**
     * Metodo para compartir objeto de fecha que serà actualizado
     */
    public void setTxtFecha(EditText txtFecha){
        this.txtFecha = txtFecha;
    }
}
