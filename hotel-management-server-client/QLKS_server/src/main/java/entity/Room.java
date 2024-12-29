package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
public class Room implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "roomID")
    private String roomID;

    @Column(name = "roomName")
    private String roomName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomTypeID")
    private RoomType roomType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomStatusTypeID")
    private RoomStatusType roomStatusType;

    @Column(name = "describe")
    private String description;

    public Room() {
    }

    public Room(String roomID, String roomName, RoomType roomType, RoomStatusType roomStatusType, String description) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomStatusType = roomStatusType;
        this.description = description;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatusType getRoomStatusType() {
        return roomStatusType;
    }

    public void setRoomStatusType(RoomStatusType roomStatusType) {
        this.roomStatusType = roomStatusType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomType=" + roomType +
                ", roomStatusType=" + roomStatusType +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Room other = (Room) obj;
        return Objects.equals(roomID, other.roomID);
    }
}