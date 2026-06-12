package Entities;

/**
 * Oyuncunun karşısına çıkan düşman türlerinden biridir
 */
public class ModernSoldier extends Enemy {

    /**
     * Düşman nesnesini kendine özel can, güç ve zırh değerleriyle yaratır
     */
    public ModernSoldier() {
        super("Modern Asker", 200, 60, 15, "Modern Çağ");
    }

    /**
     * Düşmanın oyuncuya saldırmasını ve kendine has saldırı mesajını yazdırmasını sağlar
     * @param target Saldırılacak hedef (Yani oyuncu)
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " tüfekle ateş ediyor!");
        target.takeDamage(this.getPower());
    }

    /**
     * @return Düşman vefat ettiğinde (Merhum olduğunda) kazanılacak altın miktarı
     */
    @Override
    public int dropGold() {
        return 30;
    }

    /**
     * Düşman vefat ettiğinde (Merhum olduğunda) yere düşecek ganimet içindir
     * @return Düşen Item nesnesi
     */
    @Override
    public Item drop() {
        return new HealthPotion("Askerin İksiri", 60, 30);
    }

    /**
     * Düşmanın temel bilgilerini metin olarak döndürür
     * @return Düşman bilgileri
     */
    @Override
    public String toString() {
        return "Düşman Sınıfı: Modern Asker | Çağ: " + this.originEra + " | Güç: " + this.power;
    }
}