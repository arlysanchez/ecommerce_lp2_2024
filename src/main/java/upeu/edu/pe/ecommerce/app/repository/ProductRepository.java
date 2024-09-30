/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.repository;

import upeu.edu.pe.ecommerce.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public interface ProductRepository {
 
    Iterable<ProductEntity> getProducts();
    Iterable<ProductEntity> getProductsByUser(UserEntity userEntity);
    ProductEntity getProductById(Integer id);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer id);
    
}
