/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;


/**
 *
 * @author tpp
 */
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{
   //METODO ADICIONAL NO TIENE EL CRUD REPOSITORY
    public Optional<UserEntity> findByEmail(String email);
    
}
