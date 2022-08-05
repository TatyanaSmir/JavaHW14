package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public Ticket(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.from = departure;
        this.to = arrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return from;
    }

    public void setDeparture(String departure) {
        this.from = departure;
    }

    public String getArrival() {
        return to;
    }

    public void setArrival(String arrival) {
        this.to = arrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
