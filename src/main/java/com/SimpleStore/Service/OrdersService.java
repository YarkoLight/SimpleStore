package com.SimpleStore.Service;


import com.SimpleStore.Entity.Orders;

import java.security.Principal;
import java.util.List;

public interface OrdersService {

    void save(int userId);

    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int id);

    void update(Orders orders);

    void addIntoBasket(Principal principal, int id);

    void deleteFromBasket(int userId, int clothesId);

    void buy(int userId);
}
