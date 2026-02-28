public class power {

    public static int computePower (int givenInteger,int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return givenInteger;
        }
        int temp = givenInteger;
        for (int i = 2; i <= power; i+=1) {
            givenInteger *=temp;
        }
        System.out.println("My Result "+givenInteger);
        return givenInteger;
    }

    public static double computePowerEfficient(int givenInteger,int power) {
        if (power == 0) {
            return 1;
        }
        if (power % 2 == 0) {
            System.out.println("Power is divisible by 2");
            return computePowerEfficient(givenInteger, power/2)*computePowerEfficient(givenInteger,power/2);
        } else {
            if (power > 0) {
                System.out.println("Multiplying");
                return computePowerEfficient(givenInteger,power-1)*givenInteger;
            } else {
                System.out.println("Dividing");

                System.out.println();
                return computePowerEfficient(givenInteger,power+1)/givenInteger;
            }

        }

    }
}
