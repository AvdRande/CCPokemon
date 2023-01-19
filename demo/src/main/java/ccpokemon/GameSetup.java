package ccpokemon;

import java.io.File;
import java.io.IOException;
import java.util.Random;
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

        String ownPokemon = "";
        String enemyPokemon = "";

        System.out.println("Welcome to the one and only Pokemon game!\n");
        if (ownPokemon.equals("")) {
            System.out.println("You currently have no pokemon selected.");
        } else {
            System.out.println("You chose " + ownPokemon + " and are ready to duel!");
        }

        int dialogOption = 0;

        while (dialogOption != 3) {
            System.out.println("Choose what you want to do:\n" +
                    "1: Choose pokemon\n" +
                    "2: Open pokedex\n" +
                    "3: Start battle\n");
            dialogOption = sc.nextInt();

            if (dialogOption == 1) {
                ownPokemon = selectOwnPokemon(sc);
            }
            if (dialogOption == 2) {
                openPokeDex(sc);
            }
        }

        enemyPokemon = selectOpponentPokemon(sc);

        sc.close();
        return new GameSetup(ownPokemon, enemyPokemon);
    }

    private static void openPokeDex(Scanner sc) {
        String[] availablePokemon = getAvailablePokemon();
        for (String pokemonName : availablePokemon) {
            File pokemonFile = new File(
                    "demo/src/main/java/ccpokemon/resources/" + pokemonName + ".poke");
            try {
                Pokemon pokemon = Pokemon.buildFromFile(pokemonFile);
                pokemon.printInformation();
                System.out.println("------------------------");
            } catch (IOException e) {
                System.out.println("Failed to build pokemon A during initialisation of game");
                e.printStackTrace();
            }
        }
    }

    public static String selectOwnPokemon(Scanner sc) {
        System.out.println("These are the available pokemon:");
        for (String pokemonName : getAvailablePokemon()) {
            System.out.println(pokemonName);
        }

        System.out.println("Please enter name of your pokemon:");
        sc.nextLine();
        return sc.nextLine();
    }

    public static String selectOpponentPokemon(Scanner sc) {
        System.out.println("These are the available pokemon:");
        String[] availablePokemon = getAvailablePokemon();
        for (String pokemonName : availablePokemon) {
            System.out.println(pokemonName);
        }

        System.out.println("Please enter name of your opponents pokemon or enter nothing for a random opponent:");
        
        String opponent = sc.nextLine();
        sc.nextLine();
        if (opponent.equals("")) {
            Random rn = new Random();
            opponent = availablePokemon[rn.nextInt(availablePokemon.length)];
        }
        return opponent;
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
