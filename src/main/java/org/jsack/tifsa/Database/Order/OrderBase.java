package org.jsack.tifsa.Database.Order;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by aaron on 4/3/17.
 */
public abstract class OrderBase extends ModelBase {
    public abstract List<Order> selectAll();

    public abstract Order selectById(long id);

    public abstract long create(Order c);

    public abstract int delete(long id);

    public abstract int update(Order c);
}
