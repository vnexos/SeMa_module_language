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
    new Language("vi-vn", "Tiếng Việt", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/vn.svg", "VIETNAMESE", true, false),
    new Language("vi-us", "Tiếng Việt (VNCH)", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/vnch.svg", "NONLANGUAGE", false, true),
    new Language("en-us", "English (US)", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/us.svg", "ENGLISH_US", false, false),
    new Language("en-uk", "English (UK)", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/gb.svg", "ENGLISH_UK", false, false),
    new Language("ar-sa", "اَلْعَرَبِيَّةُ", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/sa.svg", "ARABIC", false, true),
    new Language("he-il", "עברית", "https://raw.githubusercontent.com/vnexos/flags/refs/heads/main/il.svg", "HEBREW", false, true),
  };

  public void seed() {
    try {
      int languageCount = languageRepository.count();
      if(languageCount == 0) {
        for(Language lang : languages) {
          languageRepository.create(lang);
        }
      }
      LanguageModuleMain.context.info("Seeded languages successful!");
    } catch (Exception ex) {
      LanguageModuleMain.context.error("Seeded languages failed!");
    }
  }
}
