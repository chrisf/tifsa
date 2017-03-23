package org.jsack.tifsa.Database.CustomerContact;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 3/22/17.
 */
public abstract class CustomerContactBase extends ModelBase {
    public abstract List<CustomerContact> selectAll();
    public abstract CustomerContact selectById(long id);
    public abstract long create(CustomerContact m);
    public abstract int update(long id, Map<String, Object> attributes);
    public abstract int delete(long id);
}
