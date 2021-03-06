package edu.asu.sese.diskEvolution.model;

public class MassFlowGrid {

	private RadialGrid radialGrid;
	private int gridCount;
	private double[] value;

	public MassFlowGrid(RadialGrid radialGrid) {
		this.radialGrid = radialGrid;
		gridCount = radialGrid.getIntervalCount()+1;
		value = new double [gridCount];
	}
	

	public int getCount() {
		return gridCount;
	}


	public double getValue(int i) {
		return value[i];
	}


    public void setValue(int i, double data) {
        value[i] = data;
    }

}
