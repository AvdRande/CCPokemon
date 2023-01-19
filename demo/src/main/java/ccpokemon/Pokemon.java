package ccpokemon;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pokemon {
    private String name;

    private int maxHp;
    private int curHp;

    // each pokemon has one strength and one weakness
    private DamageType weakness;
    private DamageType strength;
    

    public Pokemon() {
        this.name = "";
        
        this.maxHp = 0;
        this.curHp = 0;

        this.weakness = null;
        this.strength = null;
    }

    public Pokemon(String name, int maxHp, int curHp, DamageType weakness, DamageType strength) {
        this.name = name;
        this.maxHp = maxHp;
        this.curHp = curHp;
        this.weakness = weakness;
        this.strength = strength;
    }

    public boolean isDead() {
        return curHp <= 0;
    }

    public void takeDamage(int damage) {
        this.curHp -= damage;
    }

    // create new pokemon from standard pokemon file
    public static Pokemon buildFromFile(File pokemonFile) throws IOException {
        Scanner pokemonFileScanner = new Scanner(new FileReader(pokemonFile));

        Pokemon pokemonFromFile = new Pokemon();
        
        pokemonFromFile.setName(pokemonFileScanner.next());

        pokemonFromFile.setMaxHp(pokemonFileScanner.nextInt());
        pokemonFromFile.setCurHp(pokemonFromFile.getMaxHp());
        
        try {
            pokemonFromFile.setWeakness(DamageType.fromString(pokemonFileScanner.next()));
        } catch (Exception e) {
            System.out.println("Unable to find weakness damage type for pokemon " + pokemonFromFile.getName());
            e.printStackTrace();
        }

        try {
            pokemonFromFile.setStrength(DamageType.fromString(pokemonFileScanner.next()));
        } catch (Exception e) {
            System.out.println("Unable to find strength damage type for pokemon " + pokemonFromFile.getName());
            e.printStackTrace();
        }

        pokemonFileScanner.close();
        return pokemonFromFile;    
    }

    public void printInformation() {
        System.out.println("Name: " + name);
        System.out.format("Max HP: %d\n", maxHp);
        System.out.println("Weakness: " + weakness.toString());
        System.out.println("Strength: " + strength.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurHp() {
        return curHp;
    }

    public void setCurHp(int curHp) {
        this.curHp = curHp;
    }

    public DamageType getWeakness() {
        return weakness;
    }

    public void setWeakness(DamageType weakness) {
        this.weakness = weakness;
    }

    public DamageType getStrength() {
        return strength;
    }

    public void setStrength(DamageType strength) {
        this.strength = strength;
    }
}
