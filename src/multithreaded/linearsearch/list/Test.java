package multithreaded.linearsearch.list;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[11];

        array[0] = 1;
        System.out.println("[0]: " + array[0]);

        for(int i = 1; i < array.length-1; i++) {
            array[i] = (int) Math.floor(Math.random() * array.length + 1);

            System.out.println("[" + i + "]: " + array[i]);
        }

        array[10] = 1;
        System.out.println("[10]: " + array[10]);

        LinearSearchMultithreaded searchMulti = new LinearSearchMultithreaded();

        System.out.println("Result found at position: " + searchMulti.search(array, 1,3));
    }
}
