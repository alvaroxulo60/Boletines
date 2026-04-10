package ejercicio3;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Usuario {
    @Expose
    private String userName;
    @Expose(serialize = false)
    private String password;
    @Expose
    private String email;
    @Expose
    private List<Direccion> direcciones;

    public Usuario(String userName, String password, String email, List<Direccion> direccion) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.direcciones = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", direccion=" + direcciones +
                '}';
    }
}
