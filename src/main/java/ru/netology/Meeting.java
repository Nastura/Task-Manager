package ru.netology;

public class Meeting extends Task {

    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;

    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

    public boolean comparisonOfVariables(String topic, String project, String start) {
        if (topic.equals(getTopic()) & project.equals(getProject()) & start.equals(getStart())) {
            return true;
        } else {
            return false;
        }

    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }
}
