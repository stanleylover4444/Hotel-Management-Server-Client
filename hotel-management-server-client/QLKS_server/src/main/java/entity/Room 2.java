
package entity;

import java.util.Objects;

public class Room {
    private String roomID;
    private String roomName;
    private RoomType roomType;
    private RoomStatusType roomStatusType;
    private String describe;

    public Room() {
    }

    public Room(String roomID, String roomName, RoomType roomType, RoomStatusType roomStatusType, String describe) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomStatusType = roomStatusType;
        this.describe = describe;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    
    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomName=" + roomName + ", roomType=" + roomType + ", roomStatusType=" + roomStatusType + ", describe=" + describe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.roomID);
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
        final Room other = (Room) obj;
        return Objects.equals(this.roomID, other.roomID);
    }
    
}
