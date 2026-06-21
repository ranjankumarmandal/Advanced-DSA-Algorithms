public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);

    }
}