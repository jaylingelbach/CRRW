public enum Emblem {
    NONE("None"),
    HEART("Heart"), // pink
    FLAME("Flame"), // red
    SUN("Sun"), // orange
    ZAP("Zap"),  // yellow
    LEAF("Leaf"), // green
    SPLASH("Splash"), // blue
    DIAMOND("Diamond"), // purple
    MOON("Moon"); // white/black

    private final String displayName;

    Emblem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    }
