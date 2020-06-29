package br.edu.unis.alunos.appdelogin.classes;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class Preferences {

    protected SharedPreferences preferences;
    protected SharedPreferences.Editor editor;

    public Preferences(Context context , String arquivo){
        preferences = context.getSharedPreferences(arquivo, 0);
        editor = preferences.edit();
    }
    abstract public void setDados(String dados);

    abstract public String getDados();

    abstract public boolean existe();

    abstract public void remover();

}

