import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import java.util.Arrays;

public class TodosTest {


    @Test //
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

    @Test // Поиск одной задачи
    public void searchForOneTask() {

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

    @Test // Поиск двух задач по одному запросу
    public void searchForTwoTasks() {

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

    @Test  // Поиск задачи по параметру project из задачи типа Meeting
    public void searchByParameterProject() {

        SimpleTask simpleTask2 = new SimpleTask(2, "Сон");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Сон", "Подсознание", "10 октября 2024 год");

        Todos todos = new Todos();
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(taskOne);
        todos.search("Подсознание");

        Task[] expected = {taskOne};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // Поиск не существующей задачи
    public void searchForNullTasks() {

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

    @Test  // Тест методов геттеры в SimpleTask
    public void checkOfGettersSimpleTask() {
        SimpleTask test = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(test);
        int expected = 1;
        int actual = test.testGet("Приготовить пирог");
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в SimpleTask
    public void checkOfGetters2SimpleTask() {
        SimpleTask test = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(test);
        int expected = 0;
        int actual = test.testGet("Приготовить сыр");
        Assertions.assertEquals(expected, actual);
    }


    @Test  // Тест методов геттеры в Epic
    public void checkOfGetters2Epic() {
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Todos todos = new Todos();
        todos.add(epic);
        String[] expected = {"Купить молоко 1% в КуулКлевер"};
        String[] actual = epic.getSubtsks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в Meeting
    public void checkOfGetters2Meeting() {
        Meeting taskOne = new Meeting(1, "Сон", "Подсознание", "10.09.2024");
        Todos todos = new Todos();
        todos.add(taskOne);
        int expected = 1;
        int actual = taskOne.testGet("Сон", "Подсознание", "10.09.2024");
        Assertions.assertEquals(expected, actual);
    }
}
