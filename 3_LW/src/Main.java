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
                    System.out.println("1 пункт");
                    Menu.setSentenceormatrix(2);
                    Menu.chooseInput();
                    break;
                case 2: // Переставить слова в предложении в обратном порядке, соблюдая правила написания предложения
                    System.out.println("2 пункт");
                    Menu.setSentenceormatrix(1);
                    Menu.chooseInput();
                    break;
                case 3: // Заменить все согласные буквы предложения на знак "-"
                    System.out.println("3 пункт");
                    Menu.setSentenceormatrix(1);
                    Menu.chooseInput();
                    break;
                case 4: // Подсчитать количество слов заданной длинны в предложении
                    System.out.println("4 пункт");
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


            /*
             * // A
             * System.out.println("Задание a");
             * int[][] mas = { { 4, 3, 5, 2 }, { 2, 3, 7, 8 }, { 7, 9, 1, 4 }, { 2, 5, 3, 5
             * } };
             * Matrix m1 = new Matrix(mas);
             * Matrix m2 = new Matrix(m1);
             * System.out.println("Исходная матрица:");
             * m1.print();
             * System.out.println("Клонированная матрица:");
             * m2.print();
             * System.out.println(
             * "Относительная частота встречаемости числа 5 в клонированной матрице = " +
             * m2.findFrequency(5) + "%");
             * System.out.println();
             *
             * // B
             * System.out.println("Задание b");
             * Sentence str = new Sentence();
             * System.out.println("Исходное предложение: '" + str + "'");
             * str.len = 10;
             * System.out.println("Перевёрнутое предложение: '" + str.reverseSentence() +
             * "'");
             * System.out.println();
             *
             * // C
             * System.out.println("Задание c");
             * Sentence line = new Sentence();
             * System.out.println("Исходное предложение: '" + line + "'");
             * System.out.println("Предложение с символом '-' вместо согласных: " +
             * line.consonantLetterSwapDefis());
             * System.out.println();
             *
             * // D
             * System.out.println("Задание d");
             * Sentence s = new Sentence("Hello I am Alex goodnight cat dog and mouse.");
             * System.out.println("Исходное предложение: '" + s + "'");
             * System.out.println("Количество слов длинной " + 5 + " = " +
             * s.findCountOfSameWord());
             */
        }
    }
}