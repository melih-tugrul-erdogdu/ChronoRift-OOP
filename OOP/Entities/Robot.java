package Entities;

/**
 * Oyuncunun karşısına çıkan düşman türlerinden biridir
 */
public class Robot extends Enemy {

    /**
     * Düşman nesnesini kendine özel can, güç ve zırh değerleriyle yaratır
     */
    public Robot() {
        super("Savaş Robotu", 120, 25, 10, "Gelecek Çağ");
    }

    /**
     * Düşmanın oyuncuya saldırmasını ve kendine has saldırı mesajını yazdırmasını sağlar
     * @param target Saldırılacak hedef (Yani oyuncu)
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " metal yumruğuyla vuruyor!");
        target.takeDamage(this.getPower());
    }

    /**
     * @return Düşman vefat ettiğinde (Merhum olduğunda) kazanılacak altın miktarı
     */
    @Override
    public int dropGold() {
        return 60;
    }

    /**
     * Düşman vefat ettiğinde (Merhum olduğunda) yere düşecek ganimet içindir
     * @return Düşen Item nesnesi
     */
    @Override
    public Item drop() {
        return new HealthPotion("İçilebilir Motor Yağı", 50, 25);
    }

    /**
     * Düşmanın temel bilgilerini metin olarak döndürür
     * @return Düşman bilgileri
     */
    @Override
    public String toString() {
        return "Düşman Sınıfı: Robot | Çağ: " + this.originEra + " | Güç: " + this.power;
    }
}
