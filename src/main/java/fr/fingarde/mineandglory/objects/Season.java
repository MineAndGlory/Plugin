package fr.fingarde.mineandglory.objects;

public class Season
{
    public enum SeasonType {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER;

        private static SeasonType[] values = values();
        public SeasonType next()
        {
            return values[(this.ordinal() + 1) % values.length];
        }
    }

    private static SeasonType currentSeason;

    public static SeasonType getCurrentSeason()
    {
        return currentSeason;
    }

    public static void setCurrentSeason(SeasonType currentSeason)
    {
        Season.currentSeason = currentSeason;
    }

    public static void nextSeason() {
       currentSeason = currentSeason.next();
    }
}
