/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecommerce.app.repository.UserRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    
    private final UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
     return userCrudRepository.findByEmail(email).get();
    }

    @Override
    public UserEntity findById(Integer id) {
        return userCrudRepository.findById(id).get();
    }
    
    
    
}
