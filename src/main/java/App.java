import java.io.*;

public class App {

    public static File file = null;
    public static FileReader fr = null;
    public static BufferedReader reader = null;
    public static int a = 0;
    public static String line = "";

    public static File fileCreation(String path) {
        file = new File(path);
        return file;
    }

    public static FileReader fileReaderCreation(File file) throws FileNotFoundException {
        fr = new FileReader(file);
        return fr;
    }

    public static BufferedReader readerCreation(FileReader a) {
        reader = new BufferedReader(a);
        return reader;
    }


    public static File checkFile(File file) throws IOException {
        fileReaderCreation(file);
        line = readerCreation(fr).readLine();
        while (line != null) {
            try {
                a = Integer.parseInt(line);
            } catch (Exception e) {
                throw new RuntimeException("Файл должен содержать только по одному числу в строке");
            }
            line = reader.readLine();
        }
        return file;
    }

    public static String numToFizzBuzzReplace(int b) {
        if (b % 3 == 0 && b % 5 == 0) {
            return "FizzBuzz";
        } else if (b % 3 == 0) {
            return "Fizz";
        } else if (b % 5 == 0) {
            return "Buzz";
        } else {
            String s = String.valueOf(b);
            return s;
        }
    }

    public static void main(String[] args) {

        if (args.length != 0) {
            try {
                fileCreation(args[0]);
                checkFile(file);
                fileReaderCreation(file);
                line = readerCreation(fr).readLine();
                while (line != null) {
                    a = Integer.parseInt(line);
                    System.out.println(numToFizzBuzzReplace(a));
                    line = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException("Файл находится ./src/main/resources/input.txt");
        }

    }

}
