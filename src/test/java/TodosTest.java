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

    @Test // Запрос query в задаче типа epic - одна задача
    public void searchForOneTask() {

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting taskOne = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г.");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(taskOne);
        Task[] expected = {epic};
        Task[] actual = todos.search("Купить молоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test // Запрос query в задаче типа simpleTask  и  meeting - две задача
    public void searchForTwoTasks() {

        SimpleTask simpleTask = new SimpleTask(2, "Приготовить салат");
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Meeting meeting = new Meeting(1, "Приготовить суп", "Еда", "13 сентября 2024г.");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Приготовить");
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
        Task[] expected = {meeting};
        Task[] actual = todos.search("Еда");
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
    public void comparisonOfValidTitleSimpleTask() {  // Сравнение действительного заголовка
        SimpleTask simpleTask = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(simpleTask);
        boolean expected = true;
        boolean actual = simpleTask.comparisonOfVariables("Приготовить пирог");
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в SimpleTask
    public void comparisonOfInValidTitleSimpleTask() {  // Сравнение не действительного заголовка
        SimpleTask simpleTask = new SimpleTask(1, "Приготовить пирог");
        Todos todos = new Todos();
        todos.add(simpleTask);
        boolean expected = false;
        boolean actual = simpleTask.comparisonOfVariables("Приготовить сыр");
        Assertions.assertEquals(expected, actual);

    }


    @Test  // Тест методов геттеры в Epic
    public void comparisonHeadlineEpic() { // Сравнение действительного заголовка
        String[] subtask = {"Купить молоко 1% в КуулКлевер"};
        Epic epic = new Epic(1, subtask);
        Todos todos = new Todos();
        todos.add(epic);
        String[] expected = {"Купить молоко 1% в КуулКлевер"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в Meeting
    public void comparisonHeadlineMeeting() { // Сравнение действительного заголовка
        Meeting meeting = new Meeting(1, "Сон", "Подсознание", "10.09.2024");
        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected = true;
        boolean actual = meeting.comparisonOfVariables("Сон", "Подсознание", "10.09.2024");
        Assertions.assertEquals(expected, actual);
    }

    @Test  // Тест методов геттеры в Meeting
    public void comparisonHeadlineInValidMeeting() { // Сравнение не действительного заголовка
        Meeting meeting = new Meeting(1, "Сон", "Подсознание", "10.09.2024");
        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected = false;
        boolean actual = meeting.comparisonOfVariables("Сон", "Созидание", "10.09.2024");
        Assertions.assertEquals(expected, actual);
    }

    @Test  // сравнение объектов в задаче.
    public void object() {
        Meeting meeting = new Meeting(1, "Сон", "Подсознание", "10.09.2024");
        Task task = new Task(2);
        boolean expected = false;
        boolean actual = task.equals(meeting);
        Assertions.assertEquals(expected, actual);
    }

}
