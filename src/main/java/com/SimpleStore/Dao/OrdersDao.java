package com.SimpleStore.Dao;

import com.SimpleStore.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
