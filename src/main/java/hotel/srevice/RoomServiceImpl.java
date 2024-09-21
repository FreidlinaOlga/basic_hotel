package hotel.srevice;

import hotel.domain.Room;
import hotel.repository.RoomRepository;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room save(double price, int roomNumber, String roomType) {
        Room room = new Room(price, roomNumber, roomType);
        repository.saveRoom(room);
        return room;
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        return repository.findAllRooms()
                .stream()
                .filter(Room::isAvailable)
                .toList();

    }

    @Override
    public void deleteRoomById(long id) {
        repository.deleteRoomById(id);

    }


    @Override
   public Room restoreRoomById(long id) {
        Room room = repository.findRoomById(id);
        if (room != null && !room.isAvailable()) {
            repository.restoreRoomById(room.getId());


        }
        return room;
    }
}