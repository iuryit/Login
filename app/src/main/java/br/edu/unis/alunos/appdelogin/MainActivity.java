package br.edu.unis.alunos.appdelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import br.edu.unis.alunos.appdelogin.classes.Preferences;
import br.edu.unis.alunos.appdelogin.classes.UsersPreferences;

public class MainActivity extends AppCompatActivity {
    private Preferences preferences;
    private TextView MostrandoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Parabens voce conseguiu logar!");

        initViews();

        preferences = new UsersPreferences(getApplicationContext(), "SP_USUARIO");
        MostraUsuario();

        boolean ContinuarConectado = getIntent().getBooleanExtra("MANTER_CONNECTADO", false);
        if (!ContinuarConectado) {
            preferences.remover();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSair:
                sair();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initViews() {
        MostrandoUsuario = findViewById(R.id.MostrandoUsuario);
    }

    private void MostraUsuario() {
        if (preferences.existe()) {
            MostrandoUsuario.setText(preferences.getDados());
        } else
            MostrandoUsuario.setText(getText(R.string.Sem_usuario).toString());
    }
    private void sair() {
        preferences.remover();
        this.finish();
    }
}
