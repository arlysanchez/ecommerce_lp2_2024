/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.ecommerce.app.service.CartServices;

/**
 *
 * @author tpp
 */
@Controller
@RequestMapping("user/cart")
public class CartController {
    private final CartServices cartServices;
    
    private final Logger log = LoggerFactory.getLogger(CartController.class);

    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }
    //añadir los productos al carrito
    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer idProduct,
            @RequestParam String nameProduct,
            @RequestParam Integer quantity,
            @RequestParam BigDecimal price){
        
          log.info("Nombre de producto: {}", idProduct);
        cartServices.addItemCart(idProduct, nameProduct, quantity, price);
         showCart();
        return "redirect:/home";
    }
    
    private void showCart(){
        cartServices.getItemCarts().forEach(
                itemCart -> log.info("Item cart: {}", itemCart)
        );
    }
    
    @GetMapping("/get-cart")
    public String getCart(Model model, HttpSession httpSession){
        model.addAttribute("cart", 
                cartServices.getItemCarts());
        model.addAttribute("total", 
                cartServices.getTotalCart());
         try {
            model.addAttribute("nombre", httpSession.getAttribute("name").toString());
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        } catch (Exception e) {
        }
        return "user/cart/cart";
    }
    @GetMapping("/delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Integer id){
        cartServices.removeItemCart(id);
        return "redirect:/user/cart/get-cart";
    }
    
    
    
    
    
}
