import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


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

    public void setName(String name) {
        if (!Helper.isDigit(name)) this.name = name;
        else throw new IllegalArgumentException("В имени не должно быть цифр");
    }

    public void setSurname(String surname) {
        if (!Helper.isDigit(surname)) this.surname = surname;
        else throw new IllegalArgumentException("В фамилии не должно быть цифр");
    }

    public void setPatronymic(String patronymic) {
        if (!Helper.isDigit(patronymic)) this.patronymic = patronymic;
        else throw new IllegalArgumentException("В отчестве не должно быть цифр");
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
            LocalDate date = LocalDate.parse(dateOfBirth, formatter);
            this.dateOfBirth = String.valueOf(date);
        }
        // если шаблон недействителен // если текст не может быть проанализирован
        catch (IllegalArgumentException | DateTimeParseException ex) {
            throw new RuntimeException("Неверный формат даты. Дата должна быть в формате dd.mm.yyyy");
        }
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
    }
}