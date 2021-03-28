package seedu.sochedule.testutil;

import seedu.sochedule.model.Sochedule;
import seedu.sochedule.model.event.Event;
import seedu.sochedule.model.task.Task;

/**
 * A utility class to help with building Sochedule objects.
 * Example usage: <br>
 *     {@code Sochdule sochedule = new SocheduleBuilder().withTask("Assignment", "Lab").build();}
 */
public class SocheduleBuilder {

    private Sochedule sochedule;

    public SocheduleBuilder() {
        sochedule = new Sochedule();
    }

    public SocheduleBuilder(Sochedule sochedule) {
        this.sochedule = sochedule;
    }

    /**
     * Adds a new {@code Task} to the {@code Sochedule} that we are building.
     */
    public SocheduleBuilder withTask(Task task) {
        sochedule.addTask(task);
        return this;
    }

    /**
     * Adds a new {@code Event} to the {@code Sochedule} that we are building.
     */
    public SocheduleBuilder withEvent(Event event) {
        sochedule.addEvent(event);
        return this;
    }

    public Sochedule build() {
        return sochedule;
    }
}
