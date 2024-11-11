/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    private String status;
    private String total;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    
    @Transient
    private List<OrderProductEntity> orderProducts;
    
    public OrderEntity() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTotal() {
        return total;
    }
    
    public void setTotal(String total) {
        this.total = total;
    }
    
    public UserEntity getUserEntity() {
        return userEntity;
    }
    
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    
    public List<OrderProductEntity> getOrderProducts() {
        return orderProducts;
    }
    
    public void setOrderProducts(List<OrderProductEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }
    
    public void addOrderProduct(List<OrderProductEntity> orderProducts) {
        this.setOrderProducts(orderProducts);
        
    }
    
    public BigDecimal getTotalOrderPrice(){
        return getOrderProducts().stream().map(p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
