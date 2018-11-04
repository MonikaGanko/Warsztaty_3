package pl.coderslab.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private int orderId;
    private Date addDate;
    private Date repairPlannedStartDate;
    private Date repairStartDate;
    private Employee employee;
    private Vehicle vehicle;
    private Status status;
    private String problemDescription;
    private String repairDescription;
    private double customerCost;
    private double componentsCost;
    private double manHourQuantity;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getRepairPlannedStartDate() {
        return repairPlannedStartDate;
    }

    public void setRepairPlannedStartDate(Date repairPlannedStartDate) {
        this.repairPlannedStartDate = repairPlannedStartDate;
    }

    public Date getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Date repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public Employee getEmployee() { return  employee; }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){return vehicle;}

    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {return status;}

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(double customerCost) {
        this.customerCost = customerCost;
    }

    public double getComponentsCost() {
        return componentsCost;
    }

    public void setComponentsCost(double componentsCost) {
        this.componentsCost = componentsCost;
    }

    public double getManHourQuantity() {
        return manHourQuantity;
    }

    public void setManHourQuantity(double manHourQuantity) {
        this.manHourQuantity = manHourQuantity;
    }

    private String getDateString(Date date) {
        if(addDate!=null){
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        }else{
            return "-";
        }

    }

    public String getAddDateString() {
        return getDateString(addDate);
    }

    public String getRepairPlannedStartDateString() {
        return getDateString(repairPlannedStartDate);
    }

    public String getRepairStartDateString() {
        return getDateString(repairStartDate);
    }
}
