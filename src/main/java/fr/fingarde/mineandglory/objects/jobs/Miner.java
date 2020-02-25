package fr.fingarde.mineandglory.objects.jobs;

public enum Miner {
    BREAK_STONE(0, 2),
    BREAK_COAL_ORE(1, 50),
    BREAK_IRON_ORE(3, 75),
    BREAK_GOLD_ORE(10, 100),
    BREAK_DIAMOND_ORE(15, 200),
    BREAK_EMERALD_ORE(20, 300);

    private int minLvl;
    private int xp;

    Miner(int minLvl, int xp) {
        this.minLvl = minLvl;
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    public int getMinLvl() {
        return minLvl;
    }

    public static Miner getMiner(String value) {
        for (Miner miner : Miner.values()) {
            if (miner.name().equals(value)) {
                return miner;
            }
        }

        return null;
    }
}
