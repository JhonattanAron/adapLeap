package com.adaptleap.adapleapv1.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "nombre_completo")
    public String NombreCompleto;
    @Column(name = "user_name")
    public String UserName;
    @Column(name = "email")
    public String email;
    @Column(name = "password")
    public String password;
    @Column(name = "telefone")
    public String telefone;
    public Usuarios() {
    }

    public Usuarios(int id, String nombreCompleto, String userName, String email, String password, String telefone) {
        this.id = id;
        NombreCompleto = nombreCompleto;
        UserName = userName;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
