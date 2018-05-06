package ua.kpi.tef.controller.enums;

public enum Language {
    DEFAULT("en"),
    UKRAINIAN("uk");

    Language(String language) {
        this.language = language;
    }

    String language;

    public static Language getLanguage(String language) throws Exception {
        switch (language) {
            case "en": return  DEFAULT;
            case "uk": return UKRAINIAN;
            default: throw new Exception();
        }
    }
    public String getValue() {
        return language;
    }



}
