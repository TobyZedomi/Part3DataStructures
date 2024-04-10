package business;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private String owner;
    private String description;
    private LocalDate deadline;

    public Task(String owner, String description, LocalDate deadline) throws Exception{
        this.owner = owner;
        this.description = description;
        if(LocalDate.now().isBefore(deadline)){
         this.deadline = deadline;
        }
        else{
            throw new IndexOutOfBoundsException("This date has passed.It is invalid");
        }
    }
    public Task(){

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean setDeadline(LocalDate deadline) {
        if(LocalDate.now().isBefore(deadline)){
            this.deadline = deadline;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(owner, task.owner) && Objects.equals(description, task.description) && Objects.equals(deadline, task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, description, deadline);
    }

    @Override
    public String toString() {
        return "Task{" +
                "owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
