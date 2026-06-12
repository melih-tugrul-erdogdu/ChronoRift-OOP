package Entities;
import Interfaces.Usable;
import Interfaces.Tradable;

/**
 * Sadece modern asker düşmanı üzerinde işe yarayan rüşvet eşyası
 * Tradable ve Usable interface'lerini implement eder
 */
public class Bribe extends Item implements Usable, Tradable {

    private int bribePrice;

    /**
     * Yeni bir rüşvet çantası oluşturur
     * @param name Eşyanın adı
     * @param bribePrice Dükkandaki fiyatı
     */
    public Bribe(String name, int bribePrice) {
        super(name);
        this.bribePrice = bribePrice;
    }

    /**
     * @return fiyat
     */
    @Override
    public int getPrice() {
        return this.bribePrice;
    }

    /**
     * Rüşveti hedef düşman üzerinde kullanır
     * Hedef Modern Asker ise savaşı sonlandırır (Diğer düşmanlar üzerinde kullanılırsa hata fırlatır)
     * @param target Üzerinde rüşvet denenecek karakter
     */
    @Override
    public void use(Character target) {
        if (target instanceof ModernSoldier) {
            System.out.println("Rüşvet kabul edildi! " + target.getName() + " savaşı terk ediyor.");
            target.takeDamage(999); // Savaşı anında bitirmek için canı sıfırlıyoruz
        }
        else {
            System.out.println("Bu eşya sadece Modern Askerler üzerinde işe yarar!");
        }
    }

    /**
     * @return Rüşvet çantasının bilgileri
     */
    @Override
    public String toString() {
        return "Özel Eşya: " + this.name + " (Değeri: " + this.bribePrice + " Altın)";
    }
}
