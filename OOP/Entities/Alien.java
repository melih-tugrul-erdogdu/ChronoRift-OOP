package Entities;

/**
 * Oyuncunun karşısına çıkan düşman türlerinden biridir
 */
public class Alien extends Enemy {

    /**
     * Düşman nesnesini kendine özel can, güç ve zırh değerleriyle yaratır
     */
    public Alien() {
        super("Uzaylı İstilacı", 201, 45, 0, "Gelecek Çağ");
    }

    /**
     * Düşmanın oyuncuya saldırmasını ve kendine has saldırı mesajını yazdırmasını sağlar
     * @param target Saldırılacak hedef (Yani oyuncu)
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " plazma silahıyla ateş ediyor!");
        target.takeDamage(this.getPower());
    }

    /**
     * @return Düşman vefat ettiğinde (Merhum olduğunda) kazanılacak altın miktarı
     */
    @Override
    public int dropGold() {
        return 10;
    }

    /**
     * Düşman vefat ettiğinde (Merhum olduğunda) yere düşecek ganimet içindir
     * @return Düşen Item nesnesi
     */
    @Override
    public Item drop() {
        return new PreciousItem("Uzaylı Kristali", 1500);
    }

    /**
     * Düşmanın temel bilgilerini metin olarak döndürür
     * @return Düşman bilgileri
     */
    @Override
    public String toString() {
        return "Düşman Sınıfı: Uzaylı İstilacı | Çağ: " + this.originEra + " | Güç: " + this.power;
    }
}
