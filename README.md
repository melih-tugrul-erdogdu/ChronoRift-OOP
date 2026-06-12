###ChronoRift ⏳
ChronoRift is a console-based, turn-based RPG where the player acts as a Time Traveler tasked with fixing historical anomalies. Developed as an Object-Oriented Programming (OOP) term project at Galatasaray University, this game diverges from standard RNG-heavy combat by focusing heavily on economy, resource management, and strategic item usage.

Players progress linearly through 5 distinct eras (encounters), looting enemies, managing gold, and utilizing a "Time Tunnel" shop to survive increasingly difficult bosses.

#🌐 Language & Documentation
Localization: The entire game interface, including story narratives, combat logs, and console menus, is fully localized in Turkish.

Code Documentation: In compliance with professional standards, all classes and public methods are fully documented using detailed Turkish Javadoc comment blocks.

#🛠️ Core OOP Architecture
This project was built to practically apply and demonstrate advanced Java OOP concepts:

Deep Inheritance Hierarchy: Base Character and Item abstract classes branching into specific concrete entities (e.g., Character -> Enemy -> ModernSoldier).

Interfaces: Extensive use of Usable, Tradable, and Lootable contracts to handle mixed entity behaviors.

Polymorphism & Collections: ArrayList<Item> and ArrayList<Enemy> are used to manage inventories, shops, and chapter encounters without hardcoding types.

Type Checking & Downcasting: Strategic use of instanceof (e.g., the Chapter 3 "Bribe" trap) and explicit downcasting for shop transactions.

#🐛 Exception Handling & Stability
The game loop is heavily fortified against crashes using custom exceptions:

FalseInputException: Prevents the infamous Scanner infinite loop bugs during combat menus by clearing the buffer and safely re-prompting the user.

InventoryException: Manages capacity constraints within the player's inventory, throwing errors if an item addition is attempted while the inventory is full.

InsufficientGoldException: A game-state validation that prevents negative balances during shop interactions.

StoryLoadException: A checked exception wrapping file I/O operations (try-with-resources). If stories.txt is missing, the game safely aborts before initialization rather than crashing mid-session.

#🎮 Game Design Highlights
The "Action Tax" Balance: To make healing viable in a turn-based system, Health Potions were significantly buffed to out-scale average enemy damage, making the Shop phase critical.

The Bribe Trap: The Chapter 3 boss is mathematically impossible to defeat by force. Players are forced to manage their economy, sell previous loot, and buy a specific Bribe item to bypass the encounter.

###ChronoRift ⏳ (Türkçe)
ChronoRift, oyuncunun tarihi anomalileri onarmakla görevli bir Zaman Gezgini'ni canlandırdığı konsol tabanlı, sıra tabanlı bir RPG oyunudur. Galatasaray Üniversitesi'nde Nesne Yönelimli Programlama (OOP) dönem projesi olarak geliştirilen bu oyun, sadece rastgele savaş istatistiklerine dayanmak yerine ekonomi, kaynak yönetimi ve stratejik eşya kullanımına odaklanmaktadır.

Oyuncular 5 farklı çağda (bölümde) doğrusal olarak ilerler, düşmanlardan ganimet toplar, altınlarını yönetir ve giderek zorlaşan bölüm sonu canavarlarında hayatta kalabilmek için "Zaman Tüneli" mağazasını kullanırlar.

#🌐 Dil ve Dokümantasyon
Yerelleştirme: Hikaye metinleri, savaş logları ve konsol menüleri dahil olmak üzere oyunun tüm kullanıcı arayüzü tamamen Türkçe olarak tasarlanmıştır.

Kod Dokümantasyonu: Akademik ve profesyonel standartlara uygun olarak, projedeki tüm sınıflar ve genel (public) metotlar kapsamlı Türkçe Javadoc yorum satırları ile belgelenmiştir.

#🛠️ Temel OOP Mimarisi
Bu proje, ileri düzey Java OOP kavramlarını pratik bir şekilde uygulamak ve sergilemek için inşa edilmiştir:

Derin Kalıtım Hiyerarşisi: Temel Character ve Item soyut (abstract) sınıfları, alt somut varlıklara dallanır (Örn: Character -> Enemy -> ModernSoldier).

Arayüzler (Interfaces): Farklı nesne davranışlarını yönetmek için Usable, Tradable ve Lootable arayüzleri aktif olarak kullanılmıştır.

Polimorfizm ve Koleksiyonlar: Envanterleri, mağazaları ve bölüm düşmanlarını tipleri sabit kodlamadan (hardcode) yönetmek için ArrayList<Item> ve ArrayList<Enemy> kullanılmıştır.

Tip Kontrolü ve Downcasting: Rüşvet (Bribe) eşyası mekaniğinde instanceof kontrolü ve mağaza işlemlerinde bilinçli downcasting (alt tipe dönüştürme) uygulanmıştır.

#🐛 Hata Yönetimi (Exception Handling) ve Kararlılık
Oyun döngüsü, çökmelere karşı özel hata sınıflarıyla (custom exceptions) güçlendirilmiştir:

FalseInputException: Savaş menülerinde yanlış tuşa basıldığında oluşan o meşhur Scanner sonsuz döngü hatalarını (buffer temizleyerek) engeller.

InventoryException: Oyuncunun envanterindeki kapasite sınırlarını yönetir; envanter doluyken yeni bir eşya eklenmeye çalışıldığında hata fırlatarak taşmaları önler.

InsufficientGoldException: Mağaza alışverişlerinde bakiyenin eksiye düşmesini engelleyen bir oyun-durumu kontrolüdür.

StoryLoadException: Dosya okuma işlemlerini (try-with-resources ile) sarmalayan kontrollü (checked) bir hatadır. stories.txt dosyası eksikse, oyun ortasında çökmek yerine sistem güvenli bir şekilde başlatmayı iptal eder.

🎮 Tasarım Detayları
"Hamle Vergisi" (Action Tax) Dengesi: Sıra tabanlı bir sistemde iksir içmenin sırayı düşmana geçirmesi dezavantajını kırmak için, Sağlık İksirleri düşman hasarını aşacak şekilde güçlendirildi. Bu da Mağaza aşamasını oyunun hayatta kalma kilidi haline getirdi.

Rüşvet Tuzağı: 3. Bölümdeki düşmanı kaba kuvvetle yenmek matematiksel olarak imkansızdır. Oyuncular ekonomilerini doğru yönetmek, önceki ganimetleri satmak ve bölümü atlamak için özel Bribe eşyasını satın almak zorundadır.
