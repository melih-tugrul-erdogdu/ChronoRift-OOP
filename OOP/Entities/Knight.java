package Entities;

/**
 * Oyuncunun karşısına çıkan düşman türlerinden biridir
 */
public class Knight extends Enemy {

    /**
     * Düşman nesnesini kendine özel can, güç ve zırh değerleriyle yaratır
     */
    public Knight() {
        super("Kara Şövalye", 100, 23, 5, "Orta Çağ");
    }

    /**
     * Düşmanın oyuncuya saldırmasını ve kendine has saldırı mesajını yazdırmasını sağlar
     * @param target Saldırılacak hedef (Yani oyuncu)
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " ağır kılıcını savuruyor!");
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
        return new PreciousItem("Şövalye Madalyonu (Satılabilir)", 40);
    }

    /**
     * Düşmanın temel bilgilerini metin olarak döndürür
     * @return Düşman bilgileri
     */
    @Override
    public String toString() {
        return "Düşman Sınıfı: Şövalye | Çağ: " + this.originEra + " | Güç: " + this.power;
    }
}
