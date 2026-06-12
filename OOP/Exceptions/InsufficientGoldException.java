package Exceptions;

/**
 * Oyuncunun dükkandaki bir eşyayı almaya altını yetmediğinde fırlatılan hata
 */

public class InsufficientGoldException extends RuntimeException {

    /**
     * Hata mesajı ile birlikte exception nesnesi oluşturur
     * @param message Fırlatılacak hata mesajı
     */

    public InsufficientGoldException(String message) {
        super(message);
    }
}