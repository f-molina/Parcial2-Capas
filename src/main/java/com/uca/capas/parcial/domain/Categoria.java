package com.uca.capas.parcial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(generator = "cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_categoria")
    private Integer codigoCategoria;

    @Column(name = "s_categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Libro> libros;

    public Categoria(){}

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}