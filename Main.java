import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите данные вида: Иванов Иван Иванович 11.06.1980 79811234523 m");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] personData = in.split(" ");
         if (personData.length != 6) {
             throw new RuntimeException("Введено неверное количество данных!");
         }
        try {
            Person person = new PersonBuilder().builder()
                    .setSurname(personData[0])
                    .setName(personData[1])
                    .setPatronymic(personData[2])
                    .setDateOfBirth(personData[3])
                    .setPhoneNumber(Long.parseLong(personData[4]))
                    .setGender(personData[5])
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
