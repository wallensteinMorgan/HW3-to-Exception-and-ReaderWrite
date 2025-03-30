import exception.FileReadException;
import exception.FileWriteException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FILE_PATH = "test.txt";
    public static void writeDataToFile(BufferedReader reader) throws FileWriteException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            System.out.println("Введите данные для записи в файл (введите 'exit' для завершения):");
            List<String> lines = new ArrayList<>();
            while (true){
                String input = reader.readLine();
                if("exit".equalsIgnoreCase(input)){
                    break;
                }
                lines.add(input);
            }
            for (String line : lines){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в файл.");
        }catch (IOException e){
            throw new FileWriteException("Ошибка при записи данных в файл: " + e.getMessage(), e);
        }
    }

    public void readDataFromFile() throws FileReadException{
        try {
            if(!Files.exists(Paths.get(FILE_PATH))) {
                throw new  FileReadException("Файл не существует или пуст.");
            }

            System.out.println("Данные из файла:");
            try(BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH))) {
                    String line;
                    while ((line = fileReader.readLine()) !=null){
                        System.out.println(line);
                    }
                }
            }catch (IOException e){
                throw new FileReadException("Ошибка при чтении данных из файла: " + e.getMessage(), e);
            }
        }
    }

