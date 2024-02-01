package lesson.models;

import lesson.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    /**
     * Создание коллекции столиков
     * @return список столиков
     */
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Резервирование (с добавлением резервирования в массив)
     * @param reservationDate дата резервирования
     * @param tableNo     номер столика зарезервированного
     * @param name     имя клиента который зарезервировал столик
     * @return номер бронирования
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * TODO: Разработать самостоятельно
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {

        int res = reservationTable(reservationDate, tableNo, name);
        if (res>0) {
            for (Table table : tables) {
                for (Reservation reservation : table.getReservations()) {
                    if (reservation.getId() == oldReservation) {
                        reservation.setTable(null);
                        return res;
                    }
                }
            }
        }
        throw new RuntimeException("Ошибка изменения бронирования.");
    }

}
