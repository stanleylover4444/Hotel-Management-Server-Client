package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RoomStatusType")
public class RoomStatusType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "roomStatusTypeID")
    private String roomStatusTypeID;

    @Column(name = "roomStatusTypeName")
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
        return "RoomStatusType{" +
                "roomStatusTypeID='" + roomStatusTypeID + '\'' +
                ", roomStatusTypeName='" + roomStatusTypeName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomStatusTypeID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoomStatusType other = (RoomStatusType) obj;
        return Objects.equals(roomStatusTypeID, other.roomStatusTypeID);
    }
}