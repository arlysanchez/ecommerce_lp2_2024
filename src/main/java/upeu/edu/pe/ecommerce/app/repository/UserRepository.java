/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.repository;

import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public interface UserRepository {
    
    //crear un nuevo usuario
    public UserEntity createUser(UserEntity userEntity);
    
    public UserEntity findByEmail(String email);
    
    public UserEntity findById(Integer id);
    
    
}
