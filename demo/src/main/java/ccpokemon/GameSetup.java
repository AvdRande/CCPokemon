package ccpokemon;

import java.io.File;
import java.util.Scanner;

// a data class for Game to transfer any needed information to up a game
public class GameSetup {
    private String pokemonA;
    private String pokemonB;

    public GameSetup(String pokemonA, String pokemonB) {
        this.pokemonA = pokemonA;
        this.pokemonB = pokemonB;
    }

    public static GameSetup setupFromCL() {
        Scanner sc = new Scanner(System.in);

        String[] availablePokemon = getAvailablePokemon();

        System.out.println("These are the available pokemon:");
        for (String pokemonName : availablePokemon) {
            System.out.println(pokemonName);
        }

        System.out.println("Please enter name of first pokemon:");
        String pokemonA = sc.nextLine();

        System.out.println("Please enter name of second pokemon:");
        String pokemonB = sc.nextLine();

        sc.close();
        return new GameSetup(pokemonA, pokemonB);
    }

    private static String[] getAvailablePokemon() {
        File pokemonFolder = new File("demo/src/main/java/ccpokemon/resources");

        File[] pokemonFiles = pokemonFolder.listFiles();

        String[] pokemonNames = new String[pokemonFiles.length];

        for (int i = 0; i < pokemonFiles.length; i++) {
            pokemonNames[i] = pokemonFiles[i].getName().substring(0, pokemonFiles[i].getName().length() - 5);
        }

        return pokemonNames;
    }

    public String getPokemonA() {
        return pokemonA;
    }

    public void setPokemonA(String pokemonA) {
        this.pokemonA = pokemonA;
    }

    public String getPokemonB() {
        return pokemonB;
    }

    public void setPokemonB(String pokemonB) {
        this.pokemonB = pokemonB;
    }
}
