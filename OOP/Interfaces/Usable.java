package Interfaces;

/**
 * Oyun içinde karakterler üzerinde kullanılabilen eşyaların (iksir, rüşvet vb.) uygulaması gereken interface
 */

public interface Usable {

    /**
     * Eşyanın hedef karakter üzerinde kullanılmasını sağlar
     * @param target Eşyanın üzerinde kullanılacağı hedef karakter nesnesi
     */

    void use(Entities.Character target);
}