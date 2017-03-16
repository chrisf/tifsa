package org.jsack.tifsa.DBModels;

import java.sql.Date;

/**
 * Created by aaron on 3/13/17.
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
    private String customerAddressStreet;
    private String customerAddressStreet2;
    private String customerAddressCity;
    private int stateId;
    private String customerAddressZip;
    private int customerTypeId;
    private int customerStatusId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerBusinessName() {
        return customerBusinessName;
    }

    public void setCustomerBusinessName(String customerBusinessName) {
        this.customerBusinessName = customerBusinessName;
    }

    public String getCustomerFirst() {
        return customerFirst;
    }

    public void setCustomerFirst(String customerFirst) {
        this.customerFirst = customerFirst;
    }

    public String getCustomerMiddleInitial() {
        return customerMiddleInitial;
    }

    public void setCustomerMiddleInitial(String customerMiddleInitial) {
        this.customerMiddleInitial = customerMiddleInitial;
    }

    public String getCustomerLast() {
        return customerLast;
    }

    public void setCustomerLast(String customerLast) {
        this.customerLast = customerLast;
    }

    public String getCustomerBillingFirst() {
        return customerBillingFirst;
    }

    public void setCustomerBillingFirst(String customerBillingFirst) {
        this.customerBillingFirst = customerBillingFirst;
    }

    public String getCustomerBillingMiddleInitial() {
        return customerBillingMiddleInitial;
    }

    public void setCustomerBillingMiddleInitial(String customerBillingMiddleInitial) {
        this.customerBillingMiddleInitial = customerBillingMiddleInitial;
    }

    public String getCustomerBillingLast() {
        return customerBillingLast;
    }

    public void setCustomerBillingLast(String customerBillingLast) {
        this.customerBillingLast = customerBillingLast;
    }

    public Date getCustomerAddedOn() {
        return customerAddedOn;
    }

    public void setCustomerAddedOn(Date customerAddedOn) {
        this.customerAddedOn = customerAddedOn;
    }

    public String getCustomerAddressStreet() {
        return customerAddressStreet;
    }

    public void setCustomerAddressStreet(String customerAddressStreet) {
        this.customerAddressStreet = customerAddressStreet;
    }

    public String getCustomerAddressStreet2() {
        return customerAddressStreet2;
    }

    public void setCustomerAddressStreet2(String customerAddressStreet2) {
        this.customerAddressStreet2 = customerAddressStreet2;
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        this.customerAddressCity = customerAddressCity;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getCustomerAddressZip() {
        return customerAddressZip;
    }

    public void setCustomerAddressZip(String customerAddressZip) {
        this.customerAddressZip = customerAddressZip;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public int getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(int customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    public String getFullName(){
        return getCustomerFirst() + " " + getCustomerLast();
    }
    public String toString() {
        return String.format("%d %s %s %s", getCustomerId(), getCustomerFirst(), getCustomerMiddleInitial(), getCustomerLast());
    }
}
