package ccpokemon;

public class TieResult extends Result {
    public TieResult(int turnAmount) {
        super(turnAmount);
    }

    @Override
    public void show() {
        System.out.format("The game ended as a tie after %i turns", getTurnAmount());        
    }
    
}
