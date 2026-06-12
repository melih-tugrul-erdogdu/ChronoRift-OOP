package Entities;

/**
 * Oyundaki tüm eşyaların türediği soyut sınıftır
 */

public abstract class Item {
    protected String name;

    /**
     * Eşya oluşturur
     * @param name Eşyanın adı
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * @return Eşyanın adı
     */
    public String getName() { return name; }

    /**
     * Eşyaların isimlerine göre birbirlerine eşit olup olmadığını kontrol eder
     * @param obj Karşılaştırılacak diğer nesne
     * @return Nesneler aynıysa true, değilse false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return name != null && name.equals(item.name);
    }
}


    
    

