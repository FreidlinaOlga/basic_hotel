package hotel.domain;

import java.util.Objects;

public class Room {
    private long id;
    private boolean isAvailable;
    private double price;
    private int roomNumber;
    private String roomType;

    public Room() {
    }

    public Room( double price, int roomNumber, String roomType) {

        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public Room(long id, boolean isAvailable, double price, String roomType, int roomNumber) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.price = price;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    public Room(long id, boolean isAvailable, double price) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public Room(long id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && isAvailable == room.isAvailable && Double.compare(price, room.price) == 0 && roomNumber == room.roomNumber && Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAvailable, price, roomNumber, roomType);
    }

    @Override
    public String toString() {
        return String.format("Room: number - %d, id - %d, isAvailable - %s, price - %.2f," +
                        " room type - %s ",roomNumber, id, isAvailable ? "yes" : "no", price, roomType);
    }
}