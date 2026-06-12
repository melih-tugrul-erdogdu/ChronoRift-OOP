package Entities;

/**
 * Oyundaki oyuncu ve düşmanların ortak özelliklerini barındıran soyut sınıftır
 */
public abstract class Character {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected int power;
    protected int armor;

    /**
     * Yeni bir karakter oluşturur
     * @param name Karakterin ismi
     * @param maxHealth Maksimum can değeri
     * @param power Saldırı gücü
     * @param armor Zırh değeri
     */
    public Character(String name, int maxHealth, int power, int armor) {

        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.power = power;
        this.armor = armor;
    }

    /** @return Karakterin ismi */
    public String getName() {
        return name;
    }

    /** @return Karakterin mevcut canı */
    public int getHealth() {
        return health;
    }

    /** @return Karakterin olabilecek maksimum canı */
    public int getMaxHealth() {
        return maxHealth;
    }

    /** @return Karakterin saldırı gücü */
    public int getPower() {
        return power;
    }

    /** @return Karakterin zırh değeri */
    public int getArmor() {
        return armor;
    }

    protected void setHealth(int amount) {
        this.health = amount;
    }

    /**
     * Zırh hesaplamasını yapıp karaktere hasar verir ve canı düşürür
     * @param damage Alınan ham (armor azaltması olmadan) hasar miktarı
     */
    public void takeDamage(int damage) {
        int actualDamage = damage - this.armor;
        if (actualDamage > 0) {
            this.health -= actualDamage;
        }
        if (this.health < 0) this.health = 0;
    }

    /**
     * Karakterin canını belirtilen miktarda arttırır (Maksimum can sınırını aşamaz)
     * @param amount İyileştirme miktarı
     */
    public void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }

    /**
     * Karakterin hayatta olup olmadığını kontrol eder
     * @return Canı 0'dan büyükse true aksi halde false
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Hedef karaktere saldırı yapılmasını sağlayan ve alt sınıflarda ezilecek olan soyut metot
     * @param target Saldırılacak hedef karakter
     */
    public abstract void attack(Character target);
}