package org.jsack.tifsa.Database.Interfaces;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by Admin on 4/12/2017.
 */
public interface ISchema {
    String getName();
    String getIdColumn();
    RowMapper getWrapper();
}
