package org.mort11.navigation;

import org.mort11.util.Vector2D;

public class HistoricalDataAnalyzer extends NavigationDataHandler {

	/**
	 * Each subsystem is going to be polled once every 20ms.
	 */

	public int autonTimeInMS = 15000;

	// Divide auton length by poll
	public int poolCycles = autonTimeInMS / 20;

	public Nav6 nav6 = new Nav6();
	public EncoderHandler encoder = new EncoderHandler();

	// Generate Position vecto

	public Vector2D generatePosition() {
		position = new Vector2D(currentPositionX, currentPositionY);
		return position;
	}

	// Historical Analysis

	public class orientationAnalyzer {
		private double[] orientationDataPool = new double[poolCycles];
		private int poolIndex = 0;
		private double currentData = nav6.setOrientation();

		public void populateDataPool() {

			orientationDataPool[poolIndex] = currentData;
			poolIndex++;

		}

		private double compareWithCurrentBatch() {
			double fourBack = orientationDataPool[poolIndex - 4];
			double threeBack = orientationDataPool[poolIndex - 3];
			double twoBack = orientationDataPool[poolIndex - 2];
			double oneBack = orientationDataPool[poolIndex - 1];
			double current = orientationDataPool[poolIndex];

			double dataMean = fourBack + threeBack + twoBack + oneBack
					+ current / 5;

			return dataMean;
		}

		public void denoise() {

		}
	}

	public class speedLeftAnalyzer {
		private double[] speedLeftDataPool = new double[poolCycles];
		private int poolIndex = 0;
		private double currentData = encoder.getSpeedLeft();

		public void populateDataPool() {

			speedLeftDataPool[poolIndex] = currentData;
			poolIndex++;

		}

		private double compareWithCurrentBatch() {
			double fourBack = speedLeftDataPool[poolIndex - 4];
			double threeBack = speedLeftDataPool[poolIndex - 3];
			double twoBack = speedLeftDataPool[poolIndex - 2];
			double oneBack = speedLeftDataPool[poolIndex - 1];
			double current = speedLeftDataPool[poolIndex];

			double dataMean = fourBack + threeBack + twoBack + oneBack
					+ current / 5;

			return dataMean;
		}

		public void denoise() {

		}
	}

	public class speedRightAnalyzer {
		public double[] speedRightDataPool = new double[poolCycles];
		public int poolIndex = 0;
		private double currentData = encoder.getSpeedRight();

		public void populateDataPool() {

			speedRightDataPool[poolIndex] = currentData;
			poolIndex++;

		}

		private double compareWithCurrentBatch() {
			double fourBack = speedRightDataPool[poolIndex - 4];
			double threeBack = speedRightDataPool[poolIndex - 3];
			double twoBack = speedRightDataPool[poolIndex - 2];
			double oneBack = speedRightDataPool[poolIndex - 1];
			double current = speedRightDataPool[poolIndex];

			double dataMean = fourBack + threeBack + twoBack + oneBack
					+ current / 5;

			return dataMean;
		}

		public void denoise() {

		}
	}

	public class distanceDTLeftAnalyzer {
		public double[] distanceDTLeftDataPool = new double[poolCycles];
		public int poolIndex = 0;
		private double currentData = encoder.getDistanceDTLeft();

		public void populateDataPool() {

			distanceDTLeftDataPool[poolIndex] = currentData;
			poolIndex++;

		}

		private double compareWithCurrentBatch() {
			double fourBack = distanceDTLeftDataPool[poolIndex - 4];
			double threeBack = distanceDTLeftDataPool[poolIndex - 3];
			double twoBack = distanceDTLeftDataPool[poolIndex - 2];
			double oneBack = distanceDTLeftDataPool[poolIndex - 1];
			double current = distanceDTLeftDataPool[poolIndex];

			double dataMean = fourBack + threeBack + twoBack + oneBack
					+ current / 5;

			return dataMean;
		}

		public void denoise() {

		}
	}

	public class distanceDTRightAnalyzer {
		public double[] distanceDTRightDataPool = new double[poolCycles];
		public int poolIndex = 0;
		private double currentData = encoder.getDistanceDTRight();

		public void populateDataPool() {
			distanceDTRightDataPool[poolIndex] = currentData;
			poolIndex++;
		}

		private double compareWithCurrentBatch() {
			double fourBack = distanceDTRightDataPool[poolIndex - 4];
			double threeBack = distanceDTRightDataPool[poolIndex - 3];
			double twoBack = distanceDTRightDataPool[poolIndex - 2];
			double oneBack = distanceDTRightDataPool[poolIndex - 1];
			double current = distanceDTRightDataPool[poolIndex];

			double dataMean = fourBack + threeBack + twoBack + oneBack
					+ current / 5;

			return dataMean;
		}

		public void denoise() {

		}
	}

	public class positionAnalyzer {
		public Vector2D[] positionDataPool = new Vector2D[poolCycles];
		public int poolIndex = 0;
		private Vector2D currentData = generatePosition();

		public void populateDataPool() {
			positionDataPool[poolIndex] = currentData;
			poolIndex++;
		}

		private Vector2D compareWithCurrentBatch() {
			Vector2D fourBack = positionDataPool[poolIndex - 4];
			Vector2D threeBack = positionDataPool[poolIndex - 3];
			Vector2D twoBack = positionDataPool[poolIndex - 2];
			Vector2D oneBack = positionDataPool[poolIndex - 1];
			Vector2D current = positionDataPool[poolIndex];

			Vector2D combineFourAndThree = Vector2D.addVectors(fourBack,
					threeBack);
			Vector2D combineTwoAndOne = Vector2D.addVectors(twoBack, oneBack);
			Vector2D combineFourThreeTwoOne = Vector2D.addVectors(
					combineFourAndThree, combineTwoAndOne);
			Vector2D combineSet3 = Vector2D.addVectors(combineFourThreeTwoOne,
					current);
			Vector2D dataMean = Vector2D.scalarDivide(combineSet3, 5);

			return dataMean;
		}

		public void denoise() {

		}
	}
}
