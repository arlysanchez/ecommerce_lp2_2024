/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ecommerce.app.service.CategoriesServices;
import upeu.edu.pe.ecommerce.app.service.ProductService;
import upeu.edu.pe.ecommerce.infrastructure.entity.CategoryEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Controller
@RequestMapping("/admin/products") //localhost:8080/
public class ProductController {

    private final ProductService productService;
    private final CategoriesServices categoriesServices;

    public ProductController(ProductService productService, CategoriesServices categoriesServices) {
        this.productService = productService;
        this.categoriesServices = categoriesServices;
    }
    
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    

    //crear nuevo producto
    @GetMapping("/create")
    public String create( Model model){
        Iterable<CategoryEntity> categorias = categoriesServices.getCategories();
        model.addAttribute("listCategories", categorias);
        return "admin/products/create";
    }
    //guardar producto
     @PostMapping("/save-product")
    public String saveProduct(ProductEntity product, @RequestParam("category_id") Integer category_id, @RequestParam("img")MultipartFile multipartFile,HttpSession httpSession) throws IOException {
        log.info("Nombre de producto: {}", product);
         CategoryEntity cat = new CategoryEntity();
         cat.setId(category_id);
         product.setCategoryEntity(cat);
        productService.saveProduct(product, multipartFile,httpSession);
        //return "admin/products/create";
        return "redirect:/admin";
    }
    
    @GetMapping("/show")
    public String showProduct(Model model, HttpSession httpSession){
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
         user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable<ProductEntity> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }


    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        ProductEntity product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product",product);
        return "admin/products/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }

}
