public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);

        boolean aBreaks = true;
        boolean bBreaks = true;

        for (int i = 0; i < a.length; i++) {
        }
    }
}