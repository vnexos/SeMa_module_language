package com.vnexos.sema.module.language.repository;

import java.util.UUID;

import com.vnexos.sema.database.helpers.DatabaseContext;
import com.vnexos.sema.loader.annotations.repository.ContextId;
import com.vnexos.sema.module.language.data.Translation;

public interface ITranslationRepository extends DatabaseContext<Translation, UUID> {
  public Translation[] get(String languageId);

  public Translation[] get(UUID languageId, String key);

  public Translation update(@ContextId UUID id, String value);
}
