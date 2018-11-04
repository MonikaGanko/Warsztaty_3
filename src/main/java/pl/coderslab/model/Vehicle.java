package pl.coderslab.model;

import java.util.Date;

public class Vehicle {

    private int vehicleId;
    private String brand;
    private String model;
    private Date manufacturYear;
    private String registrationNumber;
    private Date nextServicing;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, Date manufacturYear, String registrationNumber, Date nextServicing) {
        this.brand = brand;
        this.model = model;
        this.manufacturYear = manufacturYear;
        this.registrationNumber = registrationNumber;
        this.nextServicing = nextServicing;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacturYear() {
        return manufacturYear;
    }

    public void setManufacturYear(Date manufacturYear) {
        this.manufacturYear = manufacturYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getNextServicing() {
        return nextServicing;
    }

    public void setNextServicing(Date nextServicing) {
        this.nextServicing = nextServicing;
    }

    @Override
    public String toString() {
        return  brand + ' ' + model;
    }
}



