/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ecommerce.app.service.LoginServices;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
   private final LoginServices loginServices;
   private final Integer USER_NOT_FOUND = 0;

    public UserDetailServiceImpl(LoginServices loginServices) {
        this.loginServices = loginServices;
    }
    
    @Autowired
     private HttpSession httpSession;
    
   
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Integer idUser = loginServices.getUserId(username);
     if(idUser != USER_NOT_FOUND){
         UserEntity user = loginServices.getuser(username);
            httpSession.setAttribute("iduser", user.getId());
            httpSession.setAttribute("name", user.getFirstName());
            httpSession.setAttribute("username", user.getUsername());
        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getTypeUser().name()).build();

    }else{
        throw new UsernameNotFoundException("Usuario no encontrado ");  
     }

    }
    
}
