import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import java.util.Arrays;

public class TasksTest {


    @Test
    public void testMatchesMeeting() {

        Meeting taskOne = new Meeting(1, "Java", "Подсознание", "10 октября 2024 год");
        Meeting taskTwo = new Meeting(2, "Kotlin", "Мировоззрение", "10 ноября 2024 год");
        Meeting taskThree = new Meeting(3, "Rubi", "Подсознание", "10 декабря 2024 год");
        Meeting taskFor = new Meeting(4, "JavaScript", "Интуиция", "10 января 2025 год");
        Meeting taskFive = new Meeting(5, "Go", "Чувства", "10 февраля 2025 год");

        Todos todos = new Todos();
        todos.add(taskOne);
        todos.add(taskTwo);
        todos.add(taskThree);
        todos.add(taskFor);
        todos.add(taskFive);


        Task[] expected = {taskOne, taskTwo, taskThree, taskFor, taskFive};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testMatchesSimpleTask() {

        SimpleTask sympletask = new SimpleTask(1, "Купить молоко 1% в КуулКлевер");

        Todos todos = new Todos();
        todos.add(sympletask);

        Task[] expected = {sympletask};
        Task[] actual = todos.findAll();
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatchesEpic() {

        String[] subtask = {
                "Отправить на проверку 13 дз",
                "Пересадить цветы",
                "Сходить в тренажерку"
        };
        Epic epic = new Epic(1, subtask);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
