import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Object>> Mylist = new ArrayList<>();

        System.out.println(Mylist); // Перший виклик виведенняS

        Scanner scanner=new Scanner(System.in);
        System.out.println("input  price");
        int price1=scanner.nextInt();
        Scanner scanner2=new Scanner(System.in);
        System.out.println("input  name");
        String item1=scanner2.nextLine();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add(item1);
        row1.add(price1);
        Mylist.add(row1);

        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("Phone");
        row2.add(2000);
        Mylist.add(row2);

        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("Wathc");
        row3.add(500);
        Mylist.add(row3);

        System.out.println(Mylist); // Другий виклик виведення

        // Підрахунок суми корзини.
        int totalSum = 0;
        for (ArrayList<Object> item : Mylist) {
            Object priceObj = item.get(1); // друга позиція – ціна
            int price = 0;
            if (priceObj instanceof  Integer) {
                price = (Integer) priceObj;
            }

            totalSum += price;  // Перемістили цей рядок всередину циклу, щоб використовувати price
        }

        System.out.println("Сума корзини: " + totalSum);

        System.out.println(Mylist.get(0));
        Mylist.get(0).set(1,3);
        Mylist.get(0).set(0,"roman");
        System.out.println(Mylist);
        AVarage(4,2,2);
    }

    public static void AVarage(int a1,int a2,int x) {
       // int a1=2;
       // int a2=3;
      //  int a3=4;
       // int x=3;
        int avg=(a1+a2)/x;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(avg);
    }

}
