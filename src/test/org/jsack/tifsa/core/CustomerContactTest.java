package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.CustomerContact.CustomerContact;
import org.jsack.tifsa.Database.CustomerContact.CustomerContactDAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaron on 3/23/17.
 */
public class CustomerContactTest {
    @Test
    public void customerContactCRUDTest() {
        CustomerContact cc = new CustomerContact();
        CustomerContactDAO ccDao = new CustomerContactDAO();

        cc.setCustomerContactPrimary(true);
        cc.setCustomerContactTypeId(1);
        cc.setCustomerContactInfo("email@test.com");


        long id =  ccDao.create(cc);

        Assert.assertTrue(id > 0);
        if(id <= 0) {
            System.out.println("CustomerContact test failed at Create.");
            return;
        }

        CustomerContact rCc = ccDao.selectById(id);
        Assert.assertTrue(rCc != null);
        if(rCc == null) {
            System.out.println("CustomerContact test failed at retrieve.");
            ccDao.delete(id);
            return;
        }

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("CustomerContactInfo", "email2@test.com");

        ccDao.update(id, attributes);

        rCc = ccDao.selectById(id);
        Assert.assertTrue(rCc.getCustomerContactInfo().equals("email2@test.com"));
        if(!rCc.getCustomerContactInfo().equals("email2@test.com")) {
            System.out.println("CustomerContact test failed at update.");
            ccDao.delete(id);
            return;
        }

        ccDao.delete(id);
        Assert.assertTrue(ccDao.selectById(id) == null);
        if(ccDao.selectById(id) != null) {
            System.out.println("CustomerContact test failed at delete.");
            Assert.assertFalse(true);
            return;
        }
    }
}
