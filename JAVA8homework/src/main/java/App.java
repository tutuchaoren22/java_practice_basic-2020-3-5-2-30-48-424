public class App {

  public static void main(String[] args) {
    PersonService personService = new PersonService();
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1And2();
    personSet.groupToPeople();
  }

}
