package com.uca.capas.parcial.controller;

import java.util.List;

import javax.validation.Valid;

import com.uca.capas.parcial.domain.Categoria;
import com.uca.capas.parcial.domain.Libro;
import com.uca.capas.parcial.service.CategoriaService;
import com.uca.capas.parcial.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("guardado", "");
        mav.setViewName("index");

        return mav;
    }

    @GetMapping("/insertarCategoria")
    public ModelAndView init() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoria", new Categoria());
        mav.setViewName("agregarCategoria");

        return mav;
    }

    // ingresar categoria
    @RequestMapping("saveCategoria")
    public ModelAndView insertarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.setViewName("agregarCategoria");
        } else {
            categoriaService.save(categoria);
            mav.addObject("guardado", "Categoria guardada con exito");
            mav.setViewName("index");
        }

        return mav;
    }

    @GetMapping("/insertarLibro")
    public ModelAndView init2() {
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias = null;
        try {
            categorias = categoriaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("libro", new Libro());
        mav.addObject("categorias", categorias);
        mav.setViewName("agregarLibro");

        return mav;
    }

    // ingresar libro
    @RequestMapping("saveLibro")
    public ModelAndView insertarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            List<Categoria> categorias = null;
            try {
                categorias = categoriaService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("categorias", categorias);
            mav.setViewName("agregarLibro");
        } else {
            libroService.save(libro);
            mav.addObject("guardado", "Libro guardado con exito");
            mav.setViewName("index");
        }

        return mav;
    }

    // listado libros
    @RequestMapping("/listado")
    public ModelAndView listadoContribuyentes() {
        ModelAndView mav = new ModelAndView();
        List<Libro> libros = null;
        try {
            libros = libroService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("librosList", libros);
        mav.setViewName("listado");

        return mav;
    }
}