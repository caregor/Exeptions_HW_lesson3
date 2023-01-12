import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkWithFiles {
    public static void writeToFile(Person person) throws IOException {
        String path = "./"+person.surname+".txt";
        try (FileOutputStream output = new FileOutputStream(path, true)){
            // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
            String source ="<"+person.surname+"><"
                            +person.name+"><"
                            +person.patronymic+"><"
                            +person.dateOfBirth+"><"
                            +person.phoneNumber+"><"
                            +person.gender+">";
            byte[] data = source.getBytes();
            output.write(data);
        } catch (IOException e) {
            File file = new File(path);
            file.createNewFile();
            FileOutputStream s = new FileOutputStream(file,false);
            String source ="<"+person.surname+"><"
                    +person.name+"><"
                    +person.patronymic+"><"
                    +person.dateOfBirth+"><"
                    +person.phoneNumber+"><"
                    +person.gender+">";
            byte[] data = source.getBytes();
            s.write(data);
            throw new RuntimeException(e);
        }
    }
}
