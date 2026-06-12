package Interfaces;
import Entities.Item;

/**
 * Düşmanlar öldüğünde yere eşya düşürmelerini sağlayan interface
 */

public interface Lootable {

    /**
     * Düşmandan düşen ganimeti üretir
     * @return Düşen Item nesnesi
     */

    Item drop();
}
