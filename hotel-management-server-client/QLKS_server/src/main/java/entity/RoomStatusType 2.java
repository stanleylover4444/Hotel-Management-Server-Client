package entity;

import java.util.Objects;

public class RoomStatusType {
    private String roomStatusTypeID;
    private String roomStatusTypeName;

    public RoomStatusType() {
    }

    public RoomStatusType(String roomStatusTypeID, String roomStatusTypeName) {
        this.roomStatusTypeID = roomStatusTypeID;
        this.roomStatusTypeName = roomStatusTypeName;
    }

    public String getRoomStatusTypeID() {
        return roomStatusTypeID;
    }

    public void setRoomStatusTypeID(String roomStatusTypeID) {
        this.roomStatusTypeID = roomStatusTypeID;
    }

    public String getRoomStatusTypeName() {
        return roomStatusTypeName;
    }

    public void setRoomStatusTypeName(String roomStatusTypeName) {
        this.roomStatusTypeName = roomStatusTypeName;
    }

    @Override
    public String toString() {
        return "RoomStatusType{" + "roomStatusTypeID=" + roomStatusTypeID + ", roomStatusTypeName=" + roomStatusTypeName + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.roomStatusTypeID);
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
        final RoomStatusType other = (RoomStatusType) obj;
        return Objects.equals(this.roomStatusTypeID, other.roomStatusTypeID);
    }
    
}
