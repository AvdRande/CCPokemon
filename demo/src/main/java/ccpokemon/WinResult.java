package ccpokemon;

public class WinResult extends Result {
    private String winner;
    private int hpRemaining;
    
    public WinResult(String winner, int hpRemaining, int turnAmount) {
        super(turnAmount);
        this.winner = winner;
        this.hpRemaining = hpRemaining;
    }

    @Override
    public void show() {
        System.out.println("The winner is: " + winner + "!");
        System.out.format("They had %d hp remaining.\n", this.hpRemaining);
        System.out.format("The battle took %d turns.\n", getTurnAmount());
    }
}
