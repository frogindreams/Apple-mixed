import java.util.Arrays;

class AppleMixed {
    public static void mixing(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[++k] = l[++i];
            } else {
                a[++k] = r[++j];
            }
        }

        while (i < left) {
            a[++k] = l[++i];
        }

        while (j < right) {
            a[++k] = r[++j];
        }
    }

    public static void MixUp(int[] a, int n) {
        if (n < 2) 
            return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; ++i) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; ++i) {
            r[i - mid] = a[i];
        }

        MixUp(l, mid);
        MixUp(r, n - mid);

        mixing(a, l, r, mid, n - mid);
    }

    public static void main(String[] args) {
        int[] actual = { 1, 5, 3, 2, 7, 1 };
        int[] expected = { 1, 1, 2, 3, 5, 7 };

        AppleMixed.MixUp(actual, actual.length);
        
        System.out.println(Arrays.toString(actual));
    }
}
