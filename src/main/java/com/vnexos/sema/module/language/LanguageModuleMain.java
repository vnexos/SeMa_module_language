package com.vnexos.sema.module.language;

import com.vnexos.sema.context.ModuleServerContext;
import com.vnexos.sema.loader.annotations.AutoWired;
import com.vnexos.sema.loader.annotations.MainClass;
import com.vnexos.sema.loader.interfaces.AModule;
import com.vnexos.sema.module.language.seeders.LanguageSeeder;

@MainClass("Language")
public class LanguageModuleMain extends AModule {
  public static ModuleServerContext context;

  @AutoWired
  private LanguageSeeder languageSeeder;

  @Override
  public void onEnabled(ModuleServerContext context) {
    LanguageModuleMain.context = context;
    context.info("Language enabled");
    languageSeeder.seed();
  }

  @Override
  public void onDisabled() {
    context.log("Language disabled");
  } 
}
