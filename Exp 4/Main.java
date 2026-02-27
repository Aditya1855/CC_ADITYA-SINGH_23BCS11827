public class Main {

    static final long MOD = 1000000007;

    public static long sumBitDifferences(int[] arr) {
        int n = arr.length;
        long ans = 0;

        for (int bit = 0; bit < 31; bit++) {

            long set = 0;

            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    set++;
                }
            }

            long unset = n - set;

            ans = (ans + (set * unset) % MOD) % MOD;
        }

        return (ans * 2) % MOD;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(sumBitDifferences(arr));
    }
}