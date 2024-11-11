/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import upeu.edu.pe.ecommerce.app.repository.UserRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public class UserService {
    //Intancia del user repository
    private final UserRepository userRepository;

    //constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //metodos
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.createUser(userEntity);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity findById(Integer id) {
        return userRepository.findById(id);
    }

}
