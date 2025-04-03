package com.vnexos.sema.module.language;

import com.vnexos.sema.context.ModuleServerContext;
import com.vnexos.sema.loader.annotations.MainClass;
import com.vnexos.sema.loader.interfaces.AModule;

@MainClass("Language")
public class LanguageModuleMain extends AModule {
  public static ModuleServerContext context;

  @Override
  public void onEnabled(ModuleServerContext context) {
    LanguageModuleMain.context = context;
    context.info("Language enabled");
  }

  @Override
  public void onDisabled() {
    context.log("Language disabled");
  } 
}
