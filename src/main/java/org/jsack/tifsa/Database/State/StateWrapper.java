package org.jsack.tifsa.Database.State;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class StateWrapper implements RowMapper<State> {
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();

        state.setStateId(rs.getLong("StateID"));
        state.setStateName(rs.getString("StateName"));
        state.setStateAbbreviation(rs.getString("StateAbbreviation"));
        state.setCountryId(rs.getLong("CountryID"));
        state.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return state;
    }
}
