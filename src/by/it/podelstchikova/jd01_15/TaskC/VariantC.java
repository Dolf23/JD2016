package by.it.podelstchikova.jd01_15.TaskC;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VariantC {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
    private File currentDirectory = new File(".");

    public void run(){

        String line;
        try {
            do {
                line = bufferedReader.readLine();
                parseCommand(line);

            } while (!"q".equals(line.toLowerCase()));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void cd (File file) throws IOException {
        currentDirectory = file;
        System.out.print(currentDirectory.getCanonicalFile() + ">");
    }

    private void dir(File file) throws IOException {

        System.out.println(" Содержимое папки " + file.getCanonicalPath() + "\n");
        File[] files = file.listFiles();

        int fileCount = 0;
        int totalFileSize = 0;
        int directoryCount = 0;

        for (File currentFile : files){
            if (currentFile.isDirectory()){
                directoryCount++;
            } else {
                totalFileSize += currentFile.length();
                fileCount++;
            }
        }

        for (File f1 : files){
            String name = f1.getName();
            String date = sdf.format(new Date(f1.lastModified()));
            String dirString = "\t";
            long size = 0;
            if (f1.isDirectory()){
                dirString = "<DIR>";
            } else {
                size = f1.length();
            }
            System.out.printf("%s\t%s\t%8s  %s\n", date, dirString, sizeToString(size), name);


        }
        System.out.printf("\t\t\t%d файлов %16d байт\n", fileCount, totalFileSize);
        System.out.printf("\t\t\t%d папок  %16d байт свободно\n", directoryCount, file.getFreeSpace());
        System.out.println();
        System.out.print(currentDirectory.getCanonicalFile() + ">");
    }

    private String sizeToString(long size){
        if (size == 0){
            return "";
        } else {
            StringBuilder builder = new StringBuilder(String.valueOf(size));
            int cycleCount = 0;
            for (int j = builder.length(); j > 0; j--){
                cycleCount++;
                if (cycleCount % 3 == 0){
                    builder.insert(j - 1, " ");
                    cycleCount = 0;
                }
            }

            return builder.toString().trim();
        }
    }

    private void parseCommand(String command) throws IOException {
        String cmd = command.trim();
        if (cmd.toLowerCase().startsWith("dir") || cmd.toLowerCase().startsWith("cd")){
            if ("dir".equals(cmd.toLowerCase())){
                dir(currentDirectory);
            } else if ("cd".equals(cmd.toLowerCase())){
                cd(new File("."));
            } else {
                String[] params = cmd.split(" ");
                if (params.length > 2){
                    System.out.println("Неверная команда");
                    printHelp();
                } else {
                    String directory = params[1];

                    File newFile = new File(currentDirectory.getCanonicalFile() + "/" + directory);
                    if (newFile.exists()){
                        if (newFile.isDirectory()){
                            if (params[0].toLowerCase().equals("dir")){
                                dir(newFile);
                            } else {
                                cd(newFile);
                            }
                        } else {
                            System.out.println(directory + " не является директорией");
                            System.out.print(currentDirectory.getCanonicalFile() + ">");
                        }
                    } else {
                        System.out.println("Нет директории с именем " + directory);
                        System.out.print(currentDirectory.getCanonicalFile() + ">");
                    }
                }
            }

        }

    }

    private void printHelp(){
        System.out.println();
        System.out.println("dir - посмотреть директорию");
        System.out.println("cd - сменить директорию");
        System.out.println("q - выход");
    }
}
