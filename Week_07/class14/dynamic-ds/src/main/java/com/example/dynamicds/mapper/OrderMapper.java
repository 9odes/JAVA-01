package com.example.dynamicds.mapper;

import com.example.dynamicds.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    @Insert("INSERT INTO order (`order_id`, `product_code`, `user_name`, `count`, `unit_price`, `real_price`) VALUES" +
            "('1','2','3',4,5,20)")
    void addOrder();

    @Select("select * from order where id = 1")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_name", property="userName")
    })
    Order getOrder();
}
