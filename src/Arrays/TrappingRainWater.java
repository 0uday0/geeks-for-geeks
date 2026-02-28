package Arrays;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heightArr = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(maxUnitsOfWaterThatCouldBeCaptured(heightArr));
//        System.out.println(alternateApproachForTrappingRainWater(heightArr));
//        List<Integer> s = new ArrayList<>();
//        s.add(5, 10);
        System.out.println(fasterSolution(heightArr));
    }
    public static int maxUnitsOfWaterThatCouldBeCaptured(int[] height) {
        int leftPointer = 0;
        int rightPointer = 1;
        int size = height.length;
        int distanceBetweenLeftAndRightBoundary = 0;
        int pebblesFoundSoFar = 0;
        int unitsOfWaterStored = 0;
        while (rightPointer < size) {
            if (height[leftPointer] > height[rightPointer]) {
                pebblesFoundSoFar += height[rightPointer];
                distanceBetweenLeftAndRightBoundary += 1;
            } else {
                if (distanceBetweenLeftAndRightBoundary >= 1) {
                    unitsOfWaterStored = (height[leftPointer] * (distanceBetweenLeftAndRightBoundary)- pebblesFoundSoFar);

                }
                leftPointer = rightPointer;
            }
            rightPointer += 1;

        }
        return unitsOfWaterStored;
    }

    public static int anotherApproach(int[] height) {
        List<Integer> localMaximaPositions = new ArrayList<>();
        List<Integer> pebbles = new ArrayList<>();
        int pebblesHeightBetweenMaximas = 0;
        int totalUnits = 0;
        int size = height.length;
        for (int i = 0; i < size ; i+=1) {
            if (i == 0 ) {
                if (height[i+1] < height[i]) {
                    localMaximaPositions.add(0);
                }

            } else if (i == size -1  && height[i] > height[i-1]) {
                while (localMaximaPositions.size() > 1 &&(height[i] > localMaximaPositions.get(localMaximaPositions.size()-1)) ) {
                    int removedElement = localMaximaPositions.remove(localMaximaPositions.size()-1);
                    pebblesHeightBetweenMaximas += removedElement;
                    int removedPebbleElement = pebbles.remove(pebbles.size()-1);
                    pebblesHeightBetweenMaximas += removedPebbleElement;
                }
                localMaximaPositions.add(size-1);

                pebbles.add(pebblesHeightBetweenMaximas);
            } else if ( height[i] > height[i-1] && height[i] > height[i+1]) {
                while (localMaximaPositions.size() > 1 &&(height[i] > localMaximaPositions.get(localMaximaPositions.size()-1)) ) {
                        int removedElement = localMaximaPositions.remove(localMaximaPositions.size()-1);
                        pebblesHeightBetweenMaximas += removedElement;
                        int removedPebbleElement = pebbles.remove(pebbles.size()-1);
                        pebblesHeightBetweenMaximas += removedPebbleElement;
                }

                localMaximaPositions.add(i);
                if (localMaximaPositions.size() > 1) {
                    pebbles.add(pebblesHeightBetweenMaximas);
                }


                pebblesHeightBetweenMaximas = 0 ;
            } else {
                pebblesHeightBetweenMaximas += height[i];
            }
        }
        System.out.println("Pebbles "+pebbles.toString());
        System.out.println("localMaximaPositions "+localMaximaPositions.toString());
        for (int k = 0; k < localMaximaPositions.size()-1; k += 1) {
            totalUnits += (Math.min(height[localMaximaPositions.get(k+1)],height[localMaximaPositions.get(k)]) * (localMaximaPositions.get(k+1)-localMaximaPositions.get(k)-1));
            totalUnits -= pebbles.get(k);
        }
        return totalUnits;

    }

    public static int alternateApproachForTrappingRainWater(int[] height) {
        int size = height.length;
        int totalUnits = 0;
        for (int i =1; i < size -1; i+=1) {
            int lmax = height[0];
            int rmax = height[size-1];
            for (int j = 0; j < i; j+=1) {
                if (height[j] > lmax) {
                    lmax = height[j];
                }
            }
            for (int k = i+1; k < size ; k +=1) {
                if (height[k] > rmax) {
                    rmax = height[k];
                }
            }
            int s = Math.min(lmax,rmax);
            if (s > height[i]) {
                totalUnits += (s-height[i]);
            }
        }
        return totalUnits;
    }

    public static int fasterSolution(int[] height) {
        int size = height.length;
        List<Integer> maxisBeforeToThisIndex = new ArrayList<>();
        List<Integer> maxisAfterToThisIndex = new ArrayList<>();
        // Given an Index i in order to get the right most maximum for that all u need to do is
        // maxisAfterToThisIndex.get(size-1-index)
        maxisBeforeToThisIndex.add(0);
        maxisAfterToThisIndex.add(0);
        for (int i = 0; i < height.length; i += 1) {
            int lastMax = maxisBeforeToThisIndex.get(maxisBeforeToThisIndex.size()-1);
            if (height[i] > lastMax) {
                maxisBeforeToThisIndex.add(height[i]);
            } else {
                maxisBeforeToThisIndex.add(lastMax);
            }
        }

        for (int j = height.length-1; j >= 0; j -=1) {
            int rightMax = maxisAfterToThisIndex.get(maxisAfterToThisIndex.size()-1);
            if (height[j] > rightMax) {
                maxisAfterToThisIndex.add(height[j]);
            } else {
                maxisAfterToThisIndex.add(rightMax);
            }
        }
        int totalUnits = 0;
        System.out.println("Left Maxis "+ maxisBeforeToThisIndex.toString());
        System.out.println("RIght Maxis "+maxisAfterToThisIndex.toString());
        for (int i =1; i < size -1; i+=1) {
            int lmax = maxisBeforeToThisIndex.get(i);
            int rmax = maxisAfterToThisIndex.get(size-1-i);

            int s = Math.min(lmax,rmax);
            if (s > height[i]) {
                totalUnits += (s-height[i]);
            }
        }
        return totalUnits;


    }
}
