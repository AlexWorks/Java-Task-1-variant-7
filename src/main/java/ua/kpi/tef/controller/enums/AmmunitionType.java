package ua.kpi.tef.controller.enums;
public enum AmmunitionType {
    HELMET("Helmet"),
    CHESTPLATE("Chestplate"),
    LEGGINS("Leggins"),
    BOOTS("Boots"),
    WEAPON("Weapon"),
    SHIELD("Shield");

    private String type;

     AmmunitionType(String type) {
        this.type = type;
    }

    static public AmmunitionType getType(String type) throws Exception {
        switch (type) {
            case "Helmet": return HELMET;
            case "Chestplate": return CHESTPLATE;
            case "Leggins": return LEGGINS;
            case "Boots": return BOOTS;
            case "Weapon": return WEAPON;
            case "Shield": return SHIELD;
            default: throw new Exception();
        }
    }
}
