/*
 *  19 вариант
 *  a) Подсчитайте относительную частоту встречаемости числа в данном двумерном массиве
 *  b) Переставьте слова в предложении в обратном порядке, соблюдая правила написания предложения
 *  с) Заменить все согласные буквы предложения на знак "-"
 *  d) Подсчитайте количество слов заданной длинны в предложении
 */

public class Main {
    public static void main(String[] args) throws Exception {
        while (Menu.getChoicetodo() != 5) {
            Menu.start();
            switch (Menu.getChoicetodo()) {
                case 1: // Подсчитать относительную частоту встречаемости числа в двумерном массиве
                    Menu.setSentenceormatrix(2);
                    Menu.chooseInput();
                    break;
                case 2, 3, 4: // Переставить слова в предложении в обратном порядке, соблюдая правила написания предложения
                    Menu.setSentenceormatrix(1);
                    Menu.chooseInput();
                    break;
                case 5: // Выход
                    System.out.println("Производится выход из программы");
                    break;
                default:
                    System.out.println("Что-то не то");
                    break;
            }
        }
    }
}