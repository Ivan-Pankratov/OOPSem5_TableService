package lesson.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Клас описывает модель столик
 */
public class Table {
    /**
     * Счётчик
     */
    private static int counter;
    /**
     * номер столика (задаётся при помощи счётчика)
     */
    private int no;

    /**
     * Коллекция для хранения истории резервирования этого столика
     */
    private Collection<Reservation> reservations = new ArrayList<>();

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    /**
     * конструктор класса
     */
    public Table(){
        no = ++counter;
    }

    /**
     * Вывод информации о столике
     * @return номер столика
     */
    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }

}
