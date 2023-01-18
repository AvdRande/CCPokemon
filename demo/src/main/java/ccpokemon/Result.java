package ccpokemon;

public abstract class Result {
    private int turnAmount;
    
    public Result(int turnAmount) {
        this.turnAmount = turnAmount;
    }

    public abstract void show();

    public int getTurnAmount() {
        return turnAmount;
    }
}
