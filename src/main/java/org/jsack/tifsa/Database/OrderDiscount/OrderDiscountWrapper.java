package org.jsack.tifsa.Database.OrderDiscount;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class OrderDiscountWrapper implements RowMapper<OrderDiscount> {
    @Override
    public OrderDiscount mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDiscount orderDiscount = new OrderDiscount();

        orderDiscount.setOrderDiscountId(rs.getLong("OrderDiscountID"));
        orderDiscount.setOrderId(rs.getLong("OrderID"));
        orderDiscount.setOrderDiscountAmount(rs.getDouble("OrderDiscountAmount"));
        orderDiscount.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderDiscount;
    }
}
