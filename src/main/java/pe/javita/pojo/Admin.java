package pe.javita.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "admin")
@Entity
public class Admin implements Serializable {

    @Column(name = "idAd")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAd;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "fechaCreacion")
    private Timestamp fechaCreacion;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Direccion> direccion;

    public Admin() {

    }

    public Admin(String nombre, String cargo, Timestamp fechaCreacion) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdAd() {
        return idAd;
    }

    public void setIdAd(int idAd) {
        this.idAd = idAd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Admin [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion=" + fechaCreacion
                + "]";
    }

}
