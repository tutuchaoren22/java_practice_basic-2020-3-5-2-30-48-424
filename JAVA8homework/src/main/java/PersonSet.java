import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
    private List<MasterNumber> masterNumbers;

    private List<Address> addresses;

    private List<Telephone> telephones;

    private List<Email> emails;

    public PersonSet(List<MasterNumber> masterNumbers,
                     List<Telephone> telephones,
                     List<Address> addresses,
                     List<Email> emails) {
        this.masterNumbers = masterNumbers;
        this.addresses = addresses;
        this.telephones = telephones;
        this.emails = emails;
    }

    public Stream<Person> groupToPeople() {
        // TODO: group the data to Stream<Person>
        Map<String, List<MasterNumber>> groupToMasterNumber = this.masterNumbers.stream()
                .collect(Collectors.groupingBy(MasterNumber::getNumber));
        Map<String, List<Address>> groupToAddress = this.addresses.stream()
                .collect(Collectors.groupingBy(Address::getMasterNumber));
        Map<String, List<Email>> groupToEmail = this.emails.stream()
                .collect(Collectors.groupingBy(Email::getMasterNumber));
        Map<String, List<Telephone>> groupToTelephone = this.telephones.stream()
                .collect(Collectors.groupingBy(Telephone::getMasterNumber));

        Set<Person> personSet = new HashSet<>();
        for (Map.Entry<String, List<MasterNumber>> entry : groupToMasterNumber.entrySet()) {
            String masterNumber = entry.getKey();
            Address address = groupToAddress.get(masterNumber) != null ? groupToAddress.get(masterNumber).get(0) : null;
            List<Email> email = groupToEmail.get(masterNumber) != null ? groupToEmail.get(masterNumber) : new ArrayList<>();
            List<Telephone> telephone = groupToTelephone.get(masterNumber) != null ? groupToTelephone.get(masterNumber) : new ArrayList<>();
            personSet.add(new Person(masterNumber, telephone, address, email));
        }
        return personSet.stream();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setMasterNumbers(List<MasterNumber> masterNumbers) {
        this.masterNumbers = masterNumbers;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }
}
