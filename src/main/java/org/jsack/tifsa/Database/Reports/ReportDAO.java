package org.jsack.tifsa.Database.Reports;

import org.jsack.tifsa.Database.ModelBase;
import org.jsack.tifsa.Database.Reports.ReportModels.CustomerIncidentReport;
import org.jsack.tifsa.Database.Reports.ReportModels.CustomerUnpaidBalances;
import org.jsack.tifsa.Database.Reports.ReportModels.EmployeeRevenueByYear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportDAO extends ModelBase {

    private List<ReportBase> reports;

    public ReportDAO() {
        reports = new ArrayList<>();

        reports.add(new CustomerUnpaidBalances());
        reports.add(new EmployeeRevenueByYear());
        reports.add(new CustomerIncidentReport());
    }

    public List<String> getReportCategories() {
        List<String> categories = new ArrayList<>();
        reports.forEach(r -> {
            if(!categories.contains(r.getCategory().name())) {
                categories.add(r.getCategory().name());
            }
        });
        return categories;
    }

    public List<String> getReportNamesByCategory(String category) {
        List<String> reportNames = new ArrayList<>();

        reports.forEach( r -> {
            if(r.getCategory().name() == category) {
                reportNames.add(r.getName());
            }
        });
        return reportNames;
    }

    public ReportBase getReportByName(String name) {
        return reports.stream().filter(r -> r.getName() == name).findFirst().get();
    }

    public List<ReportBase> getData(ReportBase rb) {
        return getTemplate().query(rb.getSql(), rb.getMapper());
    }
}
