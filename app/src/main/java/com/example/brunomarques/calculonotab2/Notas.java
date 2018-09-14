package com.example.brunomarques.calculonotab2;

import android.widget.EditText;

public class Notas {
    private EditText editNota;
    private double ValueNota;
    private String resultadoNotaBase;
    private double ValorCorte;

    public void setEditNota(EditText editNota) {
        this.editNota = editNota;
    }

    public EditText getEditNota() {
        return editNota;
    }

    public void setValueNota(double valueNota) {
        ValueNota = valueNota;
    }

    public double getValueNota() {
        return ValueNota;
    }

    public String getResultadoNotaBase() {
        return resultadoNotaBase;
    }

    public void setResultadoNotaBase(String resultadoNotaBase) {
        this.resultadoNotaBase = resultadoNotaBase;
    }

    public double getValorCorte() {
        return ValorCorte;
    }

    public void setValorCorte(double valorCorte) {
        ValorCorte = valorCorte;
    }
}