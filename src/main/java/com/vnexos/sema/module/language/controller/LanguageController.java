package com.vnexos.sema.module.language.controller;

import java.util.UUID;

import com.vnexos.sema.ApiResponse;
import com.vnexos.sema.loader.Part;
import com.vnexos.sema.loader.annotations.AutoWired;
import com.vnexos.sema.loader.annotations.Controller;
import com.vnexos.sema.loader.annotations.FromBody;
import com.vnexos.sema.loader.annotations.FromRoute;
import com.vnexos.sema.loader.annotations.HttpDelete;
import com.vnexos.sema.loader.annotations.HttpGet;
import com.vnexos.sema.loader.annotations.HttpPatch;
import com.vnexos.sema.loader.annotations.HttpPost;
import com.vnexos.sema.loader.interfaces.ControllerBase;
import com.vnexos.sema.module.language.data.Language;
import com.vnexos.sema.module.language.dto.LanguageCreateDto;
import com.vnexos.sema.module.language.dto.LanguageUpdateDto;
import com.vnexos.sema.module.language.repository.ILanguageRepository;
import com.vnexos.sema.util.Mapper;

@Controller("/languages")
public class LanguageController extends ControllerBase {
  @AutoWired
  private ILanguageRepository languageRepository;

  @HttpGet
  public ApiResponse<?> getAllLanguages() {
    try {
      Language[] languages = languageRepository.getAll();

      return createOk(languages);
    } catch(Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình lấy hết.");
    }
  }

  @HttpGet("{id}")
  public ApiResponse<?> getLanguageById(@FromRoute UUID id) {
    try {
      Language language = languageRepository.get(id);
      return createOk(language);
    } catch(Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình lấy 1 ngôn ngữ");
    }
  }

  @HttpPost
  public ApiResponse<?> createLanguage(@FromBody LanguageCreateDto request) {
    try {
      Language language = languageRepository.create(Mapper.map(request, Language.class));
      return createOk(language);
    } catch(Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 ngôn ngữ");
    }
  }

  @HttpPatch("{id}")
  public ApiResponse<?> updateLanguage(@FromRoute UUID id, @FromBody LanguageUpdateDto request, @FromBody Part file) {
    try {
      System.out.println(id);
      Language language = languageRepository.update(id, request.getFlagUrl());
      System.out.println(file.getFileName());
      return createOk(language);
    } catch(Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình cập nhật.");
    }
  }

  @HttpDelete("{id}")
  public ApiResponse<?> deleteLanguage(@FromRoute UUID id) {
    try {
      Language language = languageRepository.delete(id);
      System.out.println(id.getClass());
      return createOk(language);
    } catch(Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình xóa.");
    }
  }
}
