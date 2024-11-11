/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import upeu.edu.pe.ecommerce.app.repository.CategoriesRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.CategoryEntity;

/**
 *
 * @author tpp
 */
public class CategoriesServices {

    private final CategoriesRepository categoriesRepository;

    public CategoriesServices(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Iterable<CategoryEntity> getCategories() {
        return categoriesRepository.getCategories();
    }

}
