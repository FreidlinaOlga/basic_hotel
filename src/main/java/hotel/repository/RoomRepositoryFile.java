package hotel.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotel.domain.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomRepositoryFile implements RoomRepository {
    private File database;
    private ObjectMapper mapper;
    private long currentId;


    private void getMaxId() {
        List<Room> rooms = findAllRooms();
        if (!rooms.isEmpty()) {
            Room lastRoom = rooms.get(rooms.size() - 1);
            currentId = lastRoom.getId();
        }
    }

    public RoomRepositoryFile() {
        database = new File("room_db.txt");
        mapper = new ObjectMapper();

        try {
            database.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getMaxId();
    }

    @Override
    public Room saveRoom(Room room) {
        List<Room> rooms = findAllRooms();
        room.setId(++currentId);
        room.setAvailable(true);
        rooms.add(room);
        try {
            mapper.writeValue(database, rooms);
            return room;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Room> findAllRooms() {
        try {
            Room[] rooms = mapper.readValue(database, Room[].class);
            List<Room> result = new ArrayList<>();
            Collections.addAll(result, rooms);
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Room findRoomById(long id) {
        return findAllRooms()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteRoomById(long id) {
        List<Room> rooms = findAllRooms();
        rooms
                .stream()
                .filter(x -> x.getId() == id)
                .limit(1)
                .forEach(x -> x.setAvailable(false));
        try {
            mapper.writeValue(database, rooms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void restoreRoomById(long id) {
        try {
            // Читаем содержимое файла в объект типа List<Room>
            List<Room> rooms = mapper.readValue(new File("room_db.txt"), new TypeReference<>() {});

            // Находим комнату по ID и изменяем ее состояние
            Room room = rooms.stream()
                    .filter(r -> r.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (room != null && !room.isAvailable()) {
                room.setAvailable(true); // Или другое действие для восстановления

                // Записываем обновленный список комнат в файл
            mapper.writeValue(new File("room_db.txt"), rooms);
            }
        } catch (IOException e) {
            // Обработка исключения при чтении/записи файла
            e.printStackTrace();
        }
    }
}

