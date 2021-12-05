import java.util.Scanner;
import java.util.ArrayList;

public class A3{

    private static ArrayList<Floor> floor_list = new ArrayList<Floor>();

    public static void main(String[] args){

        Floor f0 = new Floor();
        f0.setDetails("Empty", 0, 1);
        floor_list.add(f0);

        Floor f1 = new Floor();
        f1.setDetails("Empty", 1, 1);
        floor_list.add(f1);

        Elevator f2 = new Elevator();
        f2.setDetails("Elevator", 2, 4);
        floor_list.add(f2);

        Floor f3 = new Floor();
        f3.setDetails("Empty", 3, 1);
        floor_list.add(f3);

        Floor f4 = new Floor();
        f4.setDetails("Empty", 4, 1);
        floor_list.add(f4);

        Snake f5 = new Snake();
        f5.setDetails("Snake", 5, -2);
        floor_list.add(f5);

        Floor f6 = new Floor();
        f6.setDetails("Empty", 6,1);
        floor_list.add(f6);

        Floor f7 = new Floor();
        f7.setDetails("Empty", 7,1);
        floor_list.add(f7);

        Ladder f8 = new Ladder();
        f8.setDetails("Ladder", 8, 2);
        floor_list.add(f8);

        Floor f9 = new Floor();
        f9.setDetails("Empty", 9, 1);
        floor_list.add(f9);

        Floor f10 = new Floor();
        f10.setDetails("Empty", 10, 1);
        floor_list.add(f10);

        Cobra f11 = new Cobra();
        f11.setDetails("Cobra", 11, -4);
        floor_list.add(f11);

        Floor f12 = new Floor();
        f12.setDetails("Empty", 12, 1);
        floor_list.add(f12);

        Floor f13 = new Floor();
        f13.setDetails("Empty", 13, 1);
        floor_list.add(f13);

        f2.setJumpedTo(f10);
        f5.setJumpedTo(f1);
        f8.setJumpedTo(f12);
        f11.setJumpedTo(f3);



        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player name and hit enter");
        String name = sc.nextLine();
        Player p = new Player();
        p.setName(name);
        System.out.println("The Game Setup is ready for " + p.getName());
        System.out.print("Hit enter to roll the dice");
        sc.nextLine();
        Dice initial = new Dice(2);
        int start = initial.getFaceValue();
        while (start!= 1){
            System.out.println("Dice gave 2");
            System.out.println("Game cannot start until dice shows 1");
            System.out.print("Hit enter to roll the dice");
            sc.nextLine();
            Dice d = new Dice(2);
            start = d.getFaceValue();
        }
        p.setFloor(f0);
        p.addPoints(f0.getPoints());
        System.out.println("The dice gave 1 and the game has started");
        p.printDeets();



        while (p.getLevel() != 13){


            System.out.print("Hit enter to move forward");
            sc.nextLine();
            Dice d = new Dice(2);
            int output = d.getFaceValue();
            System.out.println("Dice Gave : " + output);
            int lev = p.getLevel() + output;
            if (lev <= 13) {
                p.setFloor(floor_list.get(lev));
                p.addPoints(floor_list.get(lev).getPoints());
                p.printDeets();
                String typ = p.getFloor().getType();
                if (!(typ.equals("Empty"))) {
                    if (typ.equals("Elevator")) {
                        p.setFloor(f2.getNewFloor());
                        p.addPoints(f2.getNewFloor().getPoints());
                        p.printDeets();
                    } else if (typ.equals("Ladder")) {
                        p.setFloor(f8.getNewFloor());
                        p.addPoints(f8.getNewFloor().getPoints());
                        p.printDeets();
                    } else if (typ.equals("Snake")) {
                        p.setFloor(f5.getNewFloor());
                        p.addPoints(f5.getNewFloor().getPoints());
                        p.printDeets();
                    } else if (typ.equals("Cobra")) {
                        p.setFloor(f11.getNewFloor());
                        p.addPoints(f11.getNewFloor().getPoints());
                        p.printDeets();
                    }
                }
            }
            else{

                System.out.println("Player cannot move");
            }
            System.out.println("  ");
            System.out.println("-----------------------------------");
            System.out.println("  ");

        }
        System.out.println(p.getName() + " has reached the top and won");
        System.out.println(p.getName() + " has accumulated " + p.getPoints() + " points");
    }
}