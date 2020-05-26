package com.uca.capas.parcial.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
    
    @Id
    @GeneratedValue(generator = "cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_libro")
    private Integer codigoLibro;

    @Column(name = "s_titulo")
    private String titulo;

    @Column(name = "s_autor")
    private String autor;

    @Column(name = "f_ingreso")
    private Date fechaIngreso;

    @Column(name = "b_estado")
    private Boolean estado;

    @Column(name = "s_isbn")
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;

    public Libro(){}

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}