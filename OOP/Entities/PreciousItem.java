package Entities;
import Interfaces.Tradable;

/**
 * Savaşta kullanılamayan, sadece dükkandayken satılarak altın elde edilen değerli eşyalar (Oyunda 2 adet var)
 */
public class PreciousItem extends Item implements Tradable {
    private int goldValue;

    /**
     * Değerli bir eşya oluşturur
     * @param name Eşyanın adı
     * @param goldValue Eşya satıldığında vereceği altın miktarı
     */
    public PreciousItem(String name, int goldValue) {
        super(name);
        this.goldValue = goldValue;
    }

    /**
     * @return Dükkana satış fiyatı
     */
    @Override
    public int getPrice() {
        return this.goldValue;
    }

    /**
     * @return Değerli eşyanın bilgileri
     */
    @Override
    public String toString() {
        return "Değerli Eşya: " + this.name + " (Değeri: " + this.goldValue + " Altın)";
    }
}
