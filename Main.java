import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] personData = in.split(" ");
         if (personData.length != 6) {
             throw new RuntimeException("Введено неверное количество данных!");
         }
        try {
            Person person = new PersonBuilder().builder()
                    .setName(personData[0])
                    .setSurname(personData[1])
                    .setPatronymic(personData[2])
                    .setDateOfBirth(personData[3])
                    .setGender(personData[4])
                    .setPhoneNumber(Long.parseLong(personData[5]))
                    .build();

            WorkWithFiles.writeToFile(person);
        } catch(NumberFormatException exp){
            System.err.println("Неверный формат данных. Попробуйте еще...");
            exp.printStackTrace();
        } catch (Exception e){
             e.printStackTrace();
         }
    }
}
