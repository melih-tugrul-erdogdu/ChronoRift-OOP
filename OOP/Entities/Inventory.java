package Entities;
import Exceptions.InventoryException;
import java.util.ArrayList;

/**
 * Oyuncunun topladığı eşyaları içeren ve yöneten sınıf
 */
public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    /**
     * Bir kapasiteye sahip yeni bir envanter oluşturur
     * @param capacity Envanterin kapasitesi
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    /**
     * Envantere eşya ekler. Kapasite doluysa InventoryException hatası fırlatır
     * @param item Eklenecek eşya
     */
    public void addItem(Item item) {
        if (isFull()) {
            throw new InventoryException("Envanter dolu! " + item.getName() + " eklenemedi.");
        }
        items.add(item);
    }

    /**
     * Envanterden eşya siler
     * @param item Silinecek eşya
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /** @return Envanter doluysa true, değilse false */
    public boolean isFull() {
        return items.size() >= capacity;
    }

    /** @return Envanter boşsa true, değilse false */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /** @return Envanterin kapasitesi */
    public int getCapacity() {
        return capacity;
    }

    /** @return Envanterdeki eşya listesi */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Envanterdeki eşyaları konsola yazdırır
     */
    public void showItems() {
        if (isEmpty()) {
            System.out.println("Envanter boş.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
    }

    /**
     * Envanterdeki bir eşyayı seçilen hedefin üzerinde kullanır ve eşyayı tüketir (health potion çeşitleri ve bribe eşyası buna uygun sadece)
     * @param index Kullanılacak eşyanın listedeki sırası
     * @param target Eşyanın kullanılacağı hedef karakter
     */
    public void useItem(int index, Character target) {
        Item item = items.get(index);

        if (item instanceof Interfaces.Usable) {
            ((Interfaces.Usable) item).use(target);
            items.remove(index);
        }
        else {
            System.out.println("Bu eşya kullanılamaz!");
        }
    }
}
