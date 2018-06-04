package com.raul.mvc.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raul.mvc.boot.beans.Car;
import com.raul.mvc.boot.beans.Customer;
import com.raul.mvc.boot.beans.UF;
import com.raul.mvc.boot.service.CarService;
import com.raul.mvc.boot.service.CustomerService;
import com.raul.mvc.boot.web.validator.CustomerValidator;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CarService carService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new CustomerValidator());
	}

	@GetMapping("/register")
	public String cadastrar(Customer customer) {
		return "/customer/cadastro"; //retorna a pagina html
	}
	
	@GetMapping("/list")
	public String listar(ModelMap model) {
		model.addAttribute("customers", customerService.buscarTodos());
		return "/customer/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Customer customer, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/customer/cadastro";
		}
		
		customerService.salvar(customer);
		attr.addFlashAttribute("success", "Customer inserido com sucesso.");
		return "redirect:/customers/register";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("customer", customerService.buscarPorId(id));
		return "customer/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Customer customer, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/customer/cadastro";
		}
		
		customerService.editar(customer);
		attr.addFlashAttribute("success", "Customer editado com sucesso.");
		return "redirect:/customers/register";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		customerService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso.");
		return "redirect:/customers/list";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("customers", customerService.buscarPorNome(nome));
		return "/customer/lista";
	}
	
	@GetMapping("/buscar/car")
	public String getPorCar(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("customers", customerService.buscarPorCar(id));
		return "/customer/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("customers", customerService.buscarPorDatas(entrada, saida));
        return "/customer/lista";
    }
	
	@ModelAttribute("cars")
	public List<Car> getCars() {
		return carService.buscarTodos();
				
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
