package br.edu.unis.alunos.appdelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

import br.edu.unis.alunos.appdelogin.classes.Preferences;
import br.edu.unis.alunos.appdelogin.classes.UsersPreferences;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtSenha;
    private Button btnLogin;
    private CheckBox chkLembrar;
    private Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = new UsersPreferences(getApplicationContext(), "SP_USUARIO");

        OsViews();
        StartEvents();
        verificandoUsuario();
    }


    private void OsViews() {
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        chkLembrar = findViewById(R.id.chkLembrar);
    }
    private void StartEvents(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entrar();
            }
        });
    }
    private void verificandoUsuario(){
        if(!preferences.getDados().equals("")){
            iniciandoActivty(true);
        }
    }
    private void Entrar () {
        if(!VerificarLogin()){
            showSnackbar();
            return ;
        }
        preferences.setDados(edtUsuario.getText().toString());

        iniciandoActivty(chkLembrar.isChecked());
    }

    private boolean VerificarLogin(){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if(usuario.equals("Iury") && senha.equals("Iury")){
            return true;
        } else {
            return false;
        }
    }
    private void VerificaUsuario(){
        if(preferences.equals("")){
            iniciandoActivty(true);
        }
    }

    private void iniciandoActivty (boolean staylogged){
        Intent mainIntent = new  Intent(this, MainActivity.class);
        mainIntent.putExtra("MANTER_CONNECTADO", staylogged);
        startActivity(mainIntent);

    }

    private void showSnackbar(){
    View viewLogin = findViewById(android.R.id.content);
    Snackbar.make(viewLogin, R.string.Usuario_ou_senha_errada, Snackbar.LENGTH_SHORT).show();
    }


}
