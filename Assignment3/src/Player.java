
public class Player{

    private String name;
    private Floor f;
    private int level;
    private int points = 0;

    public void setName(String name){
        this.name = name;
    }

    public void setFloor(Floor f){
        this.f = f;
        this.level = f.getLevel();
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public Floor getFloor(){
        return f;
    }

    public void addPoints(int inc){
        points = points + inc;
    }

    public void printDeets(){
        System.out.println(name + " Position Floor : " + level);
        System.out.println(name + " has reached the " + f.getType() + " Floor");
        System.out.println("Total Points for " + name + " : " + points);
    }

    public int getPoints(){
        return points;
    }
}