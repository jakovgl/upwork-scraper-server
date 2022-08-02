package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.repositories.SettingsRepository;
import generated.tables.pojos.Settings;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository settingsRepository;

    public Logger logger = LoggerFactory.getLogger(SettingsService.class);

    private final Long SETTINGS_ID = 1L;


    public Settings update(Settings settings) {

        validate(settings);

        logger.debug("Update the settings {}", settings.toString());
        return settingsRepository.update(SETTINGS_ID, settings);
    }

    public Settings get() {
        var settings = settingsRepository.findById(SETTINGS_ID);
        logger.debug("Getting the settings {}", settings);

        return settings;
    }

    private void validate(Settings settings) {

        logger.debug("Validating settings {}", settings.toString());

        if (settings.getActive() == null) {
            // TODO: Error handling
            throw new RuntimeException();
        }
    }
}
