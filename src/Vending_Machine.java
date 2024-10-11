import java.util.*;

public class Vending_Machine {
    public static void main(String[] args) {
        List<Coffee> coffeeAssortment = new ArrayList<>();
        coffeeAssortment.add(new Coffee(0, "Cappuccino", 320, 100));
        coffeeAssortment.add(new Coffee(0, "Espresso", 200, 100));
        coffeeAssortment.add(new Coffee(0, "Americano", 250, 150));
        coffeeAssortment.add(new Coffee(0, "Latte", 300, 200));
        coffeeAssortment.add(new Coffee(0, "Mocha", 400, 250));
        coffeeAssortment.add(new Coffee(0, "Flat", 350, 150));
        coffeeAssortment.add(new Coffee(0, "Brew", 450, 100));
        coffeeAssortment.add(new Coffee(0, "Iced", 370, 200));

        float minPrice = 0;


        System.out.println("\nЗдравствуйте, сегодня у нас для вас есть широкий ассортимент вкусного и горячего кофе: \n");

        for (Coffee coffee : coffeeAssortment) {
            System.out.println(coffee);
        }
        List<Float> minMoney = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (Coffee price : coffeeAssortment) {
            minMoney.add(price.getPrice());
        }
        float moneyAmount = Collections.min(minMoney);
        boolean sail = false;
        while (!sail) {
            System.out.print("\nВведите денежную сумму -> ");
            moneyAmount = scanner.nextInt();
            for (int i = 0; i < coffeeAssortment.size(); i++) {
                if (moneyAmount < minPrice) {
                    System.out.println("Этой суммы недостаточно!");
                    break;
                } else {
                    sail = true;
                }
            }
        }
        boolean numberCoffee = false;
        int choiceOfNumber;
        float theRestOfTheMoney = 0;
        while (!numberCoffee) {
            System.out.println("Выбирите номер желаемого кофе -> ");
            choiceOfNumber = scanner.nextInt();
            for (int i = 0; i < coffeeAssortment.size(); i++) {
                if (choiceOfNumber < 1 || choiceOfNumber > coffeeAssortment.size()) {
                    System.out.println("Неверно набран номер!");
                    break;
                } else if (choiceOfNumber == coffeeAssortment.get(i).getId()) {
                    if (moneyAmount > coffeeAssortment.get(i).getPrice()) {
                        theRestOfTheMoney = moneyAmount - coffeeAssortment.get(i).getPrice();
                    }
                    System.out.println("Возьмите ваш кофе №" + " " + coffeeAssortment.get(i) + "\n");
                    System.out.println("Ваша сдача: " + theRestOfTheMoney);

                    numberCoffee = true;
                }
            }
        }


    }
}
