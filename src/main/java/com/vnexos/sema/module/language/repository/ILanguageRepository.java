package com.vnexos.sema.module.language.repository;

import java.util.UUID;

import com.vnexos.sema.database.helpers.DatabaseContext;
import com.vnexos.sema.loader.annotations.repository.ContextId;
import com.vnexos.sema.module.language.data.Language;

public interface ILanguageRepository extends DatabaseContext<Language, UUID> {
  public Language update(@ContextId UUID id, String flagUrl);

  public Language get(String code);

  public Language getByCode(String code);
}
