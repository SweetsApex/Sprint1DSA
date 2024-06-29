public class TaskList {
    private Node head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void markTaskAsCompleted(String description) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getDescription().equals(description)) {
                temp.task.markAsCompleted();
                return;
            }
            temp = temp.next;
        }
    }

    public void printTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }
}
