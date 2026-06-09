public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int ops = 0;

        while (target > startValue) {
            if ((target & 1) == 1) {
                target++;
            }
        }
    }
}