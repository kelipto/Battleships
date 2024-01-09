package TheGame;
import java.util.Scanner;
import java.util.Vector;

public class Game {
    Scanner input = new Scanner(System.in); //input scanner object
    Player player;
    Field field;
    int highscore;

    public void startGame(){
        player = initializeGame();
        playGame(player, field);
    }

    public Player initializeGame(){
        System.out.println("Enter the player name\n");
        String name = input.nextLine();
        System.out.println("To play game in Debug mode press \"1\" \nIf you don't want to play in debug mode select any number beside \"1\"\n");
        int choice = input.nextInt();
        Player player = new Player(name, (choice == 1 ? true: false) );
        return player;
    }

    public void playGame(Player player, Field field){
        field = new Field();
        int x,y;
        Ship ship;

        //check for debugMode
        if(player.getDebugMode() == true){
            debugMode(field);
        }

        //starting game details
        System.out.println("Player Name: " + player.getName() + ",  Turns Left: " + player.getTurns() + ",  Points: " + player.getPoints());
        while (player.getTurns() > 0){
            System.out.println("Enter the coordinates from 10 x 10 grid to shoot missile (eg. (x, y))");
            System.out.println("Enter x coordinate");
            x = input.nextInt();
            System.out.println("Enter y coordinate");
            y = input.nextInt();

            //checking if coordinates are within the board
            if (field.validCoordinates(x, y)){
                //check if the coordinate is already hit by the user
                if(field.checkAlreadyHit(x, y)){
                    System.out.println("The coordinates are already hit by you ! \nChoose some other coordinates\n");
                }
                else{
                    //if player misses the ship
                    if(field.checkShipOnGrid(x, y) == null){
                        field.field[x][y].hit = true;
                        player.setTurns(player.getTurns()-1);//decrement turn
                        System.out.println("You missed the shot !!");
                    }
                    //if player hits the ship
                    else{
                        ship = field.checkShipOnGrid(x, y);
                        field.hitShip(x, y);
                        player.setPoints(ship.points + this.player.getPoints());//add points
                        player.setTurns(player.getTurns()-1);
                        System.out.println("HIT THE TARGET !!");
                        System.out.println("Ship: " + ship.name + ",   Points: " + ship.points);
                        ship = null;
                    }
                }
            }
            else{
                System.out.println("Not valid coordinates !!");
            }
            //show game details
            if(player.getPoints() == 30){
                System.out.println("You won the Game !!");
                System.out.println("Your Score: " + player.getPoints());
                System.out.println("Your Turns Remaining: " + player.getTurns());
                break;
            }
            else{
                System.out.println("Player Name: " + player.getName() + ",  Turns Left: " + player.getTurns() + ",  Points: " + player.getPoints());
            }
        }
        if(player.getTurns() == 0){
            System.out.println("You lost the game !!");
        }

        //ship hits reset for next turn
        Ship.AIRCRAFT.hit = false;
        Ship.BATTLESHIP.hit = false;
        Ship.DESTROYER.hit = false;
        Ship.SUBMARINE.hit = false;
        Ship.PATROL.hit = false;

    }
    
  

    //for debug mode
    public void debugMode(Field field){
        Vector<Coordinates> aircraftCoord = new Vector<Coordinates>(5);
        Vector<Coordinates> battleshipCoord = new Vector<Coordinates>(4);
        Vector<Coordinates> submarineCoord = new Vector<Coordinates>(3);
        Vector<Coordinates> destroyerCoord = new Vector<Coordinates>(2);
        Vector<Coordinates> patrolCoord = new Vector<Coordinates>(1);

        //debug mode coordinates
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(field.field[i][j].ship != null) {
                    if (field.field[i][j].ship.name.equalsIgnoreCase("Aircraft Carrier")) {
                        Coordinates xy = new Coordinates(i, j);
                        aircraftCoord.add(xy);
                    } else if (field.field[i][j].ship.name.equalsIgnoreCase("Battleship")) {
                        Coordinates xy = new Coordinates(i, j);
                        battleshipCoord.add(xy);
                    } else if (field.field[i][j].ship.name.equalsIgnoreCase("Submarine")) {
                        Coordinates xy = new Coordinates(i, j);
                        submarineCoord.add(xy);
                    } else if (field.field[i][j].ship.name.equalsIgnoreCase("Destroyer")) {
                        Coordinates xy = new Coordinates(i, j);
                        destroyerCoord.add(xy);
                    } else if (field.field[i][j].ship.name.equalsIgnoreCase("Patrol Boat")) {
                        Coordinates xy = new Coordinates(i, j);
                        patrolCoord.add(xy);
                    }
                }
            }
        }

        //print out for debug mode
        System.out.println("FOR DEBUG MODE SHIP POSITIONS");

        System.out.print("Aircraft Carrier     ");
        for(int i=0; i<aircraftCoord.size(); i++){
            System.out.print("(" + aircraftCoord.get(i).x + "," + aircraftCoord.get(i).y + ")");
        }
        System.out.println();
        System.out.print("Battleship           ");
        for(int i=0; i<battleshipCoord.size(); i++){
            System.out.print("(" + battleshipCoord.get(i).x + "," + battleshipCoord.get(i).y + ")");
        }
        System.out.println();
        System.out.print("Submarine            ");
        for(int i=0; i<submarineCoord.size(); i++){
            System.out.print("(" + submarineCoord.get(i).x + "," + submarineCoord.get(i).y + ")");
        }
        System.out.println();
        System.out.print("Destroyer            ");
        for(int i=0; i<destroyerCoord.size(); i++){
            System.out.print("(" + destroyerCoord.get(i).x + "," + destroyerCoord.get(i).y + ")");
        }
        System.out.println();
        System.out.print("Patrol               ");
        for(int i=0; i<patrolCoord.size(); i++){
            System.out.print("(" + patrolCoord.get(i).x + "," + patrolCoord.get(i).y + ")");
        }
        System.out.println();

    }
  //storing coordinates for debug mode
    class Coordinates{
        int x;
        int y;

        Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
