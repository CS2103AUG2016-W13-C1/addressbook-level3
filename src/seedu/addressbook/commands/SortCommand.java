package seedu.addressbook.commands;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.exception.DuplicateDataException;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Displays all persons in the address book as a sorted list with index numbers.\n\t" + "Example: "
            + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        Iterator<Person> allPersonsIter = addressBook.getAllPersons().iterator();

        List<Person> sortedPersonList = new ArrayList<Person>();
        while (allPersonsIter.hasNext()) {
            sortedPersonList.add(allPersonsIter.next());
        }
        Collections.sort(sortedPersonList, new PersonsNameComparator());
        return new CommandResult(getMessageForPersonListShownSummary(sortedPersonList), sortedPersonList);

        

        
    }

    private class PersonsNameComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.getName().toString().compareTo(p2.getName().toString());
        }

        public boolean equals(Object obj) {
            return this == obj;
        }
    }

}
