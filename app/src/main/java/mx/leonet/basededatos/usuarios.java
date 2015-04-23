package mx.leonet.basededatos;

/**
 * Created by L3oNeT on 21/04/15.
 */
public class usuarios {

    private String idusuario;
    private String user;
    private String password;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String email;

    public usuarios(String idusuario, String user, String password, String nombre, String apellidop, String apellidom, String email) {
        this.idusuario = idusuario;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.email = email;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public String getEmail() {
        return email;
    }
}
