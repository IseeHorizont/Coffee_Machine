package machine;

import java.util.*;

public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int disposableCups = 9;
    public static int money = 550;
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
        }
    }

    public static void showMainMenu() {
        System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n");
        String command = scan.nextLine();
        switch (command) {

            case "exit":
                System.exit(0);
                break;

            case "remaining":
                printCapacityOfCoffeeMachine();
                break;

            case "buy":
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

                String whatCoffee = scan.nextLine();
                switch (whatCoffee) {
                    case "back":
                        showMainMenu();
                        break;

                    case "1":
                        // For the espresso needs 250 ml of water, 16 g of coffee beans. It costs $4.
                        if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                            water -= 250;
                            coffeeBeans -= 16;
                            disposableCups -= 1;
                            money += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (water < 250) {
                                System.out.println("Sorry, not enough water!");
                            } else if (coffeeBeans < 16) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        break;

                    case "2":
                        // For the latte needs 350 ml of water, 75 ml of milk, 20 g of coffee beans. It costs $7.
                        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                            water -= 350;
                            milk -= 75;
                            coffeeBeans -= 20;
                            disposableCups -= 1;
                            money += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (water < 350) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (coffeeBeans < 20) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        break;

                    case "3":
                        // For the cappuccino needs 200 ml of water, 100 ml of milk, 12 g of coffee beans. It costs $6.
                        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                            water -= 200;
                            milk -= 100;
                            coffeeBeans -= 12;
                            disposableCups -= 1;
                            money += 6;
                        } else {
                            if (water < 200) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (coffeeBeans < 12) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        break;

                    default:
                        System.out.println("Unknown kind of coffee");
                }
                break;

            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                int howAddWater = scan.nextInt();
                water += howAddWater;
                System.out.println("Write how many ml of milk do you want to add:");
                int howAddMilk = scan.nextInt();
                milk += howAddMilk;
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int howAddCoffeeBeans = scan.nextInt();
                coffeeBeans += howAddCoffeeBeans;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int howAddDisposableCups = scan.nextInt();
                disposableCups += howAddDisposableCups;
                break;

            case "take":
                System.out.printf("I gave you $%d", money);
                money = 0;
                break;

            default:
                System.out.println("Unknown command");
        }
    }

    private static void printCapacityOfCoffeeMachine() {
        System.out.printf("The coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n$%d of money\n", water, milk, coffeeBeans, disposableCups, money);
    }
}
