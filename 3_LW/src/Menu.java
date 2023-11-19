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

     public static void chooseInput() {
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
                    System.out.println("1 пункт");
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
                    System.out.println("2 пункт");
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
                    System.out.println("3 пункт");
                    if(sentenceormatrix == 1){
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(5, 0);
                    }
                    else{
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(0, 5);
                    }
                    choiceinput = 5;
                    break;
                case 4: // Из бинарного файла
                    System.out.println("4 пункт");
                    if(sentenceormatrix == 1){
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(5, 0);
                    }
                    else{
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(0, 5);
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
     public static void chooseOutput(int length, int x){
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
                    System.out.println("2 пункт");
                    choiceoutput = 4;
                    break;
                case 3: // В бинарный файл
                    System.out.println("3 пункт");
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