package Core;

/**
 * Oyundaki her bir bölümün hikaye metnini ve numarasını tutan sınıf
 */

public class Story {

    private int chapterNumber;
    private String narrativeText;

    /**
     * Yeni bir Story nesnesi oluşturur
     * @param chapterNumber Bölümün numarası
     * @param narrativeText Bölüme ait hikaye metni
     */
    public Story(int chapterNumber, String narrativeText) {
        this.chapterNumber = chapterNumber;
        this.narrativeText = narrativeText;
    }

    /**
     * @return Hikayenin ait olduğu bölüm numarası
     */
    public int getChapterNumber() {
        return chapterNumber;
    }

    /**
     * @return Hikayenin metin içeriği
     */
    public String getNarrativeText() {
        return narrativeText;
    }
}
