package hotel.srevice;

import hotel.domain.Room;

import java.util.List;

public interface RoomService {
    Room save (double price,int roomNumber,String roomType);
    List<Room> getAllAvailableRooms();
    void deleteRoomById (long id);

    Room restoreRoomById(long id);

}
