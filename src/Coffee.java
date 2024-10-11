public class Coffee {
    private String name;
    private float price;
    private int volume;
    private int id;
    private static int count = 1;

    public Coffee(int id, String name, float price, int volume) {

        this.name = name;
        this.price = price;
        this.volume = volume;
        this.id = getCount(count);
        count++;
    }

    public int getCount(int count) {
        return count;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " цена: " + price + " объём: " + volume;
    }
}
