import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static private Scanner scanner = new Scanner(System.in);
    static private int choicetodo = -1;
    static private int choiceinput = -1;
    static private int choiceoutput = -1;
    static private Matrix m;
    static private Sentence s;

    static public void start() {
        System.out.println("Приветствую!");
        System.out.println("Какое задание вы хотите выполнить?");
        System.out.println("1) Подсчитать относительную частоту встречаемости числа в двумерном массиве");
        System.out.println(
                "2) Переставить слова в предложении в обратном порядке, соблюдая правила написания предложения");
        System.out.println("3) Заменить все согласные буквы предложения на знак \"-\"");
        System.out.println("4) Подсчитать количество слов заданной длинны в предложении");
        System.out.println("5) Выйти из программы");
        try {
            choicetodo = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Словил конкретное исключение");
            scanner = new Scanner(System.in);
        }
        System.out.println("Вы ввели: " + choicetodo);
    }

    static public void chooseInput(int i) {
        choiceinput = -1;
        while (choiceinput != 5){
            System.out.println("Как хотите осуществить ввод?");
            if(i != 1){
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
            try {
                choiceinput = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Словил конкретное исключение");
                scanner = new Scanner(System.in);
            }
            System.out.println("Вы ввели: " + choiceinput);
            switch (choiceinput){
                case 1: // Случайная матрица 4x4 или Предложение "May the force be with you."
                    System.out.println("1 пункт");
                    if(i != 1){
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
                            try {
                                length = scanner.nextInt();
                            }
                            catch (InputMismatchException e){
                                System.out.println("Словил конкретное исключение");
                                scanner = new Scanner(System.in);
                            }
                        }
                        Menu.chooseOutput(2, length, 0);
                    }
                    else{
                        int x = 0;
                        System.out.println("Введите искомое число: ");
                        try {
                            x = scanner.nextInt();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Словил конкретное исключение");
                            scanner = new Scanner(System.in);
                        }
                        m = new Matrix();
                        Menu.chooseOutput(1, 0, x);
                    }
                    choiceinput = 5;
                    break;
                case 2: // Из консоли
                    System.out.println("2 пункт");
                    if(i != 1){
                        s = new Sentence();
                        Menu.chooseOutput(2, 5, 0);
                    }
                    else{
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(1, 0, 5);
                    }
                    choiceinput = 5;
                    break;
                case 3: // Из текстового файла
                    System.out.println("3 пункт");
                    if(i != 1){
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(2, 5, 0);
                    }
                    else{
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(1, 0, 5);
                    }
                    choiceinput = 5;
                    break;
                case 4: // Из бинарного файла
                    System.out.println("4 пункт");
                    if(i != 1){
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(2, 5, 0);
                    }
                    else{
                        System.out.println("Ещё не готово");
                        Menu.chooseOutput(1, 0, 5);
                    }
                    choiceinput = 5;
                    break;
                case 5: // Вернуться на предыдущий пункт
                    System.out.println("Возвращение на предыдущий пункт");
                    break;
                case 6: // Выйти из программы
                    System.out.println("Произвожу выход из программы");
                    System.exit(0);
                default:
                    System.out.println("Что-то не то");
                    break;
            }
        }
    }
    static public void chooseOutput(int i, int length, int x){
        choiceoutput = -1;
        while (choiceoutput != 4){
            System.out.println("Как хотите осуществить вывод результата?");
            System.out.println("1) В консоль");
            System.out.println("2) В текстовый файл");
            System.out.println("3) В бинарный файл");
            System.out.println("4) Вернуться на предыдущий пункт");
            System.out.println("5) Выйти из программы");
            try {
                choiceoutput = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Словил конкретное исключение");
                scanner = new Scanner(System.in);
            }
            System.out.println("Вы ввели: " + choiceoutput);
            switch (choiceoutput){
                case 1: // В консоль
                    System.out.println("1 пункт");
                    System.out.println(choicetodo);
                    if(i != 1){
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
                        System.out.println(m.findFrequency(x));
                    }
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
                default:
                    System.out.println("Что-то не то");
                    break;
            }
        }
    }
    static public int getChoicetodo(){
        return choicetodo;
    }

    static public int getChoiceinput() {
        return choiceinput;
    }
}
