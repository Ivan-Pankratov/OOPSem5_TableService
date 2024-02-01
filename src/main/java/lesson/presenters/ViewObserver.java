package lesson.presenters;

import java.util.Date;

/**
 * Наблюдатель за представлением
 */
public interface ViewObserver {
    /**
     * Запрос на резерв столика
     *
     * @param orderDate   дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    void onReservationTable(Date orderDate, int tableNo, String name);


    /**
     * Запрос изменения брони столика
     *
     * @param oldReservation  предыдущий номер брони
     * @param reservationDate новая дата брони
     * @param tableNo     новый номер столика
     * @param name     имя клиента
     */
    void onUpdateReservetionTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
