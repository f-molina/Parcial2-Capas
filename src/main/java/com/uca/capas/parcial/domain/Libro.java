package com.uca.capas.parcial.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
    
    @Id
    @GeneratedValue(generator = "cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_libro")
    private Integer codigoLibro;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 500, message = "El campo sobrepasa la cantidad de 500 caracteres")
    @Column(name = "s_titulo")
    private String titulo;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 150, message = "El campo sobrepasa la cantidad de 150 caracteres")
    @Column(name = "s_autor")
    private String autor;

    @Column(name = "f_ingreso")
    private LocalDateTime fechaIngreso;

    @NotNull(message = "El campo no puede estar vacio")
    @Column(name = "b_estado")
    private Boolean estado;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 10, message = "El campo sobrepasa la cantidad de 10 caracteres")
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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //delegates
    public String getEstadoDelegate() {
        if(this.estado == null) return "";
        else {
            return estado == true ? "Disponible":"No Disponible";
        }
    }

    public String getFechaDelegate(){
		if(this.fechaIngreso == null){
			return "";
		}
		else{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			String shortdate = this.fechaIngreso.format(formatter);
			return shortdate;
		}
    }
    
    //current date before insert
    @PrePersist
    public void prePersist(){
        this.fechaIngreso = LocalDateTime.now();
    }
}