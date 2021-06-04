import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// Antibiotik228

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Перше завдання.");
        System.out.println("2. Друге завдання.");
        System.out.println("3. Третє завдання.");
        System.out.println("4. Вихід.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (num != 4) {
            try {
                switch (num) {
                    case 1:
                        task1();
                        break;
                    case 2:
                        task2();
                        break;
                    case 3:
                        task3();
                        break;
                    default:
                        System.out.println("Не вірно введене число!!! Повторіть спробу :");
                        break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("1. Перше завдання.");
            System.out.println("2. Друге завдання.");
            System.out.println("3. Третє завдання.");
            System.out.println("4. Вихід.");
            System.out.print("Введіть число : ");
            num = scanner.nextInt();
        }
    }


    /*
     * 7. Написати програму, яка виводить назву знака зодіака за його порядковим номером.
     * */
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер(1-12) : ");
        int nomer = scanner.nextInt();
        do {
            if (nomer >= 1 && nomer <= 12) {
                switch (nomer) {
                    case 1 -> System.out.println("Овен");
                    case 2 -> System.out.println("Телець");
                    case 3 -> System.out.println("Близнеці");
                    case 4 -> System.out.println("Рак");
                    case 5 -> System.out.println("Лев");
                    case 6 -> System.out.println("Діва");
                    case 7 -> System.out.println("Терези");
                    case 8 -> System.out.println("Скорпіон");
                    case 9 -> System.out.println("Стрілец");
                    case 10 -> System.out.println("Козеріг");
                    case 11 -> System.out.println("Водолій");
                    case 12 -> System.out.println("Риби");
                }
                break;
            } else {
                System.out.print("Введіть номер(1-12) : ");
                nomer = scanner.nextInt();
            }
        } while (true);
    }


    /*
     * 7. Протабулювати функцію y=f(x), з параметром x, який змінюється від 'a' до 'b' з кроком h
     * */
    public static void task2() throws IOException {
        double a = -Math.PI / 2, b = (3 * Math.PI) / 2;
        double dx = Math.PI / 3;
//        for (double x = a; x <= b; x += dx) {
//            if((3*x-12) == 0) throw new IOException("На нуль ділити не можна");
//            double y = Math.exp(x)/(3*x-12);
//            System.out.print(x + "\t" + y + "\n");
//        }

        double x = a;
        do {
            double y = Math.pow(Math.cos(x), 2) + 3 * Math.sin(x);
            System.out.println("x = " + String.format("%.2f", x) + "\ty = " + String.format("%.2f", y));
            x += dx;
        } while (x <= b);
    }


    /*
     * 7. Визначити 1) максимальний за модулем елемент масиву;
     * 2) суму елементів масиву, розташованих після останнього нульового елемента.
     * */
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(200) - 100;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();

        int maxIndex = 0, max = mas[maxIndex];
        int last_null = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) last_null = i;
            if (Math.abs(mas[i]) > max) {
                max += Math.abs(mas[i]);
                maxIndex = i;
            }
        }
        System.out.println("Максимальний за модулем елемент(" + maxIndex + ") масиву = " + mas[maxIndex]);

        if (last_null == -1)
            System.err.println("Нульових елементів не знайдено!");
        else if (last_null == mas.length - 1)
            System.err.println("Нульовий елемент є останнім!");
        else {
            int suma = 0;
            for (int i = last_null; i < mas.length; i++) {
                suma += mas[i];
            }
            System.out.println("Cума елементів масиву, розташованих після останнього " +
                    "нульового елемента(A[" + last_null + "] = " + mas[last_null] + ") = " + suma);
        }
    }
}