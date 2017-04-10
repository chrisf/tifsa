package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportDAO;
import org.jsack.tifsa.Database.Reports.ReportModels.CustomerUnpaidBalances;
import org.junit.Test;

import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportTest {
    @Test
    public void reportTest() {
        ReportDAO reportDAO = new ReportDAO();
        CustomerUnpaidBalances cub = new CustomerUnpaidBalances();
        List<ReportBase> rb = new ReportDAO().getData(cub);
        System.out.println(rb.size());
    }
}
