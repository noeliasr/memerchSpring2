package com.example.memerchSpring2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    private final ProductService productService;
    private final ClientService clientService;
  
    public HomeController(ProductService productService, ClientService clientService) {
      this.productService = productService;
      this.clientService = clientService;
    }
  
    @GetMapping("/")
    public String index(Model model) {
      model.addAttribute("products", productService.getProducts());
      model.addAttribute("clients", clientService.getClients());
      return "index";
    }
  
    // ------------- PRODUCT
    @PostMapping("/new-product")
    public String newProduct(@ModelAttribute NewProduct newProduct) {
        productService.create(newProduct);
      return "redirect:/";
    }

    @PostMapping("/multi-field-search-product")
    public String multiFieldSearchProduct( //
    @ModelAttribute ProductSearch search, //
    Model model) {
    List<ProductEntity> searchResults = //
        productService.search(search);
    model.addAttribute("products", searchResults);
    return "index";
    }

    @PostMapping("/universal-search-product")
    public String universalSearchProduct(@ModelAttribute UniversalSearch search, Model model) {
      List<ProductEntity> searchResults = productService.search(search);
      model.addAttribute("products", searchResults);
      return "index";
    }

    // ------------- CLIENT
    @PostMapping("/new-client")
    public String newClient(@ModelAttribute NewClient newClient) {
        clientService.create(newClient);
      return "redirect:/";
    }

    @PostMapping("/multi-field-search-client")
    public String multiFieldSearchClient( //
    @ModelAttribute ClientSearch search, //
    Model model) {
    List<ClientEntity> searchResults = //
        clientService.search(search);
    model.addAttribute("clients", searchResults);
    return "index";
    }

    @PostMapping("/universal-search-client")
    public String universalSearchClient(@ModelAttribute UniversalSearch search, Model model) {
      List<ClientEntity> searchResults = clientService.search(search);
      model.addAttribute("clients", searchResults);
      return "index";
    }


  }
