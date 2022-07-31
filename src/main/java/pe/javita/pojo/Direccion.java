package pe.javita.pojo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "direccion")
@Entity
public class Direccion implements Serializable {

    @Id
    @Column(name = "idDir")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDir;

    @Column(name = "calle")
    private String calle;

    @Column(name = "cp")
    private String cp;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idAd")
    private Admin admin;

    public Direccion() {
    }

    public Direccion(String calle, String cp) {
        this.calle = calle;
        this.cp = cp;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Direccion(String cp) {
        this.cp = cp;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDir=" + idDir + ", calle=" + calle + ", cp=" + cp + ", admin=" + admin + '}';
    }



}
