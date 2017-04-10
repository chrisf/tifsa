package org.jsack.tifsa.Database.Reports.ReportWrappers;

import org.jsack.tifsa.Database.Reports.ReportModels.CustomerUnpaidBalances;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/9/17.
 */

/**
 * This class maps data from the database to our report model class.
 */
public class CustomerUnpaidBalancesWrapper implements RowMapper<CustomerUnpaidBalances> {

    @Override
    public CustomerUnpaidBalances mapRow(ResultSet resultSet, int i) throws SQLException {

        //Here you create an instance of the model class of your report. (You should have created that first)
        CustomerUnpaidBalances customerUnpaidBalances = new CustomerUnpaidBalances();

        customerUnpaidBalances.getRow().add(resultSet.getString("CustomerFirst"));
        customerUnpaidBalances.getRow().add(resultSet.getString("CustomerLast"));
        customerUnpaidBalances.getRow().add(resultSet.getString("CustomerContactInfo"));
        customerUnpaidBalances.getRow().add(resultSet.getString("CustomerContactTypeDescription"));
        customerUnpaidBalances.getRow().add(String.valueOf(resultSet.getDouble("OrderBalance")));

        //Return your object
        return customerUnpaidBalances;
    }
}
