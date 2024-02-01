package lesson.presenters;

import java.util.Date;

/**
 * Класс взаимодействия модели с представлением,
 * т.е.с выводом в консоль
 */
public class BookingPresenter implements ViewObserver {

    private View view;
    private Model model;

    public BookingPresenter(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.registerObserver(this);
    }

    /**
     * Отобразить список столиков ("в консоль")
     */
    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    /**
     * Вывод номера резервирования
     * @param reservationNo номер резервирования
     */
    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    /**
     * Метод резервирования
     * @param orderDate   дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try
        {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }

    }

    /**
     * Метод изменения резервирования в модели
     *
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    @Override
    public void onUpdateReservetionTable(int oldReservation, Date reservationDate, int tableNo,
                                         String name) {
        try {
            int newReservationNumber = model.changeReservationTable(oldReservation, reservationDate, tableNo,
                    name);
            view.showChangeReservationTable(newReservationNumber);
        } catch (RuntimeException e) {
            view.showChangeReservationTable(-1);
        }
    }

}