package ccpokemon;

public enum DamageType {
    FIRE, WATER, EARTH, AIR;

    public static DamageType fromString(String toConvert) throws Exception {
        switch(toConvert) {
            case "fire":
                return DamageType.FIRE;
            case "water":
                return DamageType.WATER;
            case "earth":
                return DamageType.EARTH;
            case "air":
                return DamageType.AIR;
            default:
                throw new Exception("Damage Type not found: " + toConvert);
        }
    }
}
