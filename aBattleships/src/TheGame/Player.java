package TheGame;

public class Player {
    private String name;
    private int points;
    private int turns;
    private boolean debugMode; //if the player wants to play in debug Mode or not

    //constructor
    Player(String name, boolean debugMode){
        this.name = name;
        this.points = 0;
        this.turns = 10;
        this.debugMode = debugMode;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public int getPoints(){
        return this.points;
    }
    public int getTurns(){
        return this.turns;
    }
    public boolean getDebugMode(){
        return this.debugMode;
    }

    //setters
    public void setPoints(int points){ this.points = points; }
    public void setTurns(int turns){ this.turns = turns; }
    public void setDebugMode(boolean debugMode){ this.debugMode = debugMode; }

}
