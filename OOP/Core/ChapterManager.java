package Core;

import Entities.Enemy;
import Entities.Knight;
import Entities.ModernSoldier;
import Entities.Neanderthal;
import Entities.Robot;
import Entities.Alien;
import Exceptions.StoryLoadException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ChapterManager oyunumuzun bölüm akışını, düşman sırasını ve hikaye metinlerini yönetiyor
 * Dosya okuma işlemleri bu sınıf üzerinden gerçekleştiriliyor
 */
public class ChapterManager {
    private ArrayList<Enemy> chapterEnemies;
    private ArrayList<Story> chapterStories;
    private int currentChapter;

    /**
     * ChapterManager yapıcı metodu
     * Düşmanları sırasına göre listeye ekliyoruz
     */
    public ChapterManager() {
        chapterEnemies = new ArrayList<>();
        chapterStories = new ArrayList<>();
        currentChapter = 0;

        chapterEnemies.add(new Neanderthal());
        chapterEnemies.add(new Knight());
        chapterEnemies.add(new ModernSoldier());
        chapterEnemies.add(new Robot());
        chapterEnemies.add(new Alien());
    }

    /**
     * Belirtilen dosyadan hikaye metinlerini okur ve Story nesnelerine dönüştürür
     * @param fileName Okunacak metin dosyasının adı ve yolu
     * @throws StoryLoadException Dosya bulunamadığında veya okuma hatasında fırlatılır
     */
    public void loadStoriesFromFile(String fileName) throws StoryLoadException {
        File file = new File(fileName);
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(";");

                if (parts.length == 2) {
                    int chapterNum = Integer.parseInt(parts[0].trim());
                    String text = parts[1].trim();
                    chapterStories.add(new Story(chapterNum, text));
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new StoryLoadException("Kritik Hata: " + fileName + " dosyası bulunamadı! Lütfen dosya yolunu kontrol edin.");
        }
    }

    /**
     * @return Sırada bekleyen düşman
     */
    public Enemy getNextEnemy() {
        if (currentChapter < chapterEnemies.size()) {
            return chapterEnemies.get(currentChapter);
        }
        return null;
    }

    /**
     * Mevcut bölümün hikaye girişini yazdırır
     */
    public void printChapterIntro() {
        if (currentChapter < chapterStories.size()) {
            System.out.println("\n--- BÖLÜM " + chapterStories.get(currentChapter).getChapterNumber() + " ---");
            System.out.println(chapterStories.get(currentChapter).getNarrativeText());
        }
    }

    /**
     * Bir sonraki bölüme geçişi sağlar
     */
    public void nextChapter() {
        currentChapter++;
    }

    /**
     * @return Eğer oynanacak başka bölüm varsa true, oyun bittiyse false döndürür
     */
    public boolean hasMoreChapters() {
        return currentChapter < chapterEnemies.size();
    }
}