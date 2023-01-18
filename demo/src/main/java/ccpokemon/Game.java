package ccpokemon;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game {
    private Pokemon pokemonA;
    private Pokemon pokemonB;

    private Random diceRoller;

    public Game(GameSetup setup) {
        File pokemonAFile = new File(
                "demo/src/main/java/ccpokemon/resources/" + setup.getPokemonA().toLowerCase() + ".poke");
        try {
            this.pokemonA = Pokemon.buildFromFile(pokemonAFile);
        } catch (IOException e) {
            System.out.println("Failed to build pokemon A during initialisation of game");
            e.printStackTrace();
        }

        File pokemonBFile = new File(
                "demo/src/main/java/ccpokemon/resources/" + setup.getPokemonB().toLowerCase() + ".poke");
        try {
            this.pokemonB = Pokemon.buildFromFile(pokemonBFile);
        } catch (IOException e) {
            System.out.println("Failed to build pokemon B during initialisation of game");
            e.printStackTrace();
        }

        diceRoller = new Random();
    }

    public Result runGame() {
        int turn = 0;

        while (!isGameOver()) {
            turn++;
            System.out.println("---------------------------------------------------------");
            System.out.format("Turn: %d\n", turn);

            attacks(pokemonA, pokemonB);
            attacks(pokemonB, pokemonA);

            System.out.format(pokemonA.getName() + " has %d hp remaining\n", pokemonA.getCurHp());
            System.out.format(pokemonB.getName() + " has %d hp remaining\n", pokemonB.getCurHp());
        }

        if (pokemonA.isDead() && pokemonB.isDead()) {
            return new TieResult(turn);
        } else {
            if (pokemonA.isDead()) {
                return new WinResult(pokemonB.getName(), pokemonB.getCurHp(), turn);
            } else {
                return new WinResult(pokemonA.getName(), pokemonA.getCurHp(), turn);
            }
        }
    }

    private boolean isGameOver() {
        return pokemonA.isDead() || pokemonB.isDead();
    }

    public void attacks(Pokemon attacker, Pokemon defender) {
        int toHit = rollDice();

        if (toHit >= 3) { // all pokemon hit on a d6 roll of 3 or higher
            System.out.println(attacker.getName() + " attacks and hits!");
            int damage = rollDice();

            if (attacker.getStrength() == defender.getWeakness()) {
                damage += rollDice();
            }
            System.out.format(attacker.getName() + " did %d damage to " + defender.getName() + "\n", damage);
            defender.takeDamage(damage);
        } else {
            System.out.println(attacker.getName() + " misses!");
        }
    }

    public int rollDice() {
        return diceRoller.nextInt(6) + 1;
    }
}
