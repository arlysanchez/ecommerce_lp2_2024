/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.repository;

import upeu.edu.pe.ecommerce.infrastructure.entity.CategoryEntity;

/**
 *
 * @author tpp
 */
public interface CategoriesRepository {
    Iterable<CategoryEntity> getCategories();
    
}
