import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static private Scanner scanner = new Scanner(System.in);
    static private int choicetodo = -1;
    static private int choiceinput = -1;
    static private int choiceoutput = -1;
    static private int sentenceormatrix = -1;
    static private Matrix m;
    static private Sentence s;

    public static int readChoice(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Пожалуйстаа вводите только существующие пункты меню ;)");
            readed = readChoice();
        }
        return readed;
    }
    public static int readValue(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Введено неверное значение :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readValue();
        }
        return readed;
    }
    public static String readLine(){
        scanner = new Scanner(System.in);
        String readed = "";
        try {
            readed = scanner.nextLine();
        }
        catch (NumberFormatException e){
            System.out.println("Что-то пошло не так :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readLine();
        }
        return readed;
    }

     public static void start() {
        System.out.println("Приветствую!");
        System.out.println("Какое задание вы хотите выполнить?");
        System.out.println("1) Подсчитать относительную частоту встречаемости числа в двумерном массиве");
        System.out.println(
                "2) Переставить слова в предложении в обратном порядке, соблюдая правила написания предложения");
        System.out.println("3) Заменить все согласные буквы предложения на знак \"-\"");
        System.out.println("4) Подсчитать количество слов заданной длинны в предложении");
        System.out.println("5) Выйти из программы");
        choicetodo = readChoice();
    }

     public static void chooseInput() throws IOException {
        choiceinput = -1;
        do{
            System.out.println("Как хотите осуществить ввод?");
            if(sentenceormatrix == 1){
                System.out.println("1) Предложение \"May the force be with you.\"");
            }
            else{
                System.out.println("1) Случайная матрица 4x4");
            }
            System.out.println("2) Из консоли");
            System.out.println("3) Из текстового файла");
            System.out.println("4) Из бинарного файла");
            System.out.println("5) Вернуться на предыдущий пункт");
            System.out.println("6) Выйти из программы");
            choiceinput = readChoice();
            switch (choiceinput){
                case 1: // Случайная матрица 4x4 или Предложение "May the force be with you."
                    if(sentenceormatrix == 1){
                        int length = 0;
                        if (choicetodo == 2){
                            s = new Sentence();
                        }
                        else if (choicetodo == 3){
                            s = new Sentence();
                        }
                        else {
                            s = new Sentence();
                            System.out.println("Введите исходную длину слова: ");
                            length = readValue();
                        }
                        Menu.chooseOutput(length, 0);
                    }
                    else{
                        int x = 0;
                        System.out.print("Введите искомое число: ");
                        x = readValue();
                        m = new Matrix();
                        Menu.chooseOutput(0, x);
                    }
                    choiceinput = 5;
                    break;
                case 2: // Из консоли
                    if(sentenceormatrix == 1){
                        String line = "";
                        int length = 0;
                        if (choicetodo == 2){
                            System.out.print("Введите предложение, которое хотите перевернуть: ");
                            line = readLine();
                        }
                        else if (choicetodo == 3){
                            System.out.print("Введите предложение, в котором хотите заменить все согласные на \"-\": ");
                            line = readLine();
                        }
                        else {
                            System.out.print("Введите предложение, в котором хотите подсчитать слова: ");
                            line = readLine();
                            System.out.print("Введите исходную длину слова: ");
                            length = readValue();
                        }
                        s = new Sentence(line);
                        Menu.chooseOutput(length, 0);
                    }
                    else{
                        int rank = 1;
                        System.out.print("Введите размерность матрицы: ");
                        rank = readValue();
                        int[][] matrix = new int[rank][rank];
                        for (int k = 0; k < rank; k++){
                            for (int j = 0; j < rank; j++){
                                System.out.print("Введите [" + (k+1) + "] [" + (j+1) + "] элемент матрицы: ");
                                matrix[k][j] = readValue();
                            }
                        }
                        int x = 0;
                        System.out.print("Введите искомое число: ");
                        x = readValue();
                        m = new Matrix(matrix);
                        Menu.chooseOutput(0, x);
                    }
                    choiceinput = 5;
                    break;
                case 3: // Из текстового файла
                    if(sentenceormatrix == 1){
                        System.out.print("Введите имя файла, из которого считать предложение: ");
                        String name = readLine();
                        Txt.setFilename(name);
                        while(!Txt.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Txt.setFilename(name);
                        }
                        String line = "";
                        int length = 0;
                        if (choicetodo == 2){
                            line = Txt.readLineFromFile();
                        }
                        else if (choicetodo == 3){
                            line = Txt.readLineFromFile();
                        }
                        else {
                            line = Txt.readLineFromFile();
                            System.out.print("Введите исходную длину слова: ");
                            length = readValue();
                        }
                        s = new Sentence(line);
                        Menu.chooseOutput(length, 0);
                    }
                    else{
                        System.out.print("Введите имя файла, из которого считать матрицу: ");
                        String name = readLine();
                        Txt.setFilename(name);
                        while(!Txt.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Txt.setFilename(name);
                        }
                        int[][] matrix= Txt.readMatrixFromFile();
                        m = new Matrix(matrix);
                        System.out.print("Введите искомое число: ");
                        int x = readValue();
                        Menu.chooseOutput(0, x);
                    }
                    choiceinput = 5;
                    break;
                case 4: // Из бинарного файла
                    if(sentenceormatrix == 1){
                        System.out.print("Введите имя файла, из которого считать предложение: ");
                        String name = readLine();
                        Bin.setFilename(name);
                        while(!Bin.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Bin.setFilename(name);
                        }
                        String line = "";
                        int length = 0;
                        if (choicetodo == 2){
                            line = Bin.readLineFromFile();
                        }
                        else if (choicetodo == 3){
                            line = Bin.readLineFromFile();
                        }
                        else {
                            line = Bin.readLineFromFile();
                            System.out.print("Введите исходную длину слова: ");
                            length = readValue();
                        }
                        s = new Sentence(line);
                        Menu.chooseOutput(length, 0);
                    }
                    else{
                        System.out.print("Введите имя файла, из которого считать матрицу: ");
                        String name = readLine();
                        Bin.setFilename(name);
                        while(!Bin.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Bin.setFilename(name);
                        }
                        int[][] matrix= Bin.readMatrixFromFile();
                        m = new Matrix(matrix);
                        System.out.print("Введите искомое число: ");
                        int x = readValue();
                        Menu.chooseOutput(0, x);
                    }
                    choiceinput = 5;
                    break;
                case 5: // Вернуться на предыдущий пункт
                    System.out.println("Возвращение на предыдущий пункт");
                    break;
                case 6: // Выйти из программы
                    System.out.println("Произвожу выход из программы");
                    System.exit(0);
            }
        }while (choiceinput != 5);
    }
     public static void chooseOutput(int length, int x) throws IOException {
        choiceoutput = -1;
        while (choiceoutput != 4){
            System.out.println("Как хотите осуществить вывод результата?");
            System.out.println("1) В консоль");
            System.out.println("2) В текстовый файл");
            System.out.println("3) В бинарный файл");
            System.out.println("4) Вернуться на предыдущий пункт");
            System.out.println("5) Выйти из программы");
            choiceoutput = readChoice();
            switch (choiceoutput){
                case 1: // В консоль
                    if(sentenceormatrix == 1){
                        if (choicetodo == 2){
                            System.out.println(s.reverseSentence());
                        }
                        else if (choicetodo == 3){
                            System.out.println(s.consonantLetterSwapDefis());
                        }
                        else {
                            System.out.println(s.findCountOfSameWord(length));
                        }
                    }
                    else{
                        m.print();
                        System.out.println(m.findFrequency(x) + "%");
                    }
                    System.out.println();
                    choiceoutput = 4;
                    break;
                case 2: // В текстовый файл
                    if(sentenceormatrix == 1){
                        System.out.print("Введите имя файла, в который записать результат: ");
                        String name = readLine();
                        Txt.setFilename(name);
                        while(!Txt.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Txt.setFilename(name);
                        }
                        if (choicetodo == 2){
                            Txt.writeLineToFile(s.reverseSentence());
                        }
                        else if (choicetodo == 3){
                            Txt.writeLineToFile(s.consonantLetterSwapDefis());
                        }
                        else {
                            Txt.writeLineToFile(s.findCountOfSameWord(length));
                        }
                    }
                    else{
                        System.out.print("Введите имя файла, в который записать матрицу, с результатом: ");
                        String name = readLine();
                        Txt.setFilename(name);
                        while(!Txt.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Txt.setFilename(name);
                        }
                        Txt.writeMatrixToFile(m, m.findFrequency(x));
                    }
                    System.out.println();
                    choiceoutput = 4;
                    break;
                case 3: // В бинарный файл
                    if(sentenceormatrix == 1){
                        System.out.print("Введите имя файла, в который записать результат: ");
                        String name = readLine();
                        Bin.setFilename(name);
                        while(!Bin.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Bin.setFilename(name);
                        }
                        if (choicetodo == 2){
                            Bin.writeLineToFile(s.reverseSentence());
                        }
                        else if (choicetodo == 3){
                            Bin.writeLineToFile(s.consonantLetterSwapDefis());
                        }
                        else {
                            Bin.writeLineToFile(s.findCountOfSameWord(length));
                        }
                    }
                    else{
                        System.out.print("Введите имя файла, в который записать матрицу, с результатом: ");
                        String name = readLine();
                        Bin.setFilename(name);
                        while(!Bin.setFilename(name)){
                            System.out.print("Такого файла не существует, введите существующий файл: ");
                            name = readLine();
                            Bin.setFilename(name);
                        }
                        Bin.writeMatrixToFile(m, m.findFrequency(x));
                    }
                    System.out.println();
                    choiceoutput = 4;
                    break;
                case 4: // Вернуться на предыдущий пункт
                    System.out.println("Возвращение на предыдущий пункт");
                    break;
                case 5: // Выйти из программы
                    System.out.println("Произвожу выход из программы");
                    System.exit(0);
            }
        }
    }
     public static int getChoicetodo(){
        return choicetodo;
    }

     public static int getChoiceinput() {
        return choiceinput;
    }
     public static void setSentenceormatrix(int x){
        sentenceormatrix = x;
    }
}