package Arrays;

import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Map;

public class MaximumAppearingElement {

    public static void main(String[] args) {


    }
    public static int maximumAppearingElement(int[] leftBoundaries,int[] rightBoundaries) {

        int size = leftBoundaries.length;
        int maxFreqEncounteredSoFar = 1;
        int elementAppearingWithMaxFrequency = leftBoundaries[0];
        int minLimitOnLeft = leftBoundaries[0];
        int maxLimitOnRight = rightBoundaries[0];
        Map<Integer,Integer> frequencies = new HashMap<>();

        for (int i = 0; i < size; i += 1) {
            if (leftBoundaries[i] < minLimitOnLeft) {
              minLimitOnLeft = leftBoundaries[i];
            }
            if (rightBoundaries[i] > maxLimitOnRight) {
                maxLimitOnRight = rightBoundaries[i];
            }
        }
        for (int j = minLimitOnLeft; j <= maxLimitOnRight; j +=1) {
            for (int k = 0; k < size; k +=1) {
                if (j >= leftBoundaries[k] && j <= rightBoundaries[k]) {
                    if (frequencies.containsKey(j)) {
                        frequencies.put(j,frequencies.get(j)+1);
                    } else {
                        frequencies.put(j,1);
                    }
                    if (frequencies.get(j) > maxFreqEncounteredSoFar) {
                        maxFreqEncounteredSoFar = frequencies.get(j);
                        elementAppearingWithMaxFrequency = j;
                    }
                }
            }

        }
        return elementAppearingWithMaxFrequency;

    }

    public static int moreEfficientApproach(int[] leftBoundaries,int[] rightBoundaries) {
        int maximumElement  = rightBoundaries[0];
        int size = leftBoundaries.length;
        for (int i = 0; i < size; i +=1) {
            if (maximumElement < rightBoundaries[i]) {
                maximumElement = rightBoundaries[i];
            }
        }
        // Initialize an array
        int[] array = new int[maximumElement+1];
        for (int  j = 0; j < size; j +=1) {
            array[leftBoundaries[j]] += 1;
            if (rightBoundaries[j]+1 <= maximumElement) {
                array[rightBoundaries[j]+1] -=1;
            }
        }
        int[] prefixSum = new int[maximumElement+1];
        for (int k = 0; k < maximumElement+1; k+=1) {
            if (k == 0) {
                prefixSum[k] = array[0];
            } else{
                prefixSum[k] = array[k] + prefixSum[k-1];
            }
        }
        int maximumFrequencyEnteredSoFar = 0;
        int elementAppearingWithMaxFreq = 0;
        for (int l = 0; l < maximumElement +1; l+=1) {
            if (prefixSum[l] > maximumFrequencyEnteredSoFar) {
                maximumFrequencyEnteredSoFar = prefixSum[l];
                elementAppearingWithMaxFreq = l;
            }

        }
        return elementAppearingWithMaxFreq;

    }
}
