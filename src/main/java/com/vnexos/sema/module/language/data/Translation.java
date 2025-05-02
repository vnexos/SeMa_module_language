package com.vnexos.sema.module.language.data;

import java.util.UUID;

import com.vnexos.sema.database.annotations.Column;
import com.vnexos.sema.database.annotations.Entity;
import com.vnexos.sema.database.helpers.DefaultEntity;

@Entity(tableName = "translations")
public class Translation extends DefaultEntity {
  @Column(nullable = false, foreignKey = Language.class)
  private UUID languageId;
  @Column(nullable = false)
  private String key;
  @Column(nullable = false)
  private String value;

  public Translation(String languageId, String key, String value) {
    this.languageId = UUID.fromString(languageId);
    this.key = key;
    this.value = value;
  }

  public UUID getLanguageId() {
    return languageId;
  }

  public void setLanguageId(UUID languageId) {
    this.languageId = languageId;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
