package com.vnexos.sema.module.language.dto;

import java.util.UUID;

@SuppressWarnings("unused")
public class TranslationCreateDto {
  private UUID languageId;
  private String key;
  private String value;

  public void setLanguageId(UUID languageId) {
    this.languageId = languageId;
  }
}
