/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.repository;

import upeu.edu.pe.ecommerce.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author tpp
 */
public interface OrderProductRepository {

    public OrderProductEntity createOrderProduct(OrderProductEntity orderProductEntity);
    public Iterable<OrderProductEntity> getOrdersProducts();
    public Iterable<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity);

}
