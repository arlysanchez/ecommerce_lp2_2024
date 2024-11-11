/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.repository;

import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public interface OrderRepository {
    
    public OrderEntity createOrder(OrderEntity order);
    
    //ordenes para el admin del sistema
    public Iterable<OrderEntity> getOrders();
    
    //ordenes por usuario logeado en el sistema
    public Iterable<OrderEntity> getOrderByUser(UserEntity user);
    
    
    
}
