package Exceptions;

/**
 * Envanter kapasitesi aşıldığında fırlatılan Runtime hatası
 */

public class InventoryException extends RuntimeException {

    /**
     * Hata mesajı ile birlikte exception nesnesi oluşturur
     * @param message Fırlatılacak hata mesajı
     */

    public InventoryException(String message) {
        super(message);
    }
}