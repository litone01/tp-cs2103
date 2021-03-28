package seedu.sochedule.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.sochedule.model.common.Category;
import seedu.sochedule.model.common.Tag;

//import seedu.sochedule.model.Sochedule;
//import seedu.sochedule.model.ReadOnlySochedule;
//import seedu.sochedule.model.common.Name;
//import seedu.sochedule.model.task.Task;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    //    public static Task[] getSampleTasks() {
    //
    //    }

    //    public static ReadOnlySochedule getSampleSochedule() {
    //
    //    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a category set containing the list of strings given.
     */
    public static Set<Category> getCategorySet(String... strings) {
        return Arrays.stream(strings)
                .map(Category::new)
                .collect(Collectors.toSet());
    }

}
