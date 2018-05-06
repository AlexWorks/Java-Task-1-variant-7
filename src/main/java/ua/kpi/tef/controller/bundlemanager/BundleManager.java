package ua.kpi.tef.controller.bundlemanager;

import ua.kpi.tef.controller.enums.Language;

import java.util.Locale;
import java.util.ResourceBundle;

//TODO make enum for languages

public class BundleManager {
    private static String language = null;
    private ResourceBundle bundle;

    public static void changeLanguage(Language lang) {
        if (lang == Language.DEFAULT) language = null;
        else language = lang.getValue();
    }

    public BundleManager() {
        if (language != null) {
            this.bundle = ResourceBundle.getBundle(
                    "text",
                    new Locale(language));
        } else {
            this.bundle = ResourceBundle.getBundle("text");
        }
    }

    public String getString(String key) {
        return bundle.getString(key);
    }
}
