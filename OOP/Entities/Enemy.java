package Entities;
import Interfaces.Lootable;

/**
 * Oyundaki tüm düşmanların türediği ve ganimet düşürmelerine müsaade eden soyut sınıftır
 */
public abstract class Enemy extends Character implements Lootable {

    protected String originEra;

    /**
     * Yeni bir Enemy nesnesi oluşturur
     * @param name Düşmanın adı
     * @param maxHealth Maksimum canı
     * @param power Saldırı gücü
     * @param armor Zırh değeri
     * @param originEra Düşmanın geldiği zaman dilimi
     */
    public Enemy(String name, int maxHealth, int power, int armor, String originEra) {
        super(name, maxHealth, power, armor);
        this.originEra = originEra;
    }

    /** @return Düşmanın ait olduğu zaman dilimi */
    public String getOriginEra() {
        return originEra;
    }

    /**
     * Düşman öldüğünde oyuncuya altın verdirten metot
     * @return Kazanılacak altın miktarı
     */
    public abstract int dropGold();

    /**
     * Düşmandan düşen ganimeti üretir
     * @return Düşen Item nesnesi
     */
    @Override
    public abstract Item drop();
}
