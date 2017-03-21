package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Brand.Brand;
import org.jsack.tifsa.Database.Brand.BrandDAO;
import org.junit.Test;

import java.util.List;

/**
 * Created by aaron on 3/21/17.
 */
public class BrandTest {
    @Test
    public void createTest(){
        BrandDAO brandDAO = new BrandDAO();
        long id = brandDAO.create(1, "MyTestBrand");
        System.out.printf("\n\n %d: Created.\n\n", id);
        assert(id > 0);
        brandDAO.delete(id);
    }

    @Test
    public void selectTest() {
        BrandDAO brandDAO = new BrandDAO();
        List<Brand> brands = brandDAO.selectAll();
        brands.forEach(b -> System.out.println(b.getBrandID()));
        assert(!brands.isEmpty());
    }
}
