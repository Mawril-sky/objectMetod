//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Товары ===");
        Product p1 = new Product(101, "Смартфон X", 25000, "Электроника");
        Product p2 = new Product(102, "Наушники Pro", 5000, "Аудио");
        Product p3 = new Product(101, "Смартфон Y", 27000, "Электроника"); // тот же артикул и категория, что и у p1
        Product p4 = new Product(101, "Смартфон Z", 26000, "Гаджеты");       // тот же артикул, но другая категория

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("\np1.equals(p3) (тот же id и категория): " + p1.equals(p3)); // ожидается true
        System.out.println("p1.equals(p4) (тот же id, но другая категория): " + p1.equals(p4)); // ожидается false
        System.out.println("p1.equals(p2) (разные id): " + p1.equals(p2)); // ожидается false

        // --- Тестирование Order ---
        System.out.println("\n=== Заказы ===");
        Product[] basket1 = {p1, p2};
        Product[] basket2 = {p1, p2};           // та же последовательность
        Product[] basket3 = {p2, p1};           // другая последовательность
        Product[] basket4 = {p1, p3};           // p1 и p3 равны по equals, но это разные объекты

        Order o1 = new Order("Анна", basket1);
        Order o2 = new Order("Анна", basket2);
        Order o3 = new Order("Анна", basket3);
        Order o4 = new Order("Борис", basket1); // другой клиент
        Order o5 = new Order("Анна", basket4);
//
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

        System.out.println("\no1.equals(o2) (одинаковые товары в том же порядке): " + o1.equals(o2)); // true
        System.out.println("o1.equals(o3) (те же товары, но в другом порядке): " + o1.equals(o3)); // false (порядок важен)
        System.out.println("o1.equals(o4) (другой клиент): " + o1.equals(o4)); // false
        System.out.println("o1.equals(o5) (p1 и p3 равны по equals, но корзина считается по equals элементов): " + o1.equals(o5)); // true, т.к. p1.equals(p3)==true
    }
}