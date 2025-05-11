package com.vnexos.sema.module.language.controller;

import java.util.HashMap;
import java.util.Map;
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
import com.vnexos.sema.module.language.LanguageModuleMain;
import com.vnexos.sema.module.language.data.Language;
import com.vnexos.sema.module.language.data.Translation;
import com.vnexos.sema.module.language.dto.LanguageCreateDto;
import com.vnexos.sema.module.language.dto.LanguageUpdateDto;
import com.vnexos.sema.module.language.dto.TranslationCreateDto;
import com.vnexos.sema.module.language.dto.TranslationUpdateDto;
import com.vnexos.sema.module.language.repository.ILanguageRepository;
import com.vnexos.sema.module.language.repository.ITranslationRepository;
import com.vnexos.sema.util.Mapper;

@Controller("languages")
public class LanguageController extends ControllerBase {
  @AutoWired
  private ILanguageRepository languageRepository;
  @AutoWired
  private ITranslationRepository translationRepository;

  @HttpGet
  public ApiResponse<?> getAllLanguages() {
    try {
      Language[] languages = languageRepository.getAll();

      return createOk(languages);
    } catch (Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình lấy hết.");
    }
  }

  @HttpGet("{code}")
  public ApiResponse<?> getLanguageById(@FromRoute String code) {
    try {
      Language language = languageRepository.getByCode(code);
      return createOk(language);
    } catch (Exception ex) {
      LanguageModuleMain.context.log(ex);
      return createInternalRequest("Lỗi xãy ra trong quá trình lấy 1 ngôn ngữ");
    }
  }

  @HttpPost
  public ApiResponse<?> createLanguage(@FromBody LanguageCreateDto request) {
    try {
      Language language = languageRepository.create(Mapper.map(request, Language.class));
      return createOk(language);
    } catch (Exception ex) {
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
    } catch (Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình cập nhật.");
    }
  }

  @HttpDelete("{id}")
  public ApiResponse<?> deleteLanguage(@FromRoute UUID id) {
    try {
      Language language = languageRepository.delete(id);
      System.out.println(id.getClass());
      return createOk(language);
    } catch (Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình xóa.");
    }
  }

  private Map<String, String> createTranslationMap(Translation[] translations) {
    Map<String, String> map = new HashMap<>();
    for (Translation translation : translations) {
      map.put(translation.getKey(), translation.getValue());
    }
    return map;
  }

  @HttpPost("{code}/translations")
  public ApiResponse<?> createTranslation(@FromRoute String code, @FromBody TranslationCreateDto request) {
    try {
      Language language = languageRepository.get(code);
      request.setLanguageId(language.getId());
      Translation translation = translationRepository.create(Mapper.map(request, Translation.class));
      return createOk(translation);
    } catch (Exception ex) {
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 thuật ngữ.");
    }
  }

  @HttpGet("{code}/translations")
  public ApiResponse<?> getAll(@FromRoute String code) {
    try {
      Language language = languageRepository.get(code);
      Translation[] translations = translationRepository.get(language.getId().toString());
      return createOk(createTranslationMap(translations));
    } catch (Exception ex) {
      ex.printStackTrace();
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 thuật ngữ.");
    }
  }

  @HttpGet("{code}/translations/{pattern}")
  public ApiResponse<?> getTranslations(@FromRoute String code, @FromRoute String pattern) {
    try {
      Language language = languageRepository.get(code);
      Translation[] translations = translationRepository.get(language.getId(), pattern);
      return createOk(createTranslationMap(translations));
    } catch (Exception ex) {
      ex.printStackTrace();
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 thuật ngữ.");
    }
  }

  @HttpPatch("{code}/translations/{pattern}")
  public ApiResponse<?> updateTranslation(@FromRoute String code, @FromRoute String pattern,
      @FromBody TranslationUpdateDto request) {
    try {
      Language language = languageRepository.get(code);
      Translation[] translations = translationRepository.get(language.getId(), pattern);
      if (translations.length != 1)
        throw new Exception("Chỉ được phép cập nhật duy nhất 1 thuật ngữ");

      return createOk(translationRepository.update(translations[0].getId(), request.getValue()));
    } catch (Exception ex) {
      ex.printStackTrace();
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 thuật ngữ.");
    }
  }

  @HttpDelete("{code}/translations/{pattern}")
  public ApiResponse<?> delete(@FromRoute String code, @FromRoute String pattern) {
    try {
      Language language = languageRepository.get(code);
      Translation[] translations = translationRepository.get(language.getId(), pattern);
      for (Translation translation : translations) {
        translationRepository.delete(translation.getId());
      }
      return createOk(createTranslationMap(translations));
    } catch (Exception ex) {
      ex.printStackTrace();
      return createInternalRequest("Lỗi xãy ra trong quá trình tạo 1 thuật ngữ.");
    }
  }
}
