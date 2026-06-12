package Core;
import Entities.Item;
import Entities.Player;
import Interfaces.Tradable;
import java.util.ArrayList;

/**
 * Oyun içindeki dükkanı ve al sat işlemlerini yöneten sınıftır
 */

public class Shop {
    private ArrayList<Item> itemForSale;

    /**
     * Dükkan nesnesini oluşturur ve satılık eşya listesini başlatır.
     */
    public Shop() {
        itemForSale = new ArrayList<>();
    }

    /**
     * Dükkanın satılık eşyalar listesine yeni bir eşya ekler
     * @param item Eklenecek eşya
     */
    public void addItemToShop(Item item) {
        this.itemForSale.add(item);
    }

    /**
     * @return Dükkandaki satılık eşyaların listesi
     */
    public ArrayList<Item> getItemForSale() {
        return this.itemForSale;
    }

    /**
     * Dükkan menüsünü ve eşya fiyatlarını konsola yazdırır
     */
    public void displayMenu() {
        System.out.println("\n-_-_- DÜKKAN: SATIN ALINABİLİR EŞYALAR -_-_-");
        if (itemForSale.isEmpty()) {
            System.out.println("Satılık eşya kalmadı.");
            return;
        }
        for (int i = 0; i < itemForSale.size(); i++) {
            Item item = itemForSale.get(i);
            int price = 0;
            if (item instanceof Tradable) {
                price = ((Tradable) item).getPrice();
            }
            System.out.println((i + 1) + ". " + item.getName() + " (" + price + " Altın)");
        }
    }


    /**
     * Oyuncunun envanterindeki bir eşyayı dükkana satmasını sağlar
     * @param item Satılacak eşya
     * @param seller Eşyayı satan oyuncu
     */
    public void sellToShop(Item item, Player seller) {
        if (item instanceof Tradable) {
            Tradable tradableItem = (Tradable) item;
            int price = tradableItem.getPrice();

            seller.setGold(seller.getGold() + price);
            seller.getInventory().removeItem(item);
            System.out.println("[BAŞARILI]: " + item.getName() + " dükkana satıldı! Kazanılan Altın: +" + price);
        } else {
            System.out.println("[SİSTEM UYARISI]: Bu eşya ticarete uygun değil, satılamaz!");
        }
    }
}