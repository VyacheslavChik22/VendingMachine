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

        float moneyAmount = 0;
        System.out.println("\nЗдравствуйте, сегодня у нас для вас есть широкий ассортимент вкусного и горячего кофе: \n");

        for (Coffee coffee : coffeeAssortment) {
            System.out.println(coffee);
        }
        List<Float> inMoney = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (Coffee price : coffeeAssortment) {
            inMoney.add(price.getPrice());
        }
        float minMoneyAmount = Collections.min(inMoney);
        boolean sail = false;
        while (!sail) {
            System.out.print("\nВведите денежную сумму -> ");
            moneyAmount = scanner.nextInt();
            for (int i = 0; i < coffeeAssortment.size(); i++) {
                if (moneyAmount < minMoneyAmount) {
                    System.out.println("Этой суммы недостаточно!\nВозьмите ваши " + moneyAmount);
                    break;
                } else {
                    sail = true;
                }
            }
        }
        boolean numberCoffee = false;
        int choiceOfNumber;
        float theRestOfTheMoney;
        while (!numberCoffee) {
            System.out.print("Выбирите номер желаемого кофе -> ");
            choiceOfNumber = scanner.nextInt();
            for (int i = 0; i < coffeeAssortment.size(); i++) {
                if (choiceOfNumber < 1 || choiceOfNumber > coffeeAssortment.size()) {
                    System.out.println("Неверно набран номер!");
                    break;
                }
                if(choiceOfNumber == coffeeAssortment.get(i).getId()
                        && moneyAmount < coffeeAssortment.get(i).getPrice()){
                    System.out.println("Недостаточная сумма для покупки кофе №_" + coffeeAssortment.get(i));
                }
                if(choiceOfNumber == coffeeAssortment.get(i).getId()
                        && moneyAmount >= coffeeAssortment.get(i).getPrice()) {
                    scanner.close();
                    theRestOfTheMoney = moneyAmount - coffeeAssortment.get(i).getPrice();
                    System.out.println("Возьмите ваш кофе №_" + coffeeAssortment.get(i) + "\n");
                    numberCoffee = true;
                    if(moneyAmount > coffeeAssortment.get(i).getPrice()) {
                        System.out.println("Ваша сдача: " + theRestOfTheMoney);
                    }
                }
            }
        }

    }
}
