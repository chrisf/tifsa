package org.jsack.tifsa.Database.EmployeeInvolved;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class EmployeeInvolvedSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeInvolved";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeInvolvedID";
    }

    @Override
    public RowMapper getWrapper() {
        return null;
    }
}
