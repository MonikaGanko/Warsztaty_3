package pl.coderslab.model;

public class Employee {

    private int employeeId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
    private double manHourCost;

    public Employee() {
    }

    public Employee(String name, String surname, String email, String phoneNumber, String address, String description, double manHourCost) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
        this.manHourCost = manHourCost;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getManHourCost() {
        return manHourCost;
    }

    public void setManHourCost(double manHourCost) {
        this.manHourCost = manHourCost;
    }

    @Override
    public String toString() {
        return name + ' ' + surname;
    }
}
