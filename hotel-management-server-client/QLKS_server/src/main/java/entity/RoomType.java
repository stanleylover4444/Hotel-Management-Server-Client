package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RoomType")
public class RoomType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "roomTypeID")
    private String roomTypeID;

    @Column(name = "roomTypeName")
    private String roomTypeName;

    @Column(name = "price")
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
        return "RoomType{" +
                "roomTypeID='" + roomTypeID + '\'' +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomTypeID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoomType other = (RoomType) obj;
        return Objects.equals(roomTypeID, other.roomTypeID);
    }
}