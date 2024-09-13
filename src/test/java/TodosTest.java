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

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г.");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(taskOne);
        todos.search("Купить молоко 1% в КуулКлевер");

        Task[] expected = {epic};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test // Поиск двух задач по одному запросу
    public void searchForTwoTasks() {

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting meeting = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г.");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Приготовить");

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // Поиск задачи по параметру project из задачи типа Meeting
    public void searchByParameterProject() {

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting meeting = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Еда");

        Task[] expected = {meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // Поиск не существующей задачи
    public void searchForNullTasks() {

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting meeting = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Выполнить");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // Тест методов геттеры в SimpleTask
    public void  comparisonOfValidTitleSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(simpleTask);
        int expected = 0;
        int actual = simpleTask.comparisonOfVariables("Приготовить пирог");
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в SimpleTask
    public void comparisonOfInValidTitleSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(simpleTask);
        int expected = 1;
        int actual = simpleTask.comparisonOfVariables("Приготовить сыр");
        Assertions.assertEquals(expected, actual);

    }


    @Test  // Тест методов геттеры в Epic
    public void gettingFieldsEpic() {
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Todos todos = new Todos();
        todos.add(epic);
        String[] expected = {"Купить молоко 1% в КуулКлевер"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в Meeting
    public void gettingFieldsMeeting() {
        Meeting meeting = new Meeting(1, "Сон", "Подсознание", "10.09.2024");
        Todos todos = new Todos();
        todos.add(meeting);
        int expected = 0;
        int actual = meeting.comparisonOfVariables("Сон", "Подсознание", "10.09.2024");
        Assertions.assertEquals(expected, actual);
    }
}
