package org.jsack.tifsa.Database.IncidentType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class IncidentTypeWrapper implements RowMapper<IncidentType> {
    @Override
    public IncidentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        IncidentType incidentType = new IncidentType();

        incidentType.setIncidentTypeId(rs.getLong("IncidentTypeID"));
        incidentType.setIncidentTypeDescription(rs.getString("IncidentTypeDescription"));
        incidentType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return incidentType;
    }
}
