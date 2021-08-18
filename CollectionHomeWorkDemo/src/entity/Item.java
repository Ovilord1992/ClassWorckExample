package entity;

import entity.enums.MeasureType;

public class Item extends AbstractEntity {


    private String name;

    private MeasureType measureType;

    private int count;

    private int price;

    private int summ;

    public Item(long id, String name, MeasureType measureType, int count, int price) {
        setId(id);
        this.name = name;
        this.measureType = measureType;
        this.count = count;
        this.price = price;
        this.summ = price * count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", measureType=" + measureType +
                ", count=" + count +
                ", price=" + price +
                ", summ=" + summ +
                '}';
    }
}
