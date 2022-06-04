package com.cronus.app;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties PROPERTIES;
    private static final Properties CHAT_IDS;
    private static final Properties EXCEL_PROPERTIES;

    private static final String PROP_FILE = "application.properties";
    private static final String CHAT_ID_FILE = "chatIds.properties";
    private static final String EXCEL_PROP_FILE = "excel.properties";

    static {
        PROPERTIES = new Properties();
        CHAT_IDS = new Properties();
        EXCEL_PROPERTIES = new Properties();

        final URL props = ClassLoader.getSystemResource(PROP_FILE);
        final URL chatIds = ClassLoader.getSystemResource(CHAT_ID_FILE);
        final URL excelProps = ClassLoader.getSystemResource(EXCEL_PROP_FILE);
        try {
            PROPERTIES.load(props.openStream());
            CHAT_IDS.load(chatIds.openStream());
            EXCEL_PROPERTIES.load(excelProps.openStream());
        } catch (IOException ex) {
            System.err.println(ex.getClass().getName() + "PropertiesReader method");
        }
    }

    public static String getProperty(final String name) {
        return PROPERTIES.getProperty(name);
    }

    public static String getChatId(final String name) {
        return CHAT_IDS.getProperty(name);
    }

    public static int getExcelProperty(final String name) {
        return Integer.parseInt(EXCEL_PROPERTIES.getProperty(name));
    }
}
