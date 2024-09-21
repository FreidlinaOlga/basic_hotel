package hotel.controller;

import hotel.domain.Room;
import hotel.srevice.RoomService;

import java.util.List;

public class RoomController {
    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;


    }

    public List<Room> getAllAvailableRooms() {
        return service.getAllAvailableRooms();
    }

    public Room saveRoom(double price, int number, String roomType) {
        return service.save(price, number, roomType );
    }

    public void deleteRoomBeId(long id) {
        service.deleteRoomById(id);
    }

    public void restoreRoomById(long id) {
        service.restoreRoomById(id);
    }
}
