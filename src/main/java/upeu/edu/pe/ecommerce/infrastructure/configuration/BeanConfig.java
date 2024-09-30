/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ecommerce.app.repository.ProductRepository;
import upeu.edu.pe.ecommerce.app.repository.UserRepository;
import upeu.edu.pe.ecommerce.app.service.ProductService;
import upeu.edu.pe.ecommerce.app.service.UploadFile;
import upeu.edu.pe.ecommerce.app.service.UserService;

/**
 *
 * @author tpp
 */
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
    
}
