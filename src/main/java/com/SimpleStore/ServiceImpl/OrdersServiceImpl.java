package com.SimpleStore.ServiceImpl;

import com.SimpleStore.Dao.OrdersDao;
import com.SimpleStore.Dao.ClothesDao;
import com.SimpleStore.Dao.UserDao;
import com.SimpleStore.Entity.Clothes;
import com.SimpleStore.Entity.Orders;
import com.SimpleStore.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SimpleStore.Service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ClothesDao clothesDao;
    @Autowired
    private UserDao userDao;



    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    public Orders findOne(int id) {
        return ordersDao.findOne(id);
    }

    public void delete(int id) {
        ordersDao.delete(id);
    }

    public void update(Orders orders) {
        ordersDao.save(orders);
    }
    @Override
    public void addIntoBasket(Principal principal, int id) {

        User user = userDao.findUserWithClothes(Integer.parseInt(principal.getName()));

        userDao.save(user);

    }

    @Override
    @Transactional
    public void deleteFromBasket(int userId, int clothesId) {

        User user = userDao.findUserWithClothes(userId);

        Clothes clothes = clothesDao.clothesWithUsers(clothesId);

        userDao.save(user);

    }

    @Override
    @Transactional
    public void buy(int userId) {

        Orders orders = new Orders(LocalDateTime.now());

        ordersDao.saveAndFlush(orders);

        User user = userDao.findUserWithClothes(userId);





            ordersDao.save(orders);

        }

    @Override
    public void save (int userId) {
        Orders orders = new Orders(LocalDateTime.now());
        ordersDao.saveAndFlush(orders);




        User user = userDao.findOne(userId);



        ordersDao.save(orders);

    }



}
