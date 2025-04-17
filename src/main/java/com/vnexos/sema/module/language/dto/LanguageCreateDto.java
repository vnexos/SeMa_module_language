package com.vnexos.sema.module.language.dto;

public class LanguageCreateDto {
  private String code;
  private String name;
  private String flagUrl;
  private String description;
  private boolean isDefault;
  private boolean isRightToLeft;

  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
