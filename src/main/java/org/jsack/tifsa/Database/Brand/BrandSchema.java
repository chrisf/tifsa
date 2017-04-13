package org.jsack.tifsa.Database.Brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 3/21/17.
 */
public class BrandSchema extends BrandModel {
    public BrandSchema() {
        this.setSimpleInsert("Brand", "BrandID");
    }
    @Override
    public long create(long manufacturerId, String brandName) {

        //create out hashmap that will hold our row attributes
        Map<String, Object> attributes = new HashMap<>();

        //attribute names here must reflect how their respective column names in the DB
        attributes.put("ManufacturerID", manufacturerId);
        attributes.put("BrandName", brandName);

        //execute the simple insert and return the newly created primary key
        return this.getSimpleInsert().usingColumns("ManufacturerID", "BrandName").executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int update(long id, long manufacturerId, String brandName) {

        //create our sql update statement, using named values that will be replaced where appropriate
        String sql = "UPDATE Brand" +
                    " SET ManufacturerID = :manufacturerId, BrandName = :brandName" +
                    " WHERE BrandID = :id";
        Map<String,Object> attributes = new HashMap();

        //map our named values to their respective variable values
        attributes.put("manufacturerId", manufacturerId);
        attributes.put("brandName", brandName);
        attributes.put("id", id);

        //execute the sql statement and return the rows affected
        return this.getNamedTemplate().update(sql, attributes);
    }

    @Override
    public int delete(long id) {
        //create our delete statement
        String sql = "DELETE FROM Brand" +
                    " WHERE BrandID = ?";

        //execute our sql statement and return rows affected
        return this.getTemplate().update(sql, new Object[] { id });
    }

    @Override
    public List<Brand> selectAll() {

        //select all statement
        String sql = "SELECT * FROM Brand";

        //execute and return the list of objects
        List<Brand> brands = getTemplate().query(sql, new BrandWrapper());

        //return our object, hot and fresh from the database
        return brands;
    }

    @Override
    public Brand select(long id) {

        //select statement
        String sql = "SELECT * FROM Brand WHERE BrandID = ?";

        //execute the statement, return the object
        return getTemplate().queryForObject(sql, new Object[] { id }, new BrandWrapper());
    }
}
