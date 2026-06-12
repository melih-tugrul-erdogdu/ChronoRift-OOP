package Entities;
import Interfaces.Usable;
import Interfaces.Tradable;

/**
 * Oyuncunun canını arttıran (kalıcı değil) iksir eşyası
 * Usable ve Tradable interface'lerini uygular
 */

public class HealthPotion extends Item implements Usable, Tradable {

    private int healAmount;
    private int price;

    /**
     * Belirtilen özelliklerde yeni bir can iksiri oluşturur
     * @param name İksirin adı
     * @param healAmount Yenileyeceği can miktarı
     * @param price Dükkandaki altın değeri
     */
    public HealthPotion(String name, int healAmount, int price) {
        super(name);
        this.healAmount = healAmount;
        this.price = price;
    }

    /**
     * İksiri hedef üzerinde kullanır ve canını artırır
     * @param target İksirin kullanılacağı hedef
     */
    @Override
    public void use(Character target) {
        target.heal(this.healAmount);
        System.out.println(target.getName() + " can yeniledi: +" + healAmount);
    }

    /**
     * @return Altın cinsinden satış değer
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * @return İksir bilgileri
     */
    @Override
    public String toString() {
        return "İksir: " + this.name + " (Yenileme: " + this.healAmount + " HP, Fiyat: " + this.price + " Altın)";
    }
}
