package com.example.shardingdemo.mapper;

import com.example.shardingdemo.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    @Insert("INSERT INTO order (`order_id`, `product_code`, `user_name`, `count`, `unit_price`, `real_price`) VALUES" +
            "('1','2','3',4,5,20)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void addOrder(@Param("order") Order order);

    @Select("select * from order where id = #{id}")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_name", property="userName")
    })
    Order getOrder(@Param("id") Long id);
}
