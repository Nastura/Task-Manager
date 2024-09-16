import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import java.util.Arrays;

public class TasksTest {


    @Test
    public void searchByValidQueryInMeeting() {  // поиск по допустимому запросу в Meeting

        Meeting taskOne = new Meeting(1, "Приготовить суп", "Еда", "16 сентября 2024");
        Todos todos = new Todos();
        todos.add(taskOne);
        boolean actual = taskOne.matches("Приготовить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void searchByValidQueryInSimpleTask() {  // поиск по допустимому запросу в SimpleTask

        SimpleTask sympleTask = new SimpleTask(1, "Купить молоко 1% в КуулКлевер");
        Todos todos = new Todos();
        todos.add(sympleTask);
        boolean expected = true;
        boolean actual = sympleTask.matches("Купить молоко 1% в КуулКлевер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByValidQueryInEpic() {  // поиск по допустимому запросу в Epic

        String[] subtask = {
                "Отправить на проверку 13 дз",
                "Пересадить цветы",
                "Сходить в тренажёрный зал"
        };
        Epic epic = new Epic(1, subtask);
        Todos todos = new Todos();
        todos.add(epic);
        boolean expected = true;
        boolean actual = epic.matches("Пересадить цветы");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByInValidQueryInMeeting() {  // поиск по НЕ допустимому запросу в Meeting

        Meeting taskOne = new Meeting(1, "Приготовить суп", "Еда", "16 сентября 2024");
        Todos todos = new Todos();
        todos.add(taskOne);
        boolean actual = taskOne.matches("Прогуляться");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void searchByInValidQueryInSimpleTask() { // поиск по НЕ допустимому запросу в SimpleTask

        SimpleTask simpleTask = new SimpleTask(1, "Выполнить домашнюю работу");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean actual = simpleTask.matches("Поработать");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByInValidQueryInEpic() {  // поиск по НЕ допустимому запросу в Epic

        String[] subtask = {
                "Отправить на проверку 13 дз",
                "Пересадить цветы",
                "Сходить в тренажёрный зал"
        };
        Epic epic = new Epic(1, subtask);
        Todos todos = new Todos();
        todos.add(epic);
        boolean expected = false;
        boolean actual = epic.matches("Прогуляться");
        Assertions.assertEquals(expected, actual);
    }


}
