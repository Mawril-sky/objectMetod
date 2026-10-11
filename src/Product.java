import java.util.Objects;
import java.util.Arrays;

// Класс товара
class Product {
    private int id;          // артикул
    private String name;     // название
    private int price;       // цена
    private String category; // категория

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттеры (если понадобятся в будущем)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Товар[артикул=" + id + ", название=" + name + ", цена=" + price + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;

        // id — примитив, сравниваем напрямую
        if (this.id != other.id) return false;

        // category — строка, сравниваем через Objects.equals для безопасности с null
        if (!Objects.equals(this.category, other.category)) return false;

        return true;
    }
    //
    @Override
    public int hashCode() {
        // hashCode должен быть согласован с equals: используем те же поля
        return Objects.hash(id, category);
    }
}
