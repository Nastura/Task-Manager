package ru.netology;

//Чтобы хранить все задачи в одном массиве, нам нужен
// такой тип ячейки, который позволит в неё положить любую из
// наших задач. С этим поможет полиморфизм, для которого мы
// создадим класс Task, в который вынесем
// общее, что есть во всех задачах, а другие задачи от него отнаследуем:

import java.util.Objects;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Ниже находятся вспомогательные методы для корректной работы equals
    // Переопределять их в наследниках не нужно

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }
    public boolean matches(String query) {
        return false;
    }


}