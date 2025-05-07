package com.vnexos.sema.module.language.seeders;

import com.vnexos.sema.loader.annotations.AutoWired;
import com.vnexos.sema.loader.annotations.Service;
import com.vnexos.sema.module.language.LanguageModuleMain;
import com.vnexos.sema.module.language.data.Language;
import com.vnexos.sema.module.language.repository.ILanguageRepository;

@Service
public class LanguageSeeder {
  @AutoWired
  private ILanguageRepository languageRepository;

  private static Language[] languages = new Language[] {
      new Language("60000196-4f33-f7af-9c49-08b9a61b608a", "vi-vn", "Tiếng Việt",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/vn.svg", "VIETNAMESE", true, false),
      new Language("60000196-4f33-f7d1-b885-a868ec73fe40", "vi-us", "Tiếng Việt (Vện)",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/vnch.svg", "NONLANGUAGE", false, true),
      new Language("60000196-4f33-f7e3-af53-8bf3aeeac060", "en-us", "English (US)",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/us.svg",
          "ENGLISH_US", false, false),
      new Language("60000196-4f33-f7f6-86a8-4d39c181a03a", "en-uk", "English (UK)",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/gb.svg",
          "ENGLISH_UK", false, false),
      new Language("60000196-4f33-f809-8516-bbb93a1d341a", "ar-sa", "اَلْعَرَبِيَّةُ",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/sa.svg", "ARABIC", false, true),
      new Language("60000196-4f33-f81a-ac04-de7e95eada64", "he-il", "עברית",
          "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/il.svg",
          "HEBREW", false, true),
  };

  public void seed() {
    try {
      int languageCount = languageRepository.count();

      if (languageCount == 0) {
        for (Language lang : languages) {
          languageRepository.create(lang);
        }
      }
      LanguageModuleMain.context.info("Seeded languages successful!");
    } catch (Exception ex) {
      LanguageModuleMain.context.error("Seeded languages failed!");
    }
  }
}
