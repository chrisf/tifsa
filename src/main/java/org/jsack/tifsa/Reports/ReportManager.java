package org.jsack.tifsa.Reports;

import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportManager {
    private List<IReport> reports;
    private ApplicationContext context;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public ReportManager() {
        template = Julius.getJdbcTemplate();
        namedTemplate = Julius.getJdbcNamedTemplate();

        reports = new ArrayList<>();

        // Employee reports
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeRevenueByYear.Report());

        // Customer reports
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerUnpaidBalances.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerIncidentReport.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerTotalDue.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.FrequentCustomer.Report());

        //Delivery reports
        reports.add(new org.jsack.tifsa.Reports.Delivery.DailyDeliveryReport.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.DailyPickupItems.Report());


        // Order reports
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificYear.Report());

        // Revenue reports
        reports.add(new org.jsack.tifsa.Reports.Revenue.RevenueByDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.RevenueByWeek.Report());
    }

    public IReport getReportByName(String name) {
        return reports.stream().filter(r -> r.getName().equals(name)).findFirst().get();
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
    public List<ReportModelBase> runReport(IReport report) {

        return template.query(report.getSql(), report.getMapper());
    }
    public List<ReportModelBase> runReport(IReport report, Map<String,Object> attributes) {
        return namedTemplate.query(report.getSql(), attributes, report.getMapper());
    }
}
