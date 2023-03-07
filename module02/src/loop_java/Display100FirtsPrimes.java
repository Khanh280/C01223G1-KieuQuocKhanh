package loop_java;

public class Display100FirtsPrimes {
    public static void main(String[] args) {
        System.out.println("[Bài tập] Hiển thị các số nguyên tố nhỏ hơn 100: ");
        int count;
        for (int i = 1; i <= 100; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(i);
            }
        }
    }
}
