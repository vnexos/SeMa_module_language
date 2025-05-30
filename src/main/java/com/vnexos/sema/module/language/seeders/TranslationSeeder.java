package com.vnexos.sema.module.language.seeders;

import com.vnexos.sema.loader.annotations.AutoWired;
import com.vnexos.sema.loader.annotations.Service;
import com.vnexos.sema.module.language.LanguageModuleMain;
import com.vnexos.sema.module.language.data.Translation;
import com.vnexos.sema.module.language.repository.ITranslationRepository;

@Service
public class TranslationSeeder {
  @AutoWired
  ITranslationRepository translationRepository;

  /*
   * 60000196-4f33-f7af-9c49-08b9a61b608a vi-vn
   * 60000196-4f33-f7e3-af53-8bf3aeeac060 en-us
   * 60000196-4f33-f7f6-86a8-4d39c181a03a en-uk
   * 60000196-4f33-f809-8516-bbb93a1d341a ar-sa
   * 60000196-4f33-f81a-ac04-de7e95eada64 he-il
   * 
   */
  private static Translation[] translations = {
      // SYSTEM_SLOGAN
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_SLOGAN", "Thắp sáng tương lai"),
      new Translation("60000196-4f33-f7d1-b885-a868ec73fe40", "SYSTEM_SLOGAN",
          "Lùng diệt VNCH! Khi nào còn cờ ba sọc thì khi đó không có hòa giải!"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_SLOGAN", "Ignite the Path Ahead"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_SLOGAN", "Illuminate the Way Forward"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_SLOGAN", "ابدأ رحلتك بثقة"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_SLOGAN", "האר את הדרך לעתיד"),
      // SYSTEM_NAVBAR_PROJECTS
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_NAVBAR_PROJECTS", "Dự án"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_NAVBAR_PROJECTS", "Projects"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_NAVBAR_PROJECTS", "Projects"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_NAVBAR_PROJECTS", "المشاريع"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_NAVBAR_PROJECTS", "פרויקטים"),
      // SYSTEM_NAVBAR_SOLUTIONS
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_NAVBAR_SOLUTIONS", "Giải pháp"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_NAVBAR_SOLUTIONS", "Solutions"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_NAVBAR_SOLUTIONS", "Solutions"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_NAVBAR_SOLUTIONS", "الحلول"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_NAVBAR_SOLUTIONS", "פתרונות"),
      // SYSTEM_NAVBAR_ABOUT
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_NAVBAR_ABOUT", "Về chúng tôi"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_NAVBAR_ABOUT", "About"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_NAVBAR_ABOUT", "About"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_NAVBAR_ABOUT", "من نحن"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_NAVBAR_ABOUT", "אודות"),
      // SYSTEM_GENDER_
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_GENDER_MALE", "Nam"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_GENDER_MALE", "Male"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_GENDER_MALE", "Male"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_GENDER_MALE", "ذكر"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_GENDER_MALE", "זכר"),
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_GENDER_FEMALE", "Nữ"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_GENDER_FEMALE", "Female"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_GENDER_FEMALE", "Female"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_GENDER_FEMALE", "أنثى"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_GENDER_FEMALE", "נקבה"),
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_GENDER_OTHER", "Khác"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_GENDER_OTHER", "Other"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_GENDER_OTHER", "Other"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_GENDER_OTHER", "آخر"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_GENDER_OTHER", "אחר"),
      new Translation("60000196-4f33-f7af-9c49-08b9a61b608a", "SYSTEM_GENDER_HIDDEN", "Ẩn giới tính"),
      new Translation("60000196-4f33-f7e3-af53-8bf3aeeac060", "SYSTEM_GENDER_HIDDEN", "Hide gender"),
      new Translation("60000196-4f33-f7f6-86a8-4d39c181a03a", "SYSTEM_GENDER_HIDDEN", "Hide gender"),
      new Translation("60000196-4f33-f809-8516-bbb93a1d341a", "SYSTEM_GENDER_HIDDEN", "הסתר מין"),
      new Translation("60000196-4f33-f81a-ac04-de7e95eada64", "SYSTEM_GENDER_HIDDEN", "إخفاء الجنس"),
  };

  public void seed() {
    try {
      int translationCount = translationRepository.count();
      if (translationCount == 0) {
        for (Translation tran : translations) {
          translationRepository.create(tran);
        }
      }
      LanguageModuleMain.context.info("Seeded translations successful!");
    } catch (Exception ex) {
      LanguageModuleMain.context.error("Seeded translations failed!");
    }
  }
}
