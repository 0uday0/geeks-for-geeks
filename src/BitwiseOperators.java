public class BitwiseOperators {

    public static int andOperation(int x,int y) {
        return x&y;
    }

    public static int orOperation(int x,int y) {
        return x|y;
    }

    public static int xorOperation(int x, int y) {
        return x^y;
    }

    public static int notOperator(int x) {return ~x;}

    public static int leftShiftOperator(int x,int y) {
        return x << y;
    }

    public static int signedRightShiftOperator(int x, int y) {
        return x >> y;
    }
    public static int unsignedRightShiftOperator(int x, int y) {
        return x >>> y;
    }

    public static String findBinaryRepresentationOfANumber(int x) {
        if (x > 0) {
            return binaryRepresentationOfAGivenPositiveInteger(x);
        } else if(x < 0) {
            String binaryString = "1".repeat(32);
            if (x == -1 ) {
                return binaryString;
            } else {
                // To represent -2 I need to remove -1 from 2 ** 32 - 1 representation and to represent  -3 I need to remove -2 from 2 ** 32 -1 representation, for -4 I need to remove -3 from 2 ** 32 - 1 representation
                String posBinaryRepresentation = binaryRepresentationOfAGivenPositiveInteger(Math.abs(x)-1);
                System.out.println("My #1 "+posBinaryRepresentation);
                for (int j = 0; j < posBinaryRepresentation.length(); j++) {
                    if (posBinaryRepresentation.charAt(j) == '1') {
                        binaryString = binaryString.substring(0,j)+"0"+binaryString.substring(j+1);
                    }
                }
                return binaryString;
            }
        }
        return "0".repeat(32);
    }
    public static String binaryRepresentationOfAGivenPositiveInteger(int x) {
        String binaryRepresentation = "0".repeat(32);
        while (x != 0) {
            int i = 0;
            while (Math.pow(2,i) <= x) {
                i += 1;
            }
            System.out.println("The total character length "+binaryRepresentation.length());
            System.out.println("The last part is "+(32-i));
            System.out.println("Binary Representation second part "+binaryRepresentation.substring(32-i));
            binaryRepresentation = binaryRepresentation.substring(0,32-i) +"1"+binaryRepresentation.substring(33-i);
            System.out.println("My Final length "+binaryRepresentation.length());

            x =(int) (x - Math.pow(2,i-1));

        }
        return binaryRepresentation;
    }
    public static boolean isKBitSet(int x,int k) {
        String s = findBinaryRepresentationOfANumber(x);
        boolean result = false;
        for (int i =0; i < s.length(); i++) {
           if (s.charAt(k-1) == '1') {
               result = true;
               break;
           }
        }
        return result;
    }

    public static boolean isKBitSetCorrectImplementation(int x, int k) {
        if (k == 1) {
            if ((x&k) == 0) {
                return false;
            }
            return true;
        }
        int temp = 1 << (k-1);
        if ((x&temp) == 0) {
            return false;
        }
        return true;
    }

    public static int numberOfBitsSet(int x) {
        int count = 0;
        for (int  i = 1; i <=32;i+=1) {
            if (isKBitSetCorrectImplementation(x,i)) {
                count +=1;
            }
        }
        return count;

    }

    public static int moreEfficientApproach(int x) {
        int count = 0;
        int startPosition = 1;
        int temp  =1;
        while(startPosition <= 32) {
            if ((x & temp) != 0) {
                count +=1;
            }
            startPosition += 1;
            temp = temp << 1;
        }
        return count;

    }

    public static boolean powerOfTwo(int x) {
        int i = 0;
        int power =(int) Math.pow(2,i);
        while (power<x) {
            i +=1;
            power = (int) Math.pow(2,i);
        }
        if (power == x) {
            return true;

        }
        return false;

    }

    public static int countSetBitsUsingBrianKerninghamAlgorithm(int x) {
        int res = 0;
        while (x != 0) {
            x = x &(x-1);
            res +=1;
        }
        return  res;
    }

}
