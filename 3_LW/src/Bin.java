import java.io.*;

public class Bin {
    private static File filename;
    public static int[][] readMatrixFromFile() {
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] buffer = new byte[1024];
            int bytesRead = reader.read(buffer);
            int rows = buffer[0];
            int cols = buffer[1];
            int index = 2;
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = buffer[index++];
                }
            }
            return matrix;
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
            return new int[][]{{0}};
        }
    }
    public static void writeMatrixToFile(Matrix matrix, double result) {
        int rows = matrix.getRank();
        int cols = matrix.getRank();

        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filename))) {
            writer.write(rows);
            writer.write(cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(matrix.getNumberMatrix(i, j));
                }
            }
            writer.write((result + "%").getBytes());
            writer.close();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
    }
    public static String readLineFromFile() {
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] buffer = new byte[1024];
            int bytesRead = reader.read(buffer);
            return new String(buffer, 0, bytesRead);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
            return "";
        }
    }
    /*StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        return result.toString();
    }catch (FileNotFoundException e){
        System.out.println("Такого файла не существует");
        return "";
    } catch (IOException e) {
        System.out.println("Ошибка чтения из файла " + filename + ": " + e.getMessage());
        return "";
    }*/
    public static void writeLineToFile (String text){
        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filename))) {
            writer.write(text.getBytes());
            writer.close();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
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