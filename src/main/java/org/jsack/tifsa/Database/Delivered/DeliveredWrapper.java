package org.jsack.tifsa.Database.Delivered;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/13/2017.
 */
public class DeliveredWrapper implements RowMapper<Delivered> {
    @Override
    public Delivered mapRow(ResultSet rs, int rowNum) throws SQLException {
        Delivered delivered = new Delivered();

        delivered.setDeliveryId(rs.getLong("DeliveredID"));
        delivered.setDeliveryDate(rs.getDate("DeliveryDate"));
        delivered.setOrderLineDeliveryType(rs.getLong("OrderLineDeliveryTypeID"));
        delivered.setOrderLineId(rs.getLong("OrderLineID"));
        delivered.setEmployeeId(rs.getLong("EmployeeID"));
        delivered.setDeleted(Boolean.getBoolean(rs.getString("Deleted")));

        return delivered;
    }
}
