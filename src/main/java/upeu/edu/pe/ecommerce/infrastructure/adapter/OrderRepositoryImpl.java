/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecommerce.app.repository.OrderRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
  
    private final OrderCrudRepository orderCrudRepository;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
    return orderCrudRepository.save(order);
    }

    @Override
    public Iterable<OrderEntity> getOrders() {
        return orderCrudRepository.findAll();
    }

    @Override
    public Iterable<OrderEntity> getOrderByUser(UserEntity user) {
      return orderCrudRepository.findByUserEntity(user);
    }
    
    
    
}
