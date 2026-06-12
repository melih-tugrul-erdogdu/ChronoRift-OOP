package Exceptions;

/**
 * Oyuncu konsola geçersiz bir seçim girdiğinde fırlatılan hata
 */

public class FalseInputException extends RuntimeException {

    /**
     * Hata mesajı ile birlikte exception nesnesi oluşturur
     * @param message Fırlatılacak hata mesajı
     */

    public FalseInputException(String message) {
        super(message);
    }
}