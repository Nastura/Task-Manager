package ru.netology;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] arr = new String[subtasks.length];
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks[i].equals(query)) {
                arr[i] = subtasks[i];
                return true;
            }
        }
        return false;
    }


    public String[] getSubtsks() {
        return subtasks;
    }
}
