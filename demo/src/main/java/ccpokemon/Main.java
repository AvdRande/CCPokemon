package ccpokemon;

public class Main {
    public static void main(String[] args) {
        GameSetup setup;
        // retrieve game setup from command inputs
        if (args.length > 0) { // if we want to specify contesting pokemon from launch
            setup = new GameSetup(args[0], args[1]);
        } else { // or ask in command prompt
            setup = GameSetup.setupFromCL();
        }

        // create game
        Game game = new Game(setup);

        // run it
        Result r = game.runGame();
        r.show();
    }
}
