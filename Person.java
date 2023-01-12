import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {
    protected String surname;
    protected String name;
    protected String patronymic;
    protected String dateOfBirth;
    protected Long phoneNumber;
    protected String gender;

    public Person(String surname, String name, String patronymic, String dateOfBirth, Long phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public Person(){}

    public String getFio(){
        String fio = surname + " " + name + " " + patronymic;
        return fio;
    }

    public String getFioShort(){
        char name1 = name.charAt(0);
        char patronymic1 = patronymic.charAt(0);

        String fioS = surname + " " + name1 + ". " + patronymic1 + ".";
        return fioS;
    }

    public int getAge() throws ParseException {
        Date birthDate = new SimpleDateFormat( "dd.MM.yyyy" ).parse(dateOfBirth);
        LocalDate localDateBirth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateNow = LocalDate.now();
        int age = Period.between(localDateBirth, dateNow).getYears();
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(Long phoneNumber) {
        if(phoneNumber > 0 ){
            this.phoneNumber = phoneNumber;
        }else throw new RuntimeException("A Phone number must be > 0");
    }

    public void setGender(@NotNull String gender) {
        String m = "m";
        String f = "f";
        if (gender.equals(m) || gender.equals(f)){
            this.gender = gender;
        }else {
            throw new RuntimeException("Gender must be only 'f' or 'm'");
        }
     //   this.gender = gender;
    }
}
