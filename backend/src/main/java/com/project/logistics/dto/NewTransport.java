package com.project.logistics.dto;

import com.project.logistics.entity.TransportEntity;

public class NewTransport {
    private TransportEntity transport;
    private double repair;
    private double tires;
    private double fuel;
    private double oil;
    private double tech;

    public TransportEntity getTransport() {
        return transport;
    }

    public void setTransport(TransportEntity transport) {
        this.transport = transport;
    }

    public double getRepair() {
        return repair;
    }

    public void setRepair(double repair) {
        this.repair = repair;
    }

    public double getTires() {
        return tires;
    }

    public void setTires(double tires) {
        this.tires = tires;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getOil() {
        return oil;
    }

    public void setOil(double oil) {
        this.oil = oil;
    }

    public double getTech() {
        return tech;
    }

    public void setTech(double tech) {
        this.tech = tech;
    }
}
