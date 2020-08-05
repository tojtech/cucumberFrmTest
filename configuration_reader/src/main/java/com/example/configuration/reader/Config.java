package com.example.configuration.reader;

import com.example.configuration.reader.properties.PropertiesLoader;
import com.example.configuration.reader.properties.PropertyFile;

/**
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("pathToConfig")
public class Config {

    private static Config config;

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public Config() {
        PropertiesLoader.populate(this);
    }
}
