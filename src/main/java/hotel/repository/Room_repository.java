package hotel.repository;

import hotel.domain.Room;

import java.util.List;

public interface Room_repository {
Room saveRoom(Room room);
List<Room> findAllRooms();
Room findRoomById(long id);
void deleteRoomById(long id);

}
