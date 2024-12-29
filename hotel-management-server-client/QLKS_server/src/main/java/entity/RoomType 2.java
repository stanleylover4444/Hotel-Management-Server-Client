package entity;

import java.util.Objects;

public class RoomType {
    private String roomTypeID;
    private String roomTypeName;
    private double price;

    public RoomType() {
    }

    public RoomType(String roomTypeID, String roomTypeName, double price) {
        this.roomTypeID = roomTypeID;
        this.roomTypeName = roomTypeName;
        this.price = price;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomType{" + "roomTypeID=" + roomTypeID + ", roomTypeName=" + roomTypeName + ", price=" + price + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.roomTypeID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoomType other = (RoomType) obj;
        return Objects.equals(this.roomTypeID, other.roomTypeID);
    }
    
}
