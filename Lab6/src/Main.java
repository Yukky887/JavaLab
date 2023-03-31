import java.util.Arrays;

    public class Main {

        static final int SIZE = 60000000;
        static final int HALF = SIZE / 2;

        public static void main(String[] args) {
            int threads = 7; // количество потоков

            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1.0f);

            long startTime = System.currentTimeMillis();

            Thread[] t = new Thread[threads];
            int offset = SIZE / threads;

            for (int i = 0; i < threads; i++) {
                int startIndex = i * offset;
                int endIndex = (i == threads - 1) ? SIZE - 1 : (i + 1) * offset - 1;
                t[i] = new Thread(() -> {
                    for (int j = startIndex; j <= endIndex; j++) {
                        arr[j] = (float) (arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                    }
                });
                t[i].start();
            }

            try {
                for (int i = 0; i < threads; i++) {
                    t[i].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time elapsed: " + (endTime - startTime) + " ms");

            // проверим, что значения массива изменились
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 10)));
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, HALF - 5, HALF + 5)));
        }
    }
