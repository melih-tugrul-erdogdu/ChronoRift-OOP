package Exceptions;

/**
 * Hikaye metinlerini barındıran dosya bulunamadığında/okunamadığında fırlatılan checked hata
 */

public class StoryLoadException extends Exception {

    /**
     * Hata mesajı ile birlikte exception nesnesi oluşturur
     * @param message Fırlatılacak hata mesajı
     */

    public StoryLoadException(String message) {
        super(message);
    }
}