package org.jsack.tifsa.core.models;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by aaron on 3/1/17.
 */
public class Customer {
    private int customerId;
    private String customerBusinessName;
    private String customerFirst;
    private String customerMiddleInitial;
    private String customerLast;
    private String customerBillingFirst;
    private String customerBillingMiddleInitial;
    private String customerBillingLast;
    private java.sql.Date customerAddedOn;
    private int stateId;
    private String customerAddressStreet;
    private String customerAddressZip;
    private String customerAddressCity;
    private String customerAddressStreet2;
    private int customerTypeId;
    private int customerStatusId;

    private String p_sqlsrv_insert_customer = "INSERT INTO Customer (CustomerBusinessName, CustomerFirst, " +
            "CustomerMiddleInitial, CustomerLast, CustomerBillingFirst, CustomerBillingMiddleInitial, CustomerBillingLast, " +
            "CustomerAddedOn, StateID, CustomerAddressStreet, CustomerAddressZip, CustomerAddressCity, CustomerAddressStreet2, " +
            "CustomerTypeID, CustomerStatusID) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private String p_sqlsrv_select_customer_by_id = "SELECT * FROM Customer WHERE CustomerID = ?";
    private String p_sqlsrv_select_customer_by_first_name = "SELECT * FROM Customer WHERE CustomerFirst = ?";
    private String p_sqlsrv_select_customer_by_last_name = "SELECT * From Customer WHERE CustomerLast = ?";

    /***
     * Creates a customer with default values. See "initializeDefaults" for those values.
     * It's all hardcoded. Deal with it.
     */
    public Customer() {
      initializeDefaults();
    }

    /***
     * Creates a new Business customer. I'm not documenting every parameter, they are self explanatory.
     * @param customerBusinessName
     * @param customerBillingFirst
     * @param customerBillingMiddleInitial
     * @param customerBillingLast
     * @param customerAddedOn
     * @param stateId
     * @param customerAddressStreet
     * @param customerAddressZip
     * @param customerAddressCity
     * @param customerAddressStreet2
     */
    public Customer(String customerBusinessName, String customerBillingFirst, String customerBillingMiddleInitial, String customerBillingLast,
                    Date customerAddedOn, int stateId, String customerAddressStreet, String customerAddressZip, String customerAddressCity,
                    String customerAddressStreet2) {
        initializeDefaults();
        this.customerBusinessName = customerBusinessName;
        this.customerBillingFirst = customerBillingFirst;
        this.customerBillingMiddleInitial = customerBillingMiddleInitial;
        this.customerBillingLast = customerBillingLast;
        this.customerAddedOn = customerAddedOn;
        this.stateId = stateId;
        this.customerAddressStreet = customerAddressStreet;
        this.customerAddressZip = customerAddressZip;
        this.customerAddressCity = customerAddressCity;
        this.customerAddressStreet2 = customerAddressStreet2;

    }

    /***
     * Creates a new Customer. Once again, not documenting the parameters, if you can read, you can figure it out.
     * @param customerFirst
     * @param customerMiddleInitial
     * @param customerLast
     * @param customerBillingFirst
     * @param customerBillingMiddleInitial
     * @param customerBillingLast
     * @param customerAddedOn
     * @param stateId
     * @param customerAddressStreet
     * @param customerAddressZip
     * @param customerAddressCity
     * @param customerAddressStreet2
     */
    public Customer(String customerFirst, String customerMiddleInitial, String customerLast, String customerBillingFirst,
                    String customerBillingMiddleInitial, String customerBillingLast, Date customerAddedOn, int stateId,
                    String customerAddressStreet, String customerAddressZip, String customerAddressCity, String customerAddressStreet2) {
        initializeDefaults();
        this.customerFirst = customerFirst;
        this.customerMiddleInitial = customerMiddleInitial;
        this.customerLast = customerLast;
        this.customerBillingFirst = customerBillingFirst;
        this.customerBillingMiddleInitial = customerBillingMiddleInitial;
        this.customerBillingLast = customerBillingLast;
        this.customerAddedOn = customerAddedOn;
        this.stateId = stateId;
        this.customerAddressStreet = customerAddressStreet;
        this.customerAddressZip = customerAddressZip;
        this.customerAddressCity = customerAddressCity;
        this.customerAddressStreet2 = customerAddressStreet2;
    }

    private void initializeDefaults(){
        this.customerBusinessName = "";
        this.customerFirst = "";
        this.customerMiddleInitial = "";
        this.customerLast = "";
        this.customerBillingFirst = "";
        this.customerBillingMiddleInitial = "";
        this.customerBillingLast = "";
        this.customerAddedOn = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.stateId = 0;
        this.customerAddressStreet = "";
        this.customerAddressZip = "";
        this.customerAddressCity = "";
        this.customerAddressStreet2 = "";
        this.customerTypeId = 0;
        this.customerStatusId = 0;

    }

    private int DBInsertCustomer(Connection conn) throws SQLException{
        PreparedStatement pstmt = conn.prepareStatement(p_sqlsrv_insert_customer);
            pstmt.setString(1, customerBusinessName);
            pstmt.setString(2, customerFirst);
            pstmt.setString(3, customerMiddleInitial);
            pstmt.setString(4, customerLast);
            pstmt.setString(5, customerBillingFirst);
            pstmt.setString(6, customerBillingMiddleInitial);
            pstmt.setString(7, customerBillingLast);
            pstmt.setDate(8, customerAddedOn);
            pstmt.setInt(9, stateId);
            pstmt.setString(10, customerAddressStreet);
            pstmt.setString(11, customerAddressZip);
            pstmt.setString(12, customerAddressCity);
            pstmt.setString(13, customerAddressStreet2);
            pstmt.setInt(14, customerTypeId);
            pstmt.setInt(15, customerStatusId);
        pstmt.execute();
        ResultSet primaryKey = pstmt.getGeneratedKeys();
        if(primaryKey != null && primaryKey.next()){
            this.customerId = primaryKey.getInt(1);
        }
        conn.commit();
        pstmt.close();
        return this.customerId;
    }


}
