/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import upeu.edu.pe.ecommerce.app.repository.OrderProductRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author tpp
 */
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    
    
  public OrderProductEntity createOrder(OrderProductEntity orderProductEntity){
   return orderProductRepository.createOrderProduct(orderProductEntity);
      
  }
    public Iterable<OrderProductEntity> getOrdersProducts(){
         return orderProductRepository.getOrdersProducts();
    }
    public Iterable<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity){
        return  orderProductRepository.getOrdersProductByOrder(orderEntity);
    }
  
}
