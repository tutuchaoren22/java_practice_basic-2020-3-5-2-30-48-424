import entity.MasterNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1And2();
        System.out.println("Person data that masterNumber is 1 and 2:");
        System.out.println(personSet.groupToPeople().collect(Collectors.toList()));
        System.out.println("Person data that masterNumber is 3");
        System.out.println(personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3"))).collect(Collectors.toList()));
    }

}
