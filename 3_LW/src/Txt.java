import java.io.*;

public class Txt {
    private static File filename;
    public static String readLineFromFile() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            line = reader.readLine();
            result.append(line).append("\n");
            return result.toString();
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла " + filename + ": " + e.getMessage());
            return "";
        }
    }
    public static int[][] readMatrixFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int rows = 0;
            int cols = 0;
            boolean flag = true;
            while (((line = reader.readLine()) != null) && flag) {
                String[] values = line.trim().split(" ");
                for(int i = 0; i < values.length; i++){
                    try {
                        Integer.parseInt(values[i]);
                    }
                    catch (NumberFormatException e){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    rows++;
                    cols = rows;
                }
            }
            reader.close();

            int[][] matrix = new int[rows][cols];
            reader = new BufferedReader(new FileReader(filename));
            for (int i = 0; i < rows; i++) {
                line = reader.readLine();
                String[] values = line.trim().split(" ");
                for (int j = 0; j < cols; j++) {
                        matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            reader.close();
            if(rows == 0){
                System.out.println("С матрицей что-то не так");
                return new int[][]{{0}};
            }
            return matrix;
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return new int[][]{{0}};
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return new int[][]{{0}};
        }
    }

    public static void writeMatrixToFile(Matrix matrix, double result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < matrix.getRank(); i++) {
                for (int j = 0; j < matrix.getRank(); j++) {
                    writer.write(matrix.getNumberMatrix(i, j) + " ");
                }
                writer.newLine();
            }
            writer.write(result + "%");
            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
    public static void writeLineToFile(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        try {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
        writer.close();
    }
    public static boolean setFilename(String name){
        filename = new File(name);
        if (filename.exists()) {
            return true;
        } else {
            return false;
        }
    }
}