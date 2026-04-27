import java.util.ArrayList;

class RabinKarp {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = text.length();
        int m = pattern.length();
        
        if (m > n) return result;

        int base = 256;
        int mod = 1000000007;

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }

        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            textHash = (textHash * base + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {

            if (patternHash == textHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }

            if (i < n - m) {
                textHash = (textHash - text.charAt(i) * h) % mod;
                if (textHash < 0) textHash += mod;

                textHash = (textHash * base + text.charAt(i + m)) % mod;
            }
        }

        return result;
    }
}