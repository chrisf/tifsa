package org.jsack.tifsa.Reports;

import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportsController {
    private List<IReport> reports;
    private ApplicationContext context;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public ReportsController() {
        String dataSource = System.getProperty("dataSource");

        // set default data source bean
        if(dataSource == null) {
            dataSource = "dataSource";
        }

        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        template = new JdbcTemplate((javax.sql.DataSource)this.context.getBean(dataSource));
        namedTemplate = new NamedParameterJdbcTemplate(template);

        reports = new ArrayList<>();

        reports.add(new org.jsack.tifsa.Reports.EmployeeRevenueByYear.Report());
        reports.add(new org.jsack.tifsa.Reports.CustomerUnpaidBalances.Report());
        reports.add(new org.jsack.tifsa.Reports.CustomerIncidentReport.Report());
    }

    public IReport getReportByName(String name) {
        return reports.stream().filter(r -> r.getName() == name).findFirst().get();
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

    public List<String> getReportsByCategory(String category) {
        List<String> reportNames = new ArrayList<>();
        reports.forEach( r -> {
            if(r.getCategory().name() == category) {
                reportNames.add(r.getName());
            }
        });
        return reportNames;
    }
    public List<IReportModel> runReport(IReport report) {
        return template.query(report.getSql(), report.getMapper());
    }
    public List<IReportModel> runReport(IReport report, Map<String,Object> attributes) {
        return namedTemplate.query(report.getSql(), attributes, report.getMapper());
    }
}
