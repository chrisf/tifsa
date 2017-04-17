package org.jsack.tifsa.Database.Picture;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class PictureWrapper implements RowMapper<Picture> {
    @Override
    public Picture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Picture picture = new Picture();

        picture.setPictureId(rs.getLong("PictureID"));
        picture.setProductId(rs.getLong("ProductID"));
        picture.setPictureData(rs.getBytes("PictureData"));
        picture.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return picture;
    }
}
