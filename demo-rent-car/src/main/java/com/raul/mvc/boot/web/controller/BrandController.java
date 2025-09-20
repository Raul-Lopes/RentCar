package com.raul.mvc.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raul.mvc.boot.beans.Brand;
import com.raul.mvc.boot.service.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/register")
    public String cadastrar(Brand brand) {
        return "/brand/cadastro"; //resources/templates/brand/cadastro.html
    }

    @GetMapping("/list")
    public String listar(ModelMap model) {
        model.addAttribute("brands", service.buscarTodos());
        return "/brand/lista"; //resources/templates/brand/lista.html
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Brand brand, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/brand/cadastro";
        }

        service.salvar(brand);
        attr.addFlashAttribute("success", "Brand inserida com sucesso.");
        return "redirect:/brands/register";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("brand", service.buscarPorId(id));
        return "/brand/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Brand brand, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/brand/cadastro";
        }

        service.editar(brand);
        attr.addFlashAttribute("success", "Brand editada com sucesso.");
        return "redirect:/brands/register";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        if (service.brandTemCars(id)) {
            model.addAttribute("fail", "Brand não removida. Possui car(s) vinculado(s).");
        } else {
            service.excluir(id);
            model.addAttribute("success", "Brand excluída com sucesso.");
        }

        return listar(model);
    }


}
