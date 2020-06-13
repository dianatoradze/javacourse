import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        double[] t = new double[30];
        double sum = 0;
        double average = 0;
        int count=0;

        for (int i = 0; i < t.length; i++) {
            t[i] = Math.round(((Math.random() * (8 + 1)) + 32)*10.0)/10.0;
            System.out.print("Температура пациента №"); // так как в здании требуется в строку
            System.out.print((i+1) + ": "+ t[i] + " ");
        }

        if (t.length > 0) {
                    for (int j = 0; j < t.length; j++) {
                    sum += t[j];
                        if (t[j] >= 36.2 && t[j] <= 36.9) {
                            count ++;
                        }
                    }
                average = sum / t.length;
            }

        System.out.println("\n" + "Количество здоровых пациентов " + count);
        System.out.println("Средняя температура была " + Math.round(average*100.0)/100.0);

    }
}
