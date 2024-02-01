package lesson.presenters;

import lesson.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс взаимодействия с представлениями
 */
public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo);

    /**
     * Отобразить результат изменения бронирования столика
     * @param reservationNo номер брони
     */
    void showChangeReservationTable(int reservationNo);

    /**
     * Установить наблюдателя за представлением
     * @param observer наблюдатель
     */
    void registerObserver(ViewObserver observer);


}
