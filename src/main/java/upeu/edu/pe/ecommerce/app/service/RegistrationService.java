/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public class RegistrationService {
    private final UserService userService;
     private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

   
    
     public void register(UserEntity user){
          user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }
    
    
    
    
}
