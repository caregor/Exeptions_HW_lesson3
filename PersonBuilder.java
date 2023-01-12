public class PersonBuilder {
    private Person person;

    public PersonBuilder builder(){
        person = new Person();
        return this;
    }
    public PersonBuilder setName(String name){
        this.person.setName(name);
        return this;
    }
    public PersonBuilder setSurname (String surname) {
        this.person.setSurname(surname);
        return this;
    }
    public PersonBuilder setPatronymic(String patronymic){
        this.person.setPatronymic(patronymic);
        return this;
    }
    public PersonBuilder setDateOfBirth (String dateOfBirth){
        this.person.setDateOfBirth(dateOfBirth);
        return this;
    }
    public PersonBuilder setPhoneNumber(Long phoneNumber){
        this.person.setPhoneNumber(phoneNumber);
        return this;
    }
    public PersonBuilder setGender (String gender){
        this.person.setGender(gender);
        return this;
    }
    public Person build(){
        return person;
    }
}
