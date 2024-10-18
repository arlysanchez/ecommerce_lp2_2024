/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.ecommerce.app.domain.ItemCart;
import upeu.edu.pe.ecommerce.app.service.CartServices;
import upeu.edu.pe.ecommerce.app.service.OrderProductService;
import upeu.edu.pe.ecommerce.app.service.OrderService;
import upeu.edu.pe.ecommerce.app.service.ProductService;
import upeu.edu.pe.ecommerce.app.service.StockService;
import upeu.edu.pe.ecommerce.app.service.UserService;
import upeu.edu.pe.ecommerce.app.service.ValidateStock;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderProductEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.StockEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Controller
@RequestMapping("/user/order")
public class OrderController {
    public final CartServices cartServices;
    public final UserService userService;
    public final ProductService productService;
    public final OrderService orderService;
    public final OrderProductService orderProductService;
    public final StockService stockService;
    public final ValidateStock validateStock;
    
     private final Integer entradas = 0;
     private final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(CartServices cartServices, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartServices = cartServices;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }
     
     @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
         UserEntity user = userService.findById(1);
        model.addAttribute("cart", cartServices.getItemCarts());
        model.addAttribute("total", cartServices.getTotalCart());
        model.addAttribute("user", user);
       // model.addAttribute("id", httpSession.getAttribute("iduser").toString());
       // model.addAttribute("nombre", httpSession.getAttribute("name").toString());
        return "user/summaryorder";
    }
    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes) {
        UserEntity user = userService.findById(1);
        OrderEntity order = new OrderEntity();
        order.setDateCreated(LocalDateTime.now());
        order.setStatus("Proceso");
        order.setUserEntity(user);
        order.setTotal(cartServices.getTotalCart().toString());
        log.info("order : {}", order);
        
        //guardar Order
        order = orderService.createOrder(order);
        
        List<OrderProductEntity> orderProduct = new ArrayList<>();
        for (ItemCart itemCart : cartServices.getItemCarts()) {
            orderProduct.add(new OrderProductEntity(productService.getProductById(itemCart.getIdProduct()),
                    itemCart.getQuantity(),
                    order));
        }

        orderProduct.forEach(
                op -> {
                    orderProductService.createOrder(op);
                    StockEntity stock = new StockEntity();
                    stock.setDescripcion("salida");
                    stock.setEntradas(entradas);
                    stock.setProductEntity(op.getProductEntity());
                    stock.setSalidas(op.getQuantity());
                    stockService.saveStock(validateStock.calculateBalance(stock));
                }
        );
        

        cartServices.removeAllItemsCart();
       // attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString());
        //attributes.addFlashAttribute("nombre", httpSession.getAttribute("name").toString());
       
       return "redirect:/home";
    }
    
}
