import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkWithFiles {
    public static void writeToFile(Person person) throws IOException {
        String path = "./"+person.surname+".txt";
        try (FileOutputStream fileStream = new FileOutputStream(path, true)){
            // <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
            String source ="<"+person.surname+"><"
                            +person.name+"><"
                            +person.patronymic+"><"
                            +person.dateOfBirth+"><"
                            +person.phoneNumber+"><"
                            +person.gender+">\n";
            byte[] data = source.getBytes();
            fileStream.write(data);
        } catch (FileNotFoundException e) {
            File file = new File(path);
            file.createNewFile();
            FileOutputStream newFileStream = new FileOutputStream(file, false);
            String source = "<" + person.surname + "><"
                    + person.name + "><"
                    + person.patronymic + "><"
                    + person.dateOfBirth + "><"
                    + person.phoneNumber + "><"
                    + person.gender + ">";
            byte[] data = source.getBytes();
            newFileStream.write(data);
        }catch (IOException exp){
            exp.printStackTrace();
        }
    }
}
