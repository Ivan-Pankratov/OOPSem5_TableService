package lesson;
import lesson.models.TableService;
import lesson.presenters.BookingPresenter;
import lesson.presenters.Model;
import lesson.views.BookingView;

import java.util.Date;

public class Program {


    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();

        BookingPresenter presenter = new BookingPresenter(view, model);
        presenter.updateTablesView();

        view.reservationTable(new Date(), 2, "Станислав");
        view.changeReservationTable(1001, new Date(), 4, "Станислав");
    }

}
