package org.mort11.navigation.io;

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

        private void populateDataPool(Vector2D store) {
            positionDataPool[poolIndex] = store;
            poolIndex++;
        }

        private Vector2D getMean(int samples) {
            Vector2D sum = new Vector2D(0, 0);
            for (int loopIndex = poolIndex - samples + 1; loopIndex <= poolIndex; loopIndex++) {
                sum = Vector2D.addVectors(sum, positionDataPool[loopIndex]);
            }

            return sum.scalarDivide(samples);
        }
    }

    public class ODSAnalyzer {
        // Orientation, Distance, and Speed analyzer

        public double[] dataPool = new double[poolCycles];
        public int poolIndex = 0;

        private void populateDataPool(double store) {
            dataPool[poolIndex] = store;
            poolIndex++;
        }

        public double getMean(int samples) {
            double sum = 0;
            for (int loopIndex = poolIndex - samples + 1; loopIndex <= poolIndex; loopIndex++) {
                sum += dataPool[loopIndex];
            }

            return sum / samples;
        }

        private double sum(int samples) {
            double sum = 0;
            for (int loopIndex = poolIndex - samples + 1; loopIndex <= poolIndex; loopIndex++) {
                sum += dataPool[loopIndex];
            }

            return sum;
        }
    }

}
