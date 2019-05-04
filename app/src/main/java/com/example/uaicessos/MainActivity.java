package com.example.uaicessos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameField, passwordField, cpfField, emailField ;
    Button button;

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

    private void cadastrarUsuario() {
        if (validaCampos()){
            nameField.setError(getString(R.string.mensagem_erro_nome));
        }
    }

    private boolean validaCampos() {

        String nome = nameField.getText().toString();
        String email = emailField.getText().toString();
        String cpf = cpfField.getText().toString();
        String senha = passwordField.getText().toString();

        if (nome.isEmpty()) {
            nameField.setError(getString(R.string.mensagem_erro_nome));
            return false;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.setError(getString(R.string.mensagem_erro_email));
            return false;
        }

        if (senha.isEmpty()) {
            passwordField.setError(getString(R.string.mensagem_erro_senha));
            return false;
        }

        if (cpf.isEmpty() || !ValidaCPF.isCPF(cpf)){
            cpfField.setError(getString(R.string.mensagem_erro_cpf));
            return false;
        }
        return true;
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
