public class Elevator extends Floor{
    private Floor jumpedTo;

    public void setJumpedTo(Floor jumpedTo){
        this.jumpedTo = jumpedTo;
    }

    public Floor getNewFloor(){
        return jumpedTo;
    }
}