package org.jsack.tifsa.Database.CustomerContact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 3/22/17.
 */
public class CustomerContactDAO extends CustomerContactBase {
    @Override
    public List<CustomerContact> selectAll() {
        String sql = "SELECT * FROM CustomerContact";
        return getTemplate().query(sql, new CustomerContactWrapper());
    }

    @Override
    public CustomerContact selecyById(long id) {
        String sql = "SELECT * FROM CustomerContact WHERE CustomerContactID = ?";
        return getTemplate().queryForObject(sql, new Object[] { id }, new CustomerContactWrapper());
    }

    @Override
    public long create(CustomerContact m) {
        Map<String, Object> attributes = new HashMap<>();

        attributes.put("CustomerContactTypeID", m.getCustomerContactTypeId());
        attributes.put("CustomerContactInfo", m.getCustomerContactInfo());
        attributes.put("CustomerContactPrimary", m.isCustomerContactPrimary());

        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int update(long id, Map<String, Object> attributes) {
        return this.update("CustomerContact", "CustomerContactID", id, attributes);
    }

    @Override
    public int delete(long id) {
        return this.delete("CustomerContact", "CustomerContactID", id);
    }
}
