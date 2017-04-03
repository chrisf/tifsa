package org.jsack.tifsa.Database.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/3/17.
 */
public class OrderDAO extends OrderBase {
    public OrderDAO() {
        this.setTableName("Order");
        this.setSimpleInsert(this.getTableName(), "OrderID");
    }
    @Override
    public List<Order> selectAll() {
        String sql = "SELECT * FROM ?";
        return getTemplate().query(sql, new Object[] { this.getTableName() }, new OrderWrapper());
    }

    @Override
    public Order selectById(long id) {
        String sql = "SELECT * FROM ? WHERE OrderID = ?";
        return getTemplate().queryForObject(sql, new Object[] { this.getTableName(), id }, new OrderWrapper());
    }

    @Override
    public long create(Order c) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("OrderTotal", c.getOrdertotal());
        attributes.put("OrderDate", c.getOrderdate());
        
    public int delete(long id) {
        return 0;
    }

    @Override
    public int update(Order c) {
        return 0;
    }
}
