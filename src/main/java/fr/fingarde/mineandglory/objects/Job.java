package fr.fingarde.mineandglory.objects;

public class Job {
    private int farmerLvl;
    private int farmerExp;

    private int animalBreaderLvl;
    private int animalBreaderExp;

    private int minerLvl;
    private int minerExp;

    private int woodcutterLvl;
    private int woodcutterExp;

    private int armorerLvl;
    private int armorerExp;

    private int fisherLvl;
    private int fisherExp;

    private int hunterLvl;
    private int hunterExp;

    private int cookerLvl;
    private int cookerExp;

    private int builderLvl;
    private int builderExp;

    private int terraformerLvl;
    private int terraformerExp;

    private int blacksmithLvl;
    private int blacksmithExp;

    private int enchanterLvl;
    private int enchanterExp;

    private int alchemistLvl;
    private int alchemistExp;

    public int getFarmerLvl() {
        return farmerLvl;
    }

    public void setFarmerLvl(int farmerLvl) {
        this.farmerLvl = farmerLvl;
    }

    public int getFarmerExp() {
        return farmerExp;
    }

    public void setFarmerExp(int farmerExp) {
        this.farmerExp = farmerExp;
    }

    public int getAnimalBreaderLvl() {
        return animalBreaderLvl;
    }

    public void setAnimalBreaderLvl(int animalBreaderLvl) {
        this.animalBreaderLvl = animalBreaderLvl;
    }

    public int getAnimalBreaderExp() {
        return animalBreaderExp;
    }

    public void setAnimalBreaderExp(int animalBreaderExp) {
        this.animalBreaderExp = animalBreaderExp;
    }

    public int getMinerLvl() {
        return minerLvl;
    }

    public void setMinerLvl(int minerLvl) {
        this.minerLvl = minerLvl;
    }

    public int getMinerExp() {
        return minerExp;
    }

    public void setMinerExp(int minerExp) {
        this.minerExp = minerExp;
    }

    public int getWoodcutterLvl() {
        return woodcutterLvl;
    }

    public void setWoodcutterLvl(int woodcutterLvl) {
        this.woodcutterLvl = woodcutterLvl;
    }

    public int getWoodcutterExp() {
        return woodcutterExp;
    }

    public void setWoodcutterExp(int woodcutterExp) {
        this.woodcutterExp = woodcutterExp;
    }

    public int getArmorerLvl() {
        return armorerLvl;
    }

    public void setArmorerLvl(int armorerLvl) {
        this.armorerLvl = armorerLvl;
    }

    public int getArmorerExp() {
        return armorerExp;
    }

    public void setArmorerExp(int armorerExp) {
        this.armorerExp = armorerExp;
    }

    public int getFisherLvl() {
        return fisherLvl;
    }

    public void setFisherLvl(int fisherLvl) {
        this.fisherLvl = fisherLvl;
    }

    public int getFisherExp() {
        return fisherExp;
    }

    public void setFisherExp(int fisherExp) {
        this.fisherExp = fisherExp;
    }

    public int getHunterLvl() {
        return hunterLvl;
    }

    public void setHunterLvl(int hunterLvl) {
        this.hunterLvl = hunterLvl;
    }

    public int getHunterExp() {
        return hunterExp;
    }

    public void setHunterExp(int hunterExp) {
        this.hunterExp = hunterExp;
    }

    public int getCookerLvl() {
        return cookerLvl;
    }

    public void setCookerLvl(int cookerLvl) {
        this.cookerLvl = cookerLvl;
    }

    public int getCookerExp() {
        return cookerExp;
    }

    public void setCookerExp(int cookerExp) {
        this.cookerExp = cookerExp;
    }

    public int getBuilderLvl() {
        return builderLvl;
    }

    public void setBuilderLvl(int builderLvl) {
        this.builderLvl = builderLvl;
    }

    public int getBuilderExp() {
        return builderExp;
    }

    public void setBuilderExp(int builderExp) {
        this.builderExp = builderExp;
    }

    public int getTerraformerLvl() {
        return terraformerLvl;
    }

    public void setTerraformerLvl(int terraformerLvl) {
        this.terraformerLvl = terraformerLvl;
    }

    public int getTerraformerExp() {
        return terraformerExp;
    }

    public void setTerraformerExp(int terraformerExp) {
        this.terraformerExp = terraformerExp;
    }

    public int getBlacksmithLvl() {
        return blacksmithLvl;
    }

    public void setBlacksmithLvl(int blacksmithLvl) {
        this.blacksmithLvl = blacksmithLvl;
    }

    public int getBlacksmithExp() {
        return blacksmithExp;
    }

    public void setBlacksmithExp(int blacksmithExp) {
        this.blacksmithExp = blacksmithExp;
    }

    public int getEnchanterLvl() {
        return enchanterLvl;
    }

    public void setEnchanterLvl(int enchanterLvl) {
        this.enchanterLvl = enchanterLvl;
    }

    public int getEnchanterExp() {
        return enchanterExp;
    }

    public void setEnchanterExp(int enchanterExp) {
        this.enchanterExp = enchanterExp;
    }

    public int getAlchemistLvl() {
        return alchemistLvl;
    }

    public void setAlchemistLvl(int achemistLvl) {
        this.alchemistLvl = achemistLvl;
    }

    public int getAlchemistExp() {
        return alchemistExp;
    }

    public void setAlchemistExp(int achemistExp) {
        this.alchemistExp = achemistExp;
    }

    public static int getTotalXpForNextLvl(int currentLvl) {
        return (int) (currentLvl * (currentLvl / 8.0) * 100 + 68);
    }
}
