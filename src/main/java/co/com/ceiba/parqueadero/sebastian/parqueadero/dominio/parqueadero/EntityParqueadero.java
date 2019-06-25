package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Parqueadero
 */
@Entity
@Table(name = "paqueadero")
public class EntityParqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_parqueadero;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int cupos_moto;

    @Column(nullable = false)
    private int cupos_carro;

    private int total_cupos;
    private int valor_moto_hora;
    private int valor_moto_dia;
    private int valor_carro_hora;
    private int valor_carro_dia;

    public EntityParqueadero(String nombre) {
        this.nombre = nombre;
        this.datos_estaticos();
    }

    public EntityParqueadero() {
        this.datos_estaticos();
    }

    private void datos_estaticos() {
        this.valor_moto_hora = 500;
        this.valor_moto_dia = 8000;
        this.valor_carro_hora = 4000;
        this.valor_carro_dia = 1000;
        this.cupos_moto = 10;
        this.cupos_carro = 20;
        this.total_cupos = cupos_moto + cupos_carro;
    }

    public long getid_parqueadero() {
        return this.id_parqueadero;
    }

    public void setid_parqueadero(long id_parqueadero) {
        this.id_parqueadero = id_parqueadero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupos_moto() {
        return this.cupos_moto;
    }

    public void setCupos_moto(int cupos_moto) {
        this.cupos_moto = cupos_moto;
    }

    public int getCupos_carro() {
        return this.cupos_carro;
    }

    public void setCupos_carro(int cupos_carro) {
        this.cupos_carro = cupos_carro;
    }

    public int getTotal_cupos() {
        return this.total_cupos;
    }

    public void setTotal_cupos(int total_cupos) {
        this.total_cupos = total_cupos;
    }

    public int getValor_moto_hora() {
        return this.valor_moto_hora;
    }

    public void setValor_moto_hora(int valor_moto_hora) {
        this.valor_moto_hora = valor_moto_hora;
    }

    public int getValor_moto_dia() {
        return this.valor_moto_dia;
    }

    public void setValor_moto_dia(int valor_moto_dia) {
        this.valor_moto_dia = valor_moto_dia;
    }

    public int getValor_carro_hora() {
        return this.valor_carro_hora;
    }

    public void setValor_carro_hora(int valor_carro_hora) {
        this.valor_carro_hora = valor_carro_hora;
    }

    public int getValor_carro_dia() {
        return this.valor_carro_dia;
    }

    public void setValor_carro_dia(int valor_carro_dia) {
        this.valor_carro_dia = valor_carro_dia;
    }

}