public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
    }
}