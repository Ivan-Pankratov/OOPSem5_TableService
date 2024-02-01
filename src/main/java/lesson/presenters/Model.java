package lesson.presenters;

import lesson.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс взаимодействия с моделями
 */
public interface Model {

    /**
     * Зпарос на список столиков из модели
     * @return список столиков
     */
    Collection<Table> loadTables();

    /**
     * Резервирование столиков в модели
     *
     * @param reservationDate дата резервирования
     * @param tableNo     номер столика зарезервированного
     * @param name     имя клиента который зарезервировал столик
     * @return номер резервирования
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение брони столика (Поступил запрос на изменение резерва)
     *
     * @param oldReservation  предыдущее резервирование столика
     * @param reservationDate новая дата резервировния
     * @param tableNo     номер столика
     * @param name     имя клиента
     * @return новый номер резервировния
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
