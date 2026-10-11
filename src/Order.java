import java.util.Arrays;
import java.util.Objects;

class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        // Важно: делаем копию массива, чтобы внешний код не мог изменить корзину напрямую
        this.basket = (basket != null) ? Arrays.copyOf(basket, basket.length) : null;
    }

    @Override
    public String toString() {
        String basketStr = (basket == null) ? "[]" : Arrays.toString(basket);
        return "Заказ[клиент=" + customer + ", корзина=" + basketStr + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;

        // Сравнение клиента с учетом null
        if (!Objects.equals(this.customer, other.customer)) return false;

        // Если оба массива null — они равны
        if (this.basket == null && other.basket == null) return true;
        // Если один null, а другой нет — не равны
        if (this.basket == null || other.basket == null) return false;

        // Длины должны совпадать
        if (this.basket.length != other.basket.length) return false;

        // Поэлементное сравнение товаров через их equals (а не через ==)
        for (int i = 0; i < this.basket.length; i++) {
            // Проверка на null внутри массива
            if (this.basket[i] == null && other.basket[i] == null) {
                continue;
            }
            if (this.basket[i] == null || other.basket[i] == null) {
                return false;
            }
            // Используем equals из Product
            if (!this.basket[i].equals(other.basket[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customer);
        // Для массива берем hashCode его содержимого (поэлементно)
        result = 31 * result + (basket == null ? 0 : Arrays.deepHashCode(basket));
        return result;
    }
}