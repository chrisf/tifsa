package org.jsack.tifsa.Database.EmployeeHistoryType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class EmployeeHistoryTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeHistory";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeHistoryID";
    }

    @Override
    public RowMapper getWrapper() {
        return null;
    }
}
