package edu.asu.sese.diskEvolution.model;

import java.util.LinkedList;
import java.util.List;

import edu.asu.sese.diskEvolution.util.PhysicalConstants;

public class Parameters {
    private double rmin;
    private double rmax;
    private double deltar0;
    private int intervalCount;
    private double density0;
    private double radius0;
    private double exponent;
    
    private List<ParameterObserver> observerList =
            new LinkedList<ParameterObserver>();

    public Parameters() {
        initializeDensityParameters();
        initializeGridParameters();
    }

    public void initializeDensityParameters() {
        setDensity0(1e3);
    	setRadius0(PhysicalConstants.auInCm);
    	setExponent(-1.5);
    }

    public void initializeGridParameters() {
        setRmin(0.1 * PhysicalConstants.auInCm);
        setRmax(200.0 * PhysicalConstants.auInCm);
        setDeltar0(0.1 * PhysicalConstants.auInCm);
        setIntervalCount(50);
    }

    public double getRmin() {
        return rmin;
    }

    public void setRmin(double rmin) {
        this.rmin = rmin;
        notifyObserversRadialParamterChanged();
    }

    public double getRmax() {
        return rmax;
    }

    public void setRmax(double rmax) {
        this.rmax = rmax;
        notifyObserversRadialParamterChanged();
    }

    public double getDeltar0() {
        return deltar0;
    }

    public void setDeltar0(double deltar0) {
        this.deltar0 = deltar0;
        notifyObserversRadialParamterChanged();
    }

    public int getIntervalCount() {
        return intervalCount;
    }

    public void setIntervalCount(int intervalCount) {
        this.intervalCount = intervalCount;
        notifyObserversRadialParamterChanged();
    }

    public double getDensity0() {
        return density0;
    }

    public void setDensity0(double density0) {
        this.density0 = density0;
    }

    public double getRadius0() {
        return radius0;
    }

    public void setRadius0(double radius0) {
        this.radius0 = radius0;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    public void addObserver(ParameterObserver observer) {
        observerList.add(observer);        
    }

    private void notifyObserversRadialParamterChanged() {
        for (ParameterObserver observer: observerList) {
            observer.notifyRadialParameterChanged();
        }
        
    }
}