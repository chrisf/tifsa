package org.jsack.tifsa.Database.Manufacturer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by julius on 3/21/2017.
 */
public class ManufacturerDAO extends ManufacturerBase{

    @Override
    public List<Manufacturer> selectAll(){
        String sql = "SELECT * FROM Manufacturer";
        List <Manufacturer> manufacturers = getTemplate().query(sql, new ManufacturerWrapper());
        return manufacturers;
    }

    @Override
    public Manufacturer selectById(int id) {
        String sql = "SELECT * FROM Manufacturer WHERE ManufacturerID = ?";
        return getTemplate().queryForObject(sql, new Object[] {id}, new ManufacturerWrapper());
}

    @Override
    public Manufacturer selectByName(String manufacturerName) {
        String sql = "SELECT * FROM Manufacturer WHERE ManufacturerName = ?";
        return getTemplate().queryForObject(sql, new Object[] {manufacturerName}, new ManufacturerWrapper());
    }

    @Override
    public int create(Manufacturer m) {
        Map<String, Object> attributes = new HashMap();

        attributes.put("ManufacturerName", m.getManufacturerName());

        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int delete(int id) {
        return this.delete("Manufacturer","ManufacturerID", id);
    }

    @Override
    public int update(Manufacturer m) {
        String sql = "UPDATE Manufacturer" +
                    "SET ManufacturerName = :manufacturerName" +
                    "WHERE ManufacturerID = :id";
        Map<String, Object> attributes = new HashMap();
        attributes.put("manufacturerName", m.getManufacturerName());
        attributes.put("manufacturerID", m.getManufacturerID());

        return this.getNamedTemplate().update(sql, attributes);
    }


}
