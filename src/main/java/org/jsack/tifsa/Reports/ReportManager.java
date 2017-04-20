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

        //Add new reports to the correct category here when finished
        

        // Customer reports
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerUnpaidBalances.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerIncidentReport.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerTotalDue.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.FrequentCustomer.Report());
      
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerOrderByDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerOrderByMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerOrderByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerOrderByYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Customer.CustomerOrderTotals.Report());

        // Discounts
        reports.add(new org.jsack.tifsa.Reports.Discount.DiscountsByEmployee.Report());
        reports.add(new org.jsack.tifsa.Reports.Discount.ShowTotalDiscountsGivenByYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Discount.ShowTotalDiscountsGivenPerDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Discount.ShowTotalDiscountsGivenPerMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Discount.ShowTotalDiscountsGivenPerWeek.Report());


        //Employee
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeHistory.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeRevenueByDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeRevenueByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeRevenueByYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeOrdersByYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.EmployeeRoles.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.IncidentsByEmployee.Report());
        reports.add(new org.jsack.tifsa.Reports.Employee.TotalEmployeeIncident.Report());

        //Delivery reports
        reports.add(new org.jsack.tifsa.Reports.Delivery.DailyDeliveryReport.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.DailyPickupItems.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.MonthlyOutsourcedDeliveries.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.ShowPastDeliveries.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.ShowUnsuccessfulDeliveries.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.WeeklyDeliveryReport.Report());
        reports.add(new org.jsack.tifsa.Reports.Delivery.WeeklyPickupItems.Report());

        // Order reports
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.OrdersBySpecificYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.DailyTotalOrdersByEmployee.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.WeeklyTotalOrdersByEmployee.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.MonthlyTotalOrdersByEmployee.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowCanceledOrders.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowOrdersCompletedByMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowOrdersCompletedByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowOrderTotalAboveSpecificAmount.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowTotalOrdersCompletedOnDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowTotalOrdersCompletedOnYear.Report());
        reports.add(new org.jsack.tifsa.Reports.Order.ShowUnpaidOrders.Report());


        //Product Reports
        reports.add(new org.jsack.tifsa.Reports.Product.ShowProductByVendor.Report());
        reports.add(new org.jsack.tifsa.Reports.Product.ShowTotalProductsSoldByDate.Report());
        reports.add(new org.jsack.tifsa.Reports.Product.ShowTotalProductsSoldByMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Product.ShowTotalProductsSoldByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Product.ShowTotalProductsSoldByYear.Report());

        // Revenue reports
        reports.add(new org.jsack.tifsa.Reports.Revenue.RevenueByDay.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.RevenueByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByMonth.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByDate.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByWeek.Report());
        reports.add(new org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByYear.Report());


        // Vendor reports
        reports.add(new org.jsack.tifsa.Reports.Vendor.ShowAllVendors.Report());
        reports.add(new org.jsack.tifsa.Reports.Vendor.ShowVendorContacts.Report());
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
