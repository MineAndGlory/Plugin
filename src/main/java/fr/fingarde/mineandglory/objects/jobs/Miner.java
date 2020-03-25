package fr.fingarde.mineandglory.objects.jobs;

public enum Miner
{
    BREAK_STONE(0, 2),
    BREAK_COAL_ORE(1, 8),
    BREAK_IRON_ORE(3, 12),
    BREAK_GOLD_ORE(10, 20),
    BREAK_DIAMOND_ORE(15, 30),
    BREAK_EMERALD_ORE(20, 40);

    private int minLvl;
    private int xp;

    Miner(int minLvl, int xp)
    {
        this.minLvl = minLvl;
        this.xp = xp;
    }

    public int getXp()
    {
        return xp;
    }

    public int getMinLvl()
    {
        return minLvl;
    }

    public static Miner getMiner(String value)
    {
        for (Miner miner : Miner.values())
        {
            if (miner.name().equals(value))
            {
                return miner;
            }
        }

        return null;
    }
}
