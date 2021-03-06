package com.example.uaicessos;

import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

class Usuario {
    String nome;
    String email;
    String cpf;
    String senha;

    public Usuario() {}

    public Usuario(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toJSON(){

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("nome", getNome());
            jsonObject.put("email", getEmail());
            jsonObject.put("senha", getSenha());
            jsonObject.put("cpf", getCpf());

            return jsonObject.toString();
        } catch (JSONException e) {

            e.printStackTrace();
            return "";
        }
}
}

