package Core;
import Entities.*;
import Exceptions.FalseInputException;
import Interfaces.Tradable;
import java.util.Scanner;
import Exceptions.StoryLoadException;

/**
 * Oyun döngüsünü savaş mekaniklerini ve geçişleri yöneten merkez sınıftır
 */
public class GameEngine {

    private Player player;
    private Shop shop;
    private Enemy currentEnemy;
    private boolean isRunning;
    private ChapterManager chapterManager;


    /**
     * Oyun motorunu başlatıp oyuncuyu dükkanı ve bölüm yöneticisini oluşturur
     */
    public GameEngine() {

        player = new Player("Zaman Gezgini");
        shop = new Shop();
        // Dükkan ürünleri:
        shop.addItemToShop(new HealthPotion("Büyük İksir", 80, 30));
        shop.addItemToShop(new Bribe("Rüşvet Çantası", 90));
        chapterManager = new ChapterManager();
        isRunning = true;
    }


    /**
     * Oyunu başlatan ve stories.txt dosyamızı okutan metottur
     */
    public void startGame() {
        System.out.println("CHRONORIFT PROTOKOLÜ BAŞLATILIYOR...\n");
        System.out.println("=========================================================================");
        System.out.println("YIL 2042... Zaman yolculuğu icat edildi, ancak sonuçları felaket oldu.");
        System.out.println("Tarihin farklı noktalarında 'Zaman Yarıkları' (ChronoRifts) açılıyor.");
        System.out.println("Eğer bu anomaliler kapatılmazsa, evrenin dokusu tamamen parçalanacak.");
        System.out.println("Sen, bu yarıkları onarmakla görevli bir zaman gezginisin.");
        System.out.println("Görev: Hedef çağlara git, anomalileri yok et ve zamanı kurtar!");
        System.out.println("=========================================================================\n");
        try {
            chapterManager.loadStoriesFromFile("C:\\Users\\mlhtu\\OneDrive\\Masaüstü\\ArdaBayrak_MelihTugrulErdogdu\\OOP\\stories.txt");
        } catch (StoryLoadException e) {
            System.out.println("HATA: Hikaye dosyası bulunamadı veya okunamadı!");
            System.out.println("Oyun başlatılamıyor lütfen stories.txt dosyasını kontrol edin.");
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        while (isRunning && chapterManager.hasMoreChapters()) {

            currentEnemy = chapterManager.getNextEnemy();
            chapterManager.printChapterIntro();

            System.out.println("\n[SİSTEM UYARISI] YENİ ANOMALİ: " + currentEnemy.getName());
            boolean won = battle(currentEnemy);

            if (!won) {
                System.out.println("Zaman çizgisinde kayboldun... OYUN BİTTİ!");
                isRunning = false;
                break;

            } else {
                System.out.println("\n--- ANOMALİ TEMİZLENDİ! ");
                player.setGold(player.getGold() + currentEnemy.dropGold());
                System.out.println("Kazanılan Altın: +" + currentEnemy.dropGold());

                try {
                    Item droppedItem = currentEnemy.drop();
                    player.getInventory().addItem(droppedItem);
                    System.out.println("Ganimet Çantaya Eklendi: " + droppedItem.getName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("[SİSTEM]: Zaman gezgini tecrübe kazandı!");
                player.upgradeStats(20, 5);

                // TİCARET VE DÜKKAN
                boolean inShopPhase = true;
                while (inShopPhase) {
                    System.out.println("\n[Zaman Tüneli Dinlenme Noktası]");
                    System.out.println("Mevcut Altınınız: " + player.getGold());
                    System.out.println("1- Eşya Satın Al");
                    System.out.println("2- Envanterdeki Ganimetleri Sat (Altın Kazan)");
                    System.out.println("3- Sonraki Bölüme Devam Et");
                    System.out.print("Seçiminiz: ");

                    String shopMenuChoice = scanner.nextLine();
                    if (shopMenuChoice.equals("1")) {
                        shop.displayMenu();
                        System.out.print("Satın almak istediğiniz eşyanın numarası (Geri dönmek için 0): ");
                        try {
                            int shopChoice = Integer.parseInt(scanner.nextLine());
                            if (shopChoice > 0 && shopChoice <= shop.getItemForSale().size()) {
                                Item boughtItem = shop.getItemForSale().get(shopChoice - 1);
                                if (boughtItem instanceof Tradable) {
                                    int itemPrice = ((Tradable) boughtItem).getPrice();
                                    player.buyItem(boughtItem, itemPrice);
                                    System.out.println(boughtItem.getName() + " başarıyla satın alındı!");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("[HATA]: Satın alma işlemi başarısız: " + e.getMessage());
                        }
                    } else if (shopMenuChoice.equals("2")) {
                        System.out.println("\n--- ENVANTERİNİZDEKİ SATILABİLİR EŞYALAR ---");
                        player.getInventory().showItems();
                        if (player.getInventory().getItems().isEmpty()) {
                            System.out.println("Satılabilecek hiçbir eşya yok.");
                        } else {
                            System.out.print("Satmak istediğiniz eşyanın numarası (Geri dönmek için 0): ");
                            try {
                                int sellChoice = Integer.parseInt(scanner.nextLine()) - 1;
                                if (sellChoice >= 0 && sellChoice < player.getInventory().getItems().size()) {
                                    Item itemToSell = player.getInventory().getItems().get(sellChoice);
                                    shop.sellToShop(itemToSell, player);
                                }
                            } catch (Exception e) {
                                System.out.println("[HATA]: Geçersiz seçim!");
                            }
                        }
                    } else if (shopMenuChoice.equals("3")) {
                        inShopPhase = false;
                    } else {
                        System.out.println("Geçersiz menü tercihi!");
                    }
                }
                chapterManager.nextChapter();
            }
        }
        if (isRunning) {
            System.out.println("\n=================================================");
            System.out.println("BÜYÜK ZAFER: ZAMAN ÇİZGİSİ KURTARILDI!");
            System.out.println("Uzaylı İstilacının yok edilmesiyle tüm zaman yarıkları kapandı.");
            System.out.println("=================================================");
        }
    }


    /**
     * Oyuncu ve o anki düşman arasındaki sıra tabanlı savaş döngüsünü yürütür
     * @param enemy Oyuncunun karşısındaki düşman
     * @return Oyuncu savaşı kazanırsa true kaybederse false döndürür
     */
    public boolean battle(Enemy enemy) {

        Scanner scanner = new Scanner(System.in);

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\nCanınız: " + player.getHealth() + " / " + player.getMaxHealth() + " | Düşman Canı: " + enemy.getHealth());
            System.out.println("1- Saldır\n2- Envanteri Aç ve Eşya Kullan");
            System.out.print("Seçiminiz: ");

            try {
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    player.attack(enemy);
                    if (enemy instanceof Alien && enemy.getHealth() == 1) {
                        System.out.println("\n=========================================================================");
                        System.out.println("Uzaylı dizlerinin üzerine çöküyor, elindeki plazma silahı düşüyor.");
                        System.out.println("Zaman yarıklarını açan o boyut cihazı göğsünde savunmasızca parlıyor...");
                        System.out.println("Zaman Gezgini son bir darbeyle cihazı paramparça ediyor ve uzaylıyı hiçliğe yolluyor!");
                        System.out.println("=========================================================================\n");
                        enemy.takeDamage(1);
                    }
                } else if (choice.equals("2")) {

                    player.getInventory().showItems();

                    if (!player.getInventory().isEmpty()) {
                        System.out.print("Kullanmak istediğiniz eşyanın numarası (İptal için 0): ");
                        int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;

                        if (itemIndex == -1) {
                            System.out.println("Envanter kapatıldı.");
                            continue;
                        }

                        if (itemIndex >= 0 && itemIndex < player.getInventory().getItems().size()) {
                            Item selectedItem = player.getInventory().getItems().get(itemIndex);

                            if (selectedItem instanceof HealthPotion) {
                                player.getInventory().useItem(itemIndex, player);
                            } else if (selectedItem instanceof Bribe) {
                                if (enemy instanceof ModernSoldier) {
                                    player.getInventory().useItem(itemIndex, enemy);
                                } else {
                                    System.out.println("Bu eşya sadece Modern Askerler üzerinde işe yarar!");
                                    continue;
                                }
                            } else {
                                System.out.println("Bu eşya savaşta kullanılamaz!");
                                continue;
                            }
                        } else {
                            System.out.println("Geçersiz bir eşya numarası girdiniz.");
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    throw new FalseInputException("Hatalı tuşlama yaptınız! Lütfen 1 veya 2'ye basın.");
                }

                if (enemy.isAlive()) {
                    enemy.attack(player);
                }

            } catch (FalseInputException e) {
                System.out.println("[SİSTEM UYARISI]: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("[SİSTEM UYARISI]: Lütfen sadece rakam giriniz!");
            } catch (Exception e) {
                System.out.println("[BEKLENMEYEN HATA]: " + e.getMessage());
            }
        }

        return player.isAlive();
    }
}