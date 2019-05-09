package com.example.uaicessos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText nameField, passwordField, cpfField, emailField ;
    Button button;
    Boolean validador = true;
    ArrayAdapter usuarios;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameField = (EditText) findViewById(R.id.name);
        passwordField = (EditText) findViewById(R.id.password);
        cpfField = (EditText) findViewById(R.id.cpf);
        emailField = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.saveButon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    public String cadastrarUsuario() {

        if (validaCampos()){
            Usuario usuario = montaUsuario();

            return usuario.toJSON();
        }
        return null;
    }

    private Usuario montaUsuario(){
        String nome = nameField.getText().toString();
        String email = emailField.getText().toString();
        String cpf = cpfField.getText().toString();
        String senha = passwordField.getText().toString();
        Usuario usuario = new Usuario(nome, email, cpf, senha);

        return usuario;
    }


    private Boolean validaCampos() {

        Usuario u = montaUsuario();

        if (u.getNome().isEmpty()) {
            nameField.setError(getString(R.string.mensagem_erro_nome));
            validador = false;
        }

        if (u.getEmail().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(u.getEmail()).matches()) {
            emailField.setError(getString(R.string.mensagem_erro_email));
            validador = false;
        }

        if (u.getSenha().isEmpty()) {
            passwordField.setError(getString(R.string.mensagem_erro_senha));
            validador =  false;
        }

        if (u.getCpf().isEmpty() || !ValidaCPF.isCPF(u.getCpf())){
            cpfField.setError(getString(R.string.mensagem_erro_cpf));
            validador = false;
        }


        return validador;
    }
}
