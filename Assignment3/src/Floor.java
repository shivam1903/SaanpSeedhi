public class Floor{
    private String type;
    private int level;
    private int points;

    public void setDetails(String type, int level, int points){
        this.type = type;
        this.level = level;
        this.points = points;
    }

    public void updateLevel(int increase){
        level = level + increase;
    }

    public int getLevel(){
        return level;
    }

    public String getType(){
        return type;
    }

    public int getPoints(){
        return points;
    }
}