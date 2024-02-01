package lesson.models;

import lesson.models.Table;

import java.util.Date;

/**
 * Модель процесса резервирование столика
 */
public class Reservation {
    /**
     * счетчик для резервирований
     */
    private static int counter = 1000;

    /**
     * Номер резервирования
     */
    private int id;

    /**
     * Дата, на когда нужен столик
     */
    private Date date;
    /**
     * Имя, на кого сделана бронь
     */
    private String name;
    /**
     * Сам столик - предмет резервирования
     */
    private Table table;

    public Reservation(Table table, Date date, String name) {
        id = ++counter;
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }
}