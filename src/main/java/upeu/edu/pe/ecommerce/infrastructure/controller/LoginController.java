/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce.app.service.LoginServices;

/**
 *
 * @author tpp
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginServices loginServices;

    public LoginController(LoginServices loginServices) {
        this.loginServices = loginServices;
    }
    
    
     @GetMapping
    public String login(){
        return "login";
    }
    
    
}
