package ccpokemon;

public class Tie extends Result {
    public Tie(int turnAmount) {
        super(turnAmount);
    }

    @Override
    public void show() {
        System.out.format("The game ended as a tie after %d turns", getTurnAmount());        
    }
    
}
