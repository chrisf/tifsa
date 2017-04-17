package org.jsack.tifsa.Database.Product;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class ProductWrapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProductId(rs.getLong("ProductID"));
        product.setVendorId(rs.getLong("VendorID"));
        product.setProductDescription(rs.getString("ProductDescription"));
        product.setProductSku(rs.getString("ProductSKU"));
        product.setProductPrice(rs.getDouble("ProductPrice"));
        product.setBrandId(rs.getLong("BrandID"));
        product.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return product;
    }
}
