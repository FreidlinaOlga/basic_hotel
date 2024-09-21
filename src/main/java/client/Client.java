package client;

import hotel.controller.RoomController;
import hotel.domain.Room;
import hotel.repository.RoomRepository;
import hotel.repository.RoomRepositoryFile;
import hotel.srevice.RoomService;
import hotel.srevice.RoomServiceImpl;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        RoomRepository repository = new RoomRepositoryFile();
        RoomService service = new RoomServiceImpl(repository);
        RoomController controller = new RoomController(service);

        System.out.println("Список комнат: ");
        List<Room> rooms = controller.getAllAvailableRooms();

        // Сохраняем комнату
        controller.saveRoom(1200, 130,"single");
        controller.saveRoom(1100,99,"single");
        controller.saveRoom(1700, 115, "double");
        controller.saveRoom(1300, 79, "single");
//        System.out.println(rooms);
//        // Удалить комнату по ID

        System.out.println("Удалили комнату с ID 2");
        controller.deleteRoomBeId(2L);
        System.out.println(rooms);
//        System.out.println("Восстанавливаем комнату по ID 2");
//        controller.restoreRoomById(2L);
//        System.out.println(rooms); // работает








    }
}
