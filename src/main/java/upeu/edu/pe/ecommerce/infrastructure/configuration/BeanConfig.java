/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import upeu.edu.pe.ecommerce.app.repository.CategoriesRepository;
import upeu.edu.pe.ecommerce.app.repository.OrderProductRepository;
import upeu.edu.pe.ecommerce.app.repository.OrderRepository;
import upeu.edu.pe.ecommerce.app.repository.ProductRepository;
import upeu.edu.pe.ecommerce.app.repository.StockRepository;
import upeu.edu.pe.ecommerce.app.repository.UserRepository;
import upeu.edu.pe.ecommerce.app.service.CartServices;
import upeu.edu.pe.ecommerce.app.service.CategoriesServices;
import upeu.edu.pe.ecommerce.app.service.LoginServices;
import upeu.edu.pe.ecommerce.app.service.LogoutService;
import upeu.edu.pe.ecommerce.app.service.OrderProductService;
import upeu.edu.pe.ecommerce.app.service.OrderService;
import upeu.edu.pe.ecommerce.app.service.ProductService;
import upeu.edu.pe.ecommerce.app.service.RegistrationService;
import upeu.edu.pe.ecommerce.app.service.StockService;
import upeu.edu.pe.ecommerce.app.service.UploadFile;
import upeu.edu.pe.ecommerce.app.service.UserService;
import upeu.edu.pe.ecommerce.app.service.ValidateStock;


@Configuration
public class BeanConfig {
    
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    
    @Bean
   public UploadFile uploadFile(){
       return new UploadFile();
   }
    @Bean
    public ProductService productService (ProductRepository productRepository,UploadFile uploadFile){
        return new ProductService(productRepository,uploadFile);
    }
    
    @Bean
    public CategoriesServices categoriesServices (CategoriesRepository categoriesRepository){
        return  new CategoriesServices(categoriesRepository);
    }
    

    @Bean
    public OrderService orderService (OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }
    
    @Bean
    public OrderProductService orderProductService (OrderProductRepository  orderProductRepository){
        return new OrderProductService(orderProductRepository);
    }
     
    @Bean
   @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartServices cartServices(){
        return new CartServices();
    }
     @Bean
   public StockService stockService(StockRepository stockRepository){
      return new StockService(stockRepository);
   }
     @Bean
    public ValidateStock validateStock(StockService stockService) {
        return new ValidateStock(stockService);
    }
    @Bean
    public LoginServices loginServices(UserService userService){
        return new LoginServices(userService);
    }
    @Bean
    public LogoutService logoutService(){
        return new LogoutService();
    }
    @Bean 
    public RegistrationService registrationService(UserService userService, PasswordEncoder passwordEncoder){
        return new RegistrationService(userService,passwordEncoder);
    }
}
