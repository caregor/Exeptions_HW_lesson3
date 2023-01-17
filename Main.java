import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] personData = in.split(" ");
         if (personData.length != 6) {
             System.out.println("Введено неверное колличество данных");
             throw new RuntimeException();

         }
         Person person = new PersonBuilder().builder()
                    .setName(personData[0])
                    .setSurname(personData[1])
                    .setPatronymic(personData[2])
                    .setDateOfBirth(personData[3])
                    .setGender(personData[4])
                    .setPhoneNumber(Long.parseLong(personData[5]))
                    .build();
         try {
             WorkWithFiles.writeToFile(person);
         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
