package hw3;

import hw3.ex.FileReadException;
import hw3.ex.FileWriteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                System.out.println("Выберите действие");
                System.out.println("1. Записать данные в файл");
                System.out.println("2. Прочитать данные из файла");
                System.out.println("3. Выход");
                String br = reader.readLine();
                int choice = Integer.parseInt(br);
                switch (choice) {
                    case 1:
                        FileService.writeDataToFile(reader);
                        break;
                    case 2:
                        fileService.readDataFromFile();
                        break;
                    case 3:
                        System.out.println("До свидания!");
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                }
            }
        } catch (FileReadException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (FileWriteException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат числа: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}