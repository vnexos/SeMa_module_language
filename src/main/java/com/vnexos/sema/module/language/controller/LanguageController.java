package com.vnexos.sema.module.language.controller;

import com.vnexos.sema.ApiResponse;
import com.vnexos.sema.loader.annotations.AutoWired;
import com.vnexos.sema.loader.annotations.Controller;
import com.vnexos.sema.loader.annotations.FromBody;
import com.vnexos.sema.loader.annotations.HttpPost;
import com.vnexos.sema.loader.interfaces.ControllerBase;
import com.vnexos.sema.module.language.repository.ILanguageRepository;

class TestObject {
  private String value;
  private String anotherValue;
  public String getAnotherValue() {
    return anotherValue;
  }
  public void setAnotherValue(String anotherValue) {
    this.anotherValue = anotherValue;
  }
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
}

@Controller("/languages")
public class LanguageController extends ControllerBase {
  @AutoWired
  private ILanguageRepository languageRepository;

  @HttpPost
  public ApiResponse<?> index(@FromBody TestObject testObject) {
    System.out.println(languageRepository);
    return createOk(testObject);
  }
}
