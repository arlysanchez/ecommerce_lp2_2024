/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.StockEntity;

/**
 *
 * @author tpp
 */
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer>{
           List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  

    
    
}
