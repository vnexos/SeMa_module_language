package com.vnexos.sema.module.language.repository;

import java.util.UUID;

import com.vnexos.sema.database.helpers.DatabaseContext;
import com.vnexos.sema.module.language.data.Language;

public interface ILanguageRepository extends DatabaseContext<Language, UUID> {
}
