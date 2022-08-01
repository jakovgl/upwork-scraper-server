package com.upworkscraper.upworkscraper.repositories;

import generated.tables.Settings;
import generated.tables.records.SettingsRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
public class SettingsRepository extends AbstractRepository<SettingsRecord, generated.tables.pojos.Settings> {

    public SettingsRepository(DSLContext db) {
        super(db, Settings.SETTINGS.asTable(), Settings.SETTINGS.ID, generated.tables.pojos.Settings.class);
    }
}
