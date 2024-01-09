package TheGame;

public enum Ship {
    //All ship types as enums
    AIRCRAFT (5, 2, "Aircraft Carrier"),
    BATTLESHIP (4, 4, "Battleship"),
    SUBMARINE (3, 6, "Submarine"),
    DESTROYER (2, 8, "Destroyer"),
    PATROL (1, 10, "Patrol Boat");

    //properties for ships
    public final int length; //ship length
    public final int points; //points for ship
    public final String name; //name of ship
    public boolean hit; //if the ship is hit or not

    //constructor for the enum class
    private Ship(int length, int points, String name){
        this.length = length;
        this.points = points;
        this.name = name;
        this.hit = false;
    }

}
