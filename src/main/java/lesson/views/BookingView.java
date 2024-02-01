package lesson.views;

import lesson.presenters.View;
import lesson.presenters.ViewObserver;
import lesson.models.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Класс вывода информации в консоль
 */
public class BookingView implements View {

    private Collection<ViewObserver> observers;

    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    /**
     * Вывод списка столиков
     * @param tables список столиков
     */
    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    /**
     * Ввывод результата бронирования столика
     * @param reservationNo номер брони
     */
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка при попытке забронировать столик.\n Повторите операцию позже.");
        }
    }

    /**
     * Вывод результата изменения бронирования
     * @param reservationNo номер брони
     */
    @Override
    public void showChangeReservationTable(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf(
                    "Изменение прошло успешно. Новый номер брони №%d\n", reservationNo);
        } else {
            System.out.println("Произошла ошибка при попытке изменения брони.\n " +
                    "Проверьте правильность ввода данных. \n" +
                    "Если всё верно, пожалуйста, повторите операцию позже.");
        }
    }


    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null)
            for (ViewObserver observer : observers){
                observer.onReservationTable(orderDate, tableNo, name);
            }
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){

        if (observers != null)
            for (ViewObserver observer : observers){
                observer.onUpdateReservetionTable(oldReservation, reservationDate, tableNo, name);
            }
    }
}