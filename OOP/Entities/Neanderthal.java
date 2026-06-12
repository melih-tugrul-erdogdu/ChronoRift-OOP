package Entities;

/**
 * Oyuncunun karşısına çıkan düşman türlerinden biridir
 */
public class Neanderthal extends Enemy {

    /**
     * Düşman nesnesini kendine özel can, güç ve zırh değerleriyle yaratır
     */
    public Neanderthal() {
        super("Öfkeli Neandertal", 60, 15, 0, "Tarih Öncesi Çağ");
    }

    /**
     * Düşmanın oyuncuya saldırmasını ve kendine has saldırı mesajını yazdırmasını sağlar
     * @param target Saldırılacak hedef (Yani oyuncu)
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " taş sopasıyla kükreyerek saldırıyor!");
        target.takeDamage(this.getPower());
    }

    /**
     * @return Düşman vefat ettiğinde (Merhum olduğunda) kazanılacak altın miktarı
     */
    @Override
    public int dropGold() {
        return 15;
    }

    /**
     * Düşman vefat ettiğinde (Merhum olduğunda) yere düşecek ganimet içindir
     * @return Düşen Item nesnesi
     */
    @Override
    public Item drop() {
        return new HealthPotion("Tarih Öncesi Meyve", 50, 30);
    }

    /**
     * Düşmanın temel bilgilerini metin olarak döndürür
     * @return Düşman bilgileri
     */
    @Override
    public String toString() {
        return "Düşman Sınıfı: Neanderthal | Çağ: " + this.originEra + " | Güç: " + this.power;
    }
}
