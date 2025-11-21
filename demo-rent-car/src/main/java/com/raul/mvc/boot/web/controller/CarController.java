package com.raul.mvc.boot.web.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raul.mvc.boot.beans.Brand;
import com.raul.mvc.boot.beans.Car;
import com.raul.mvc.boot.service.BrandService;
import com.raul.mvc.boot.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/register")
    public String cadastrar(Car car) {
        return "/car/cadastro";
    }

    @GetMapping("/list")
    public String listar(ModelMap model) {
        model.addAttribute("cars", carService.buscarTodos());
        return "/car/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Car car, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/car/cadastro";
        }

        carService.salvar(car);
        attr.addFlashAttribute("success", "Car inserido com sucesso.");
        return "redirect:/cars/register";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cars", carService.buscarPorId(id));
        return "car/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Car car, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/car/cadastro";
        }

        carService.editar(car);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/cars/register";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (carService.carTemCustomers(id)) {
            attr.addFlashAttribute("fail", "Car não excluido. Tem funcionário(s) vinculado(s).");
        } else {
            carService.excluir(id);
            attr.addFlashAttribute("success", "Car excluido com sucesso.");
        }
        return "redirect:/cars/list";
    }

    @ModelAttribute("brands")
    public List<Brand> listaDeBrands() {
        return brandService.buscarTodos();
    }
}
