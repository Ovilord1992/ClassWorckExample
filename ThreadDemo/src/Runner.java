import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static int even, odd;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> values = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("file.txt")))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                Arrays.asList(str.split(" ")).stream().forEach(el ->
                        values.add(Integer.valueOf(el))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> evens = values.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
        List<Integer> odds = values.stream().filter(el -> el % 2 != 0).collect(Collectors.toList());

        new Thread(new EvenNumbersThread(evens, true)).start();
        new Thread(new EvenNumbersThread(odds, false)).start();

        Thread.sleep(1000);
        System.out.println(Runner.even);
        System.out.println(Runner.odd);
    }

}

class EvenNumbersThread implements Runnable {

    private File file = null;
    private List<Integer> values;
    private boolean even = false;

    public EvenNumbersThread(List<Integer> evens, boolean even) {
        this.values = evens;
        this.even = even;
        this.file = even ? new File("evenFile.txt") : new File("oddFile.txt");
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int value : values) {
                bw.append(String.valueOf(value) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isEven()) {
            Runner.even = values.size();
        } else {
            Runner.odd = values.size();
        }
    }

    public boolean isEven() {
        return even;
    }
}


