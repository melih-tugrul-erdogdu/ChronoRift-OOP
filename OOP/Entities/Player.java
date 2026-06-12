package Entities;
import Exceptions.InsufficientGoldException;

import java.util.ArrayList;

/**
 * Oyuncu karakterini temsil eden somut sınıftır
 * Karakterin envanter, altın ve seviye atlama kodlarını barındırıyor
 */
public class Player extends Character {
    private int gold;
    private Inventory inventory;

    /**
     * Player sınıfının yapıcı metodu
     * @param name Oyuncunun ismi
     */
    public Player(String name) {
        super(name, 100, 20, 5);
        this.gold = 50;
        this.inventory = new Inventory(10);
    }

    /**
     * @return Mevcut altın miktarı
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param amount Yeni altın miktarı
     */
    public void setGold(int amount) {
        this.gold = amount;
    }

    /**
     * @return Oyuncunun envanteri
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Oyuncunun maksimum canını ve saldırı gücünü kalıcı olarak artırır
     * @param hpIncrease Eklenecek max can miktarı
     * @param pwrIncrease Eklenecek saldırı gücü miktarı
     */
    public void upgradeStats(int hpIncrease, int pwrIncrease) {
        this.maxHealth += hpIncrease;
        this.health += hpIncrease;
        this.power += pwrIncrease;
        System.out.println("Karakter seviye atladı! Kazanılan HP: +" + hpIncrease + " | Yeni gücün: " + this.power);
    }

    /**
     * Oyuncunun hedefe saldırmasını sağlar
     * @param target Saldırılacak hedef
     */
    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + ", " + target.getName() + "'e saldırıyor!");
        target.takeDamage(this.getPower());
    }

    /**
     * Oyuncunun hasar almasını sağlar ve kritik bir can değerine gelirsek uyarı verir
     * @param damage Alınan ham (armor azaltması olmadan) hasar miktarı
     */
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (this.health <= 20 && this.health > 0) {
            System.out.println("[KRİTİK DURUM]: Zaman Gezgini ağır yaralı, can değeri çok düşük!");
        }
    }

    /**
     * Altın karşılığı dükkandan eşya satın alma bölümü
     * @param item Satın alınacak eşya
     * @param price Eşyanın fiyatı
     * @throws InsufficientGoldException Oyuncunun parası yetersizse fırlatılır
     */
    public void buyItem(Item item, int price) {
        if (this.gold < price) {
            throw new InsufficientGoldException("Yetersiz altın! Gereken: " + price + " | Mevcut: " + this.gold);
        }
        this.inventory.addItem(item);
        this.gold -= price;
    }

    /**
     * Oyuncunun anlık durumunu metin formatında döndürür
     * @return İsim, HP(can), Altın
     */
    @Override
    public String toString() {
        return "Oyuncu: " + this.name + " | HP: " + this.health + "/" + this.maxHealth + " | Altın: " + this.gold;
    }
}