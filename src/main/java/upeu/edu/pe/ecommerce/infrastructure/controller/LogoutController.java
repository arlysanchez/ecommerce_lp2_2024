/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce.app.service.LogoutService;

/**
 *
 * @author tpp
 */
@Controller
@RequestMapping("/close")
public class LogoutController {
     private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }
    
     @GetMapping
    public String logout(HttpSession httpSession){
        logoutService.logout(httpSession);
        return "redirect:/home";
    }
}
