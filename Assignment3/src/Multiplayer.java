import java.util.Scanner;
import java.util.ArrayList;

public class Multiplayer{

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

        System.out.println("Enter the player 1 name and hit enter");
        String name = sc.nextLine();
        Player p1 = new Player();
        p1.setName(name);
        System.out.println("Enter the player 2 name and hit enter");
        String new_name = sc.nextLine();
        Player p2 = new Player();
        p2.setName(new_name);
        System.out.println("The Game Setup is ready for " + p1.getName() + " And " + p2.getName());
        System.out.print("Hit enter to roll the dice for " + p1.getName());
        sc.nextLine();
        int second_start = 0;
        Dice initial = new Dice(2);
        int start = initial.getFaceValue();
        if (start != 1) {
            System.out.println("Dice gave 2");
            System.out.println("Game cannot start until dice shows 1 for " + p1.getName());
            System.out.print("Hit enter to roll the dice for " + p2.getName());
            sc.nextLine();
            second_start = initial.getFaceValue();
            if (second_start != 1) {
                System.out.println("Dice gave 2");
                System.out.println("Game cannot start until dice shows 1 for " + p2.getName());
                while ((start != 1) && (second_start != 1)) {

                    System.out.print("Hit enter to roll the dice for " + p1.getName());
                    sc.nextLine();
                    Dice d = new Dice(2);
                    start = d.getFaceValue();
                    if (start == 1){
                        p1.setFloor(f0);
                        p1.addPoints(f0.getPoints());
                        System.out.println("The dice gave 1 and the game has started for " + p1.getName());
                        p1.printDeets();
                        break;
                    }
                    else{
                        System.out.println("Dice gave 2");
                        System.out.println("Game cannot start until dice shows 1 for " + p1.getName());
                        System.out.print("Hit enter to roll the dice for " + p2.getName());
                        sc.nextLine();
                        second_start = d.getFaceValue();
                        if (second_start == 1){
                            p2.setFloor(f0);
                            p2.addPoints(f0.getPoints());
                            System.out.println("The dice gave 1 and the game has started " + p2.getName());
                            p2.printDeets();
                            break;
                        }
                        else{
                            System.out.println("Dice gave 2");
                            System.out.println("Game cannot start until dice shows 1 for " + p2.getName());
                        }
                    }

                }

            }
            else if(second_start == 1){
                p2.setFloor(f0);
                p2.addPoints(f0.getPoints());
                System.out.println("The dice gave 1 and the game has started for " + p2.getName());
                p2.printDeets();
            }
        }
        else if (start == 1) {
            p1.setFloor(f0);
            p1.addPoints(f0.getPoints());
            System.out.println("The dice gave 1 and the game has started for " + p1.getName());
            p1.printDeets();
        }
        int check = 0;
        while ((second_start != 1) && (p1.getLevel() != 13)){
            Dice d = new Dice(2);
            System.out.println("Game has not started for " + p2.getName());
            System.out.print("Hit enter to roll the dice for " + p2.getName());
            sc.nextLine();
            second_start = d.getFaceValue();
            if (second_start == 1){
                System.out.println("Dice Gave 1 and Game has started for " + p2.getName() + " as well");
                p2.setFloor(f0);
                p2.addPoints(f0.getPoints());
                p2.printDeets();

            }
            else{
                System.out.println("Dice gave 2");
                System.out.println("Game cannot start until dice shows 1 for " + p2.getName());
            }

            System.out.println("\n ------------------------ \n");

            System.out.print("Hit enter to move forward for " + p1.getName());
            sc.nextLine();

            int output = d.getFaceValue();
            System.out.println("Dice Gave : " + output);
            int lev_1 = p1.getLevel() + output;
            if (lev_1 <= 13) {
                p1.setFloor(floor_list.get(lev_1));
                p1.addPoints(floor_list.get(lev_1).getPoints());
                p1.printDeets();
                String typ = p1.getFloor().getType();
                if (!(typ.equals("Empty"))) {
                    if (typ.equals("Elevator")) {
                        p1.setFloor(f2.getNewFloor());
                        p1.addPoints(f2.getNewFloor().getPoints());
                        p1.printDeets();
                    } else if (typ.equals("Ladder")) {
                        p1.setFloor(f8.getNewFloor());
                        p1.addPoints(f8.getNewFloor().getPoints());
                        p1.printDeets();
                    } else if (typ.equals("Snake")) {
                        p1.setFloor(f5.getNewFloor());
                        p1.addPoints(f5.getNewFloor().getPoints());
                        p1.printDeets();
                    } else if (typ.equals("Cobra")) {
                        p1.setFloor(f11.getNewFloor());
                        p1.addPoints(f11.getNewFloor().getPoints());
                        p1.printDeets();
                    }
                }
            }
            else{

                System.out.println(p1.getName() + " cannot move");
            }
            check = 2;

            System.out.println("  ");
            System.out.println("-----------------------------------");
            System.out.println("  ");

        }

        while ((start != 1) && (p2.getLevel() != 13)){
            Dice d = new Dice(2);
            System.out.println("Game has not started for " + p1.getName());
            System.out.print("Hit enter to roll the dice for " + p1.getName());
            sc.nextLine();
            start = d.getFaceValue();
            if (start == 1){
                System.out.println("Dice Gave 1 and Game has started for " + p1.getName() + " as well");
                p1.setFloor(f0);
                p1.addPoints(f0.getPoints());
                p1.printDeets();


            }
            else{
                System.out.println("Dice gave 2");
                System.out.println("Game cannot start until dice shows 1 for " + p1.getName());
            }

            System.out.println("\n ------------------------ \n");

            System.out.print("Hit enter to move forward for " + p2.getName());
            sc.nextLine();

            int output = d.getFaceValue();
            System.out.println("Dice Gave : " + output);
            int lev_2 = p2.getLevel() + output;
            if (lev_2 <= 13) {
                p2.setFloor(floor_list.get(lev_2));
                p2.addPoints(floor_list.get(lev_2).getPoints());
                p2.printDeets();
                String typ = p1.getFloor().getType();
                if (!(typ.equals("Empty"))) {
                    if (typ.equals("Elevator")) {
                        p2.setFloor(f2.getNewFloor());
                        p2.addPoints(f2.getNewFloor().getPoints());
                        p2.printDeets();
                    } else if (typ.equals("Ladder")) {
                        p2.setFloor(f8.getNewFloor());
                        p2.addPoints(f8.getNewFloor().getPoints());
                        p2.printDeets();
                    } else if (typ.equals("Snake")) {
                        p2.setFloor(f5.getNewFloor());
                        p2.addPoints(f5.getNewFloor().getPoints());
                        p2.printDeets();
                    } else if (typ.equals("Cobra")) {
                        p2.setFloor(f11.getNewFloor());
                        p2.addPoints(f11.getNewFloor().getPoints());
                        p2.printDeets();
                    }
                }
            }
            else{

                System.out.println(p2.getName() + " cannot move");
            }



            System.out.println("  ");
            System.out.println("-----------------------------------");
            System.out.println("  ");
            check = 1;
        }

        while ((p1.getLevel() != 13) && (p2.getLevel() != 13)){

            Player pi = p1;
            Player ps = p2;

            if (check == 2){
                pi = p2;
                ps = p1;
            }
            System.out.print("Hit enter to move forward for " + pi.getName());
            sc.nextLine();
            Dice d = new Dice(2);
            int output = d.getFaceValue();
            System.out.println("Dice Gave : " + output);
            int lev_1 = pi.getLevel() + output;
            if (lev_1 <= 13) {
                pi.setFloor(floor_list.get(lev_1));
                pi.addPoints(floor_list.get(lev_1).getPoints());
                pi.printDeets();
                if (lev_1 ==13){
                    break;
                }
                String typ = pi.getFloor().getType();
                if (!(typ.equals("Empty"))) {
                    if (typ.equals("Elevator")) {
                        pi.setFloor(f2.getNewFloor());
                        pi.addPoints(f2.getNewFloor().getPoints());
                        pi.printDeets();
                    } else if (typ.equals("Ladder")) {
                        pi.setFloor(f8.getNewFloor());
                        pi.addPoints(f8.getNewFloor().getPoints());
                        pi.printDeets();
                    } else if (typ.equals("Snake")) {
                        pi.setFloor(f5.getNewFloor());
                        pi.addPoints(f5.getNewFloor().getPoints());
                        pi.printDeets();
                    } else if (typ.equals("Cobra")) {
                        pi.setFloor(f11.getNewFloor());
                        pi.addPoints(f11.getNewFloor().getPoints());
                        pi.printDeets();
                    }
                }
            }
            else {

                System.out.println(pi.getName() + " cannot move");
            }

            System.out.println("\n ------------------------ \n");

            System.out.print("Hit enter to move forward for " + ps.getName());
            sc.nextLine();
            d = new Dice(2);
            output = d.getFaceValue();
            System.out.println("Dice Gave : " + output);
            int lev_2 = ps.getLevel() + output;
            if (lev_2 <= 13) {
                ps.setFloor(floor_list.get(lev_2));
                ps.addPoints(floor_list.get(lev_2).getPoints());
                ps.printDeets();
                if (lev_2 == 13){
                    break;
                }
                String typ = ps.getFloor().getType();
                if (!(typ.equals("Empty"))) {
                    if (typ.equals("Elevator")) {
                        ps.setFloor(f2.getNewFloor());
                        ps.addPoints(f2.getNewFloor().getPoints());
                        ps.printDeets();
                    } else if (typ.equals("Ladder")) {
                        ps.setFloor(f8.getNewFloor());
                        ps.addPoints(f8.getNewFloor().getPoints());
                        ps.printDeets();
                    } else if (typ.equals("Snake")) {
                        ps.setFloor(f5.getNewFloor());
                        ps.addPoints(f5.getNewFloor().getPoints());
                        ps.printDeets();
                    } else if (typ.equals("Cobra")) {
                        ps.setFloor(f11.getNewFloor());
                        ps.addPoints(f11.getNewFloor().getPoints());
                        ps.printDeets();
                    }
                }
            } else {
                System.out.println(ps.getName() + " cannot move");
            }


            System.out.println("\n ------------------------ \n");

        }

        System.out.println("\n ------------------------ \n");

        if (p1.getLevel() == 13){
            System.out.println(p1.getName() + " has reached the top and won according to time");
            System.out.println(p1.getName() + " has accumulated " + p1.getPoints() + " points");
            System.out.println(p2.getName() + " has accumulated " + p2.getPoints() + " points");

        }
        else if (p2.getLevel() == 13){
            System.out.println(p2.getName() + " has reached the top and won according to time");
            System.out.println(p2.getName() + " has accumulated " + p2.getPoints() + " points");
            System.out.println(p1.getName() + " has accumulated " + p1.getPoints() + " points");

        }

        if (p1.getPoints() < p2.getPoints()){
            System.out.println(p2.getName() + " has won the game in respect of points");
        }
        else if (p2.getPoints() < p1.getPoints()){
            System.out.println(p1.getName() + " has won the game in respect of points");
        }
        else {
            System.out.println("This is a tie according to points between both " + p1.getName() + " and " + p2.getName());
        }

    }
}