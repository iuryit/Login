package br.edu.unis.alunos.appdelogin.classes;

import android.content.Context;

public class UsersPreferences extends Preferences {
    public UsersPreferences(Context context, String nomeArquivo) {
        super(context, nomeArquivo);
    }

    @Override
    public void setDados(String dados) {
        editor.putString("nome", dados);
        editor.commit();
    }

    @Override
    public String getDados() {
        if (preferences.contains("nome")) {
            return preferences.getString("nome", "");
        } else {
            return "";
        }
    }

    @Override
    public boolean existe() {
        return (preferences.contains("nome"));

    }

    @Override
    public void remover() {
        editor.remove("nome");
        editor.commit();
    }
}