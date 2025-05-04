import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBotCart {

    private static Map<String, Integer> cart = new HashMap<>();

    public static void main(String[] args) {
        cart.put("apple", 2);
        cart.put("banana", 3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вітаю! Я чат-бот для управління корзиною.");
        while (true) {
            System.out.println("\nВведіть команду (update, delete, show, exit):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "update":
                    System.out.println("Введіть назву товару:");
                    String item = scanner.nextLine();
                    System.out.println("Введіть нову кількість (або залиште порожнім — буде 1):");
                    String quantityInput = scanner.nextLine();
                    Integer quantity = null;

                    if (!quantityInput.isEmpty()) {
                        quantity = Integer.parseInt(quantityInput);
                    }

                    updateItem(item, quantity);
                    break;
                case "delete":
                    System.out.println("Введіть назву товару для видалення:");
                    String itemToDelete = scanner.nextLine();
                    deleteItem(itemToDelete);
                    break;
                case "show":
                    showCart();
                    break;
                case "exit":
                    System.out.println("До побачення!");
                    return;
                default:
                    System.out.println("Невідома команда.");
            }
        }
    }

    // Метод з необов'язковим параметром (імітуємо через null)
    public static void updateItem(String item, Integer quantity) {
        if (quantity == null) {
            quantity = 1; // значення за замовчуванням
        }

        cart.put(item, quantity);
        System.out.println("Оновлено: " + item + " — " + quantity + " шт.");
    }

    public static void deleteItem(String item) {
        if (cart.containsKey(item)) {
            cart.remove(item);
            System.out.println("Товар \"" + item + "\" видалено з корзини.");
        } else {
            System.out.println("Товар не знайдено.");
        }
    }

    public static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Корзина порожня.");
        } else {
            System.out.println("Вміст корзини:");
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " шт.");
            }
        }
    }
}