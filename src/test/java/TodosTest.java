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

        SimpleTask simpleTask2 = new SimpleTask(2, "Сон");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Сон", "Подсознание", "10 октября 2024 год");

        Todos todos = new Todos();
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(taskOne);
        todos.search("Купить молоко 1% в КуулКлевер");

        Task[] expected = {epic};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchTwo() {

        SimpleTask simpleTask2 = new SimpleTask(2, "Сон");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Сон", "Подсознание", "10 октября 2024 год");

        Todos todos = new Todos();
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(taskOne);
        todos.search("Сон");

        Task[] expected = {simpleTask2, taskOne};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchNull() {

        SimpleTask simpleTask2 = new SimpleTask(2, "Сон");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Сон", "Подсознание", "10 октября 2024 год");

        Todos todos = new Todos();
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(taskOne);

        Task[] expected = {};
        Task[] actual = todos.search("Гранат");
        Assertions.assertArrayEquals(expected, actual);

    }

}
