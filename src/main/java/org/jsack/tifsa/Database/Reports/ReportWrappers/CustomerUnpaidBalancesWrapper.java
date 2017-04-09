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

        /*Now we set each of the class properties to their respective column value.
          Make sure you are matching datatypes
            ex: CustomerFirst is a String, so you need to perform resultSet.GetString
                OrderBalance is a Double so you need to perform resultSet.GetDouble

          The value for "columnLabel" must match what your report says when you run it in SSMS.
            ex: SSMS showed CustomerFirst, CustomerLast so those are what I used for the columnLabel variable
         */
        customerUnpaidBalances.setCustomerFirst(resultSet.getString("CustomerFirst"));
        customerUnpaidBalances.setCustomerLast(resultSet.getString("CustomerLast"));
        customerUnpaidBalances.setCustomerContactInfo(resultSet.getString("CustomerContactInfo"));
        customerUnpaidBalances.setCustomerContactTypeDescription(resultSet.getString("CustomerContactTypeDescription"));
        customerUnpaidBalances.setOrderBalance(resultSet.getDouble("OrderBalance"));

        //Return your object
        return customerUnpaidBalances;
    }
}
