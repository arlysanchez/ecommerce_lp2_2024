/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.ecommerce.app.domain.ItemCart;

/**
 *
 * @author tpp
 */
public class CartServices {

    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemHashMap;

    public CartServices() {
        this.itemHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    public void addItemCart(Integer idProducto,
            String nameProduct,
            Integer quantity,
            BigDecimal price) {

        ItemCart itemCart = new ItemCart(idProducto,
                nameProduct, quantity, price);
        itemHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();

    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());

        }
        return total;
    }

    //elimina el item del carrito por Id
    public void removeItemCart(Integer idProduct) {
        itemHashMap.remove(idProduct);
        fillList();
    }
    //limpia el arreglo temporal de productos añadidos al carrito
    public void removeAllItemsCart() {
        itemHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemHashMap.forEach(
                (Integer, itemCart) -> itemCarts.add(itemCart)
        );
    }
    //para ver en consola 
    public List<ItemCart> getItemCarts(){
        return  itemCarts;
    }

}
