package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (!this.tasks.isEmpty()) {
            for (Task element : this.tasks) {
                if (task.getPriority() < element.getPriority()) {
                    break;
                } else if (task.getPriority() == element.getPriority()) {
                    index++;
                    break;
                }
                index++;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
