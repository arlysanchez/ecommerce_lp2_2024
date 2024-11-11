/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import upeu.edu.pe.ecommerce.infrastructure.entity.TypeUser;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public class LoginServices {

    private final UserService userService;

    public LoginServices(UserService userService) {
        this.userService = userService;
    }

    //retorna true si encuentra el user
    public boolean existUser(String email) {
        try {
            UserEntity user = userService.findByEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    //obtenemos el id del usuario

    public Integer getUserId(String email) {
        try {
            return userService.findByEmail(email).getId();
        } catch (Exception e) {
            return 0;
        }
    }

    //obtener tipo de usuario
    public TypeUser getUserType(String email) {
        return userService.findByEmail(email).getTypeUser();
    }

    public UserEntity getuser(String email) {
        try {
            return userService.findByEmail(email);
        } catch (Exception e) {
            return new UserEntity();
        }
    }
    //obtenemos el user por id

    public UserEntity getUser(Integer id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            return new UserEntity();
        }
    }

}
