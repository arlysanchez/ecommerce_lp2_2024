/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import upeu.edu.pe.ecommerce.app.repository.OrderRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
     public OrderEntity createOrder(OrderEntity order){
        return orderRepository.createOrder(order);
     }
    
    public Iterable<OrderEntity> getOrders(){
        return orderRepository.getOrders();
    }
    
    public Iterable<OrderEntity> getOrderByUser(UserEntity user){
        return orderRepository.getOrderByUser(user);
    }
    
    
}
