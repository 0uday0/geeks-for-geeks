public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(5));
        System.out.println(towerOfHanoiPathPrinting(5,'A','B','C'));
    }

    public static int towerOfHanoi(int num) {
        if (num == 1) {
            return 1;
        }
        return (2 * towerOfHanoi(num-1))+1;
    }

    public static int towerOfHanoiPathPrinting(int num,char A, char B,char C) {
        if (num == 1) {
            System.out.println("Move 1 from "+A+" to "+C);
           return 1;
        }
        int stepsToMoveAllTheDisksExceptTheLastToB = towerOfHanoiPathPrinting(num-1,A,C,B);
        System.out.println("Move "+num+"from "+A+" to "+C);
        int stepsToMoveAllTheDisksInBToC = towerOfHanoiPathPrinting(num-1,B,A,C);
        return stepsToMoveAllTheDisksInBToC + stepsToMoveAllTheDisksExceptTheLastToB +1;
    }



}
