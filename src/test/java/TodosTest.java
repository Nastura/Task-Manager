import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {

        SimpleTask simpleTask = new SimpleTask(1, "Работа");
        SimpleTask simpleTask2 = new SimpleTask(2, "Дом");
        SimpleTask simpleTask3 = new SimpleTask(3, "Учеба");

        String[] subtask = {"Купить молоко"};
        String[] subtask2 = {"Нарезать помидор"};
        String[] subtask3 = {"Купить сметану"};

        Epic epic = new Epic(1, subtask);
        Epic epic2 = new Epic(2, subtask2);
        Epic epic3 = new Epic(3, subtask3);

        Meeting taskOne = new Meeting(1, "Java", "Подсознание", "10 октября 2024 год");
        Meeting taskTwo = new Meeting(2, "Kotlin", "Мировоззрение", "10 ноября 2024 год");
        Meeting taskThree = new Meeting(3, "Rubi", "Подсознание", "10 декабря 2024 год");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(taskOne);
        todos.add(taskTwo);
        todos.add(taskThree);

        todos.search("Работа");
        todos.search("Купить молоко");
        todos.search("Kotlin");

        Task[] expected = {simpleTask, epic, taskTwo};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


}
