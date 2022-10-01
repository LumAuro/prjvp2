package appvigia.codigo.Model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 50, name = "name")
    private String name;
    @Column(length = 30, name = "username")
    private String username;
    @Column(length = 30, name = "password")
    private String password;
    @Column(length = 50, name = "email")
    private String email;
    @Column(name = "movil")
    private long movil;

    public Usuarios() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Usuarios(int id, String name, String username, String password, String email, long movil) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.movil = movil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMovil() {
        return movil;
    }

    public void setMovil(long movil) {
        this.movil = movil;
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", id=" + id + ", movil=" + movil + ", name=" + name + ", password="
                + password + ", username=" + username + "]";
    }
}