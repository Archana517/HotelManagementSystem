package model;

public class Reservation {
    private int id;
    private String name;
    private String room;
    private String checkIn;
    private String checkOut;
    private double amount;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }

    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}