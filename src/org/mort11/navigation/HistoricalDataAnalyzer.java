package org.mort11.navigation;

import org.mort11.util.Vector2D;

public class HistoricalDataAnalyzer {

	/**
	 * Each subsystem is going to be polled once every 20ms.
	 */

	public int autonTimeInMS = 15000;

	// Divide auton length by poll rate
	public int poolCycles = autonTimeInMS / 20;

	public class VectorAnalyzer {

		public Vector2D[] positionDataPool = new Vector2D[poolCycles];
		public int poolIndex = 0;

		public void populateDataPool(Vector2D store) {
			Vector2D currentData = store;
			positionDataPool[poolIndex] = currentData;
			poolIndex++;
		}

		private Vector2D getMean(int samples) {
			Vector2D sum = new Vector2D(0, 0);
			for (int loopIndex = poolIndex - samples + 1; loopIndex <= poolIndex; loopIndex++) {
				sum = Vector2D.addVectors(sum, positionDataPool[loopIndex]);
			}

			Vector2D dataMean = sum.scalarDivide(samples);

			return dataMean;
		}
	}

	public class ODSAnalyzer {
		// Orientation, Distance, and Speed analyzer

		public double[] dataPool = new double[poolCycles];
		public int poolIndex = 0;

		public void populateDataPool(double store) {
			double currentData = store;
			dataPool[poolIndex] = currentData;
			poolIndex++;
		}

		private double getMean(int samples) {
			double sum = 0;
			for (int loopIndex = poolIndex - samples + 1; loopIndex <= poolIndex; loopIndex++) {
				sum += dataPool[loopIndex];
			}

			double dataMean = sum / samples;

			return dataMean;
		}
	}

}
