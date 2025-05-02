package com.vnexos.sema.module.language.data;

import java.util.UUID;

import com.vnexos.sema.database.annotations.Column;
import com.vnexos.sema.database.annotations.Entity;
import com.vnexos.sema.database.helpers.DefaultEntity;

@Entity(tableName = "languages")
public class Language extends DefaultEntity {
  @Column(nullable = false, length = 10, unique = true)
  private String code;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, type = "TEXT")
  private String flagUrl;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false, defaultValue = "0")
  private boolean isDefault;

  @Column(nullable = false, defaultValue = "0")
  private boolean isRightToLeft;

  public Language() {
  }

  public Language(String code, String name, String flagUrl, String description, boolean isDefault,
      boolean isRightToLeft) {
    this.code = code;
    this.name = name;
    this.flagUrl = flagUrl;
    this.description = description;
    this.isDefault = isDefault;
    this.isRightToLeft = isRightToLeft;
  }

  public Language(String id, String code, String name, String flagUrl, String description, boolean isDefault,
      boolean isRightToLeft) {
    this(code, name, flagUrl, description, isDefault, isRightToLeft);
    setId(UUID.fromString(id));
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFlagUrl() {
    return flagUrl;
  }

  public void setFlagUrl(String flagUrl) {
    this.flagUrl = flagUrl;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public void setDefault(boolean isDefault) {
    this.isDefault = isDefault;
  }

  public boolean isRightToLeft() {
    return isRightToLeft;
  }

  public void setRightToLeft(boolean isRightToLeft) {
    this.isRightToLeft = isRightToLeft;
  }
}
