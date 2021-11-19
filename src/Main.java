import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("Созданы директории: \n");

        File[] dirs = {
                new File("/Users/user/IdeaProject/gameInstalling", "src"),
                new File("/Users/user/IdeaProject/gameInstalling", "res"),
                new File("/Users/user/IdeaProject/gameInstalling", "savings"),
                new File("/Users/user/IdeaProject/gameInstalling", "temp"),
                new File("/Users/user/IdeaProject/gameInstalling/src/", "test"),
                new File("/Users/user/IdeaProject/gameInstalling/src/", "main"),
                new File("/Users/user/IdeaProject/gameInstalling/res", "drawables"),
                new File("/Users/user/IdeaProject/gameInstalling/res", "vectors"),
                new File("/Users/user/IdeaProject/gameInstalling/res", "icons"),
        };
        for (File dir : dirs) {
            setDir(dir, sb);
        }


        File[] files = {
                new File("/Users/user/IdeaProject/gameInstalling/temp", "temp.txt"),
                new File("/Users/user/IdeaProject/gameInstalling/src/main", "Utils.java"),
                new File("/Users/user/IdeaProject/gameInstalling/src/main", "Main.java"),
        };
        for (File f : files) {
            setFile(f, sb);
        }

        FileWriter writer = new FileWriter(files[0], true);
        writer.write(sb.toString());
        writer.close();
    }

    //метод создания директории
    public static void setDir(File dir, StringBuilder sb) {
        if (dir.mkdir()) {
            sb.append("\nКаталог [ ")
                    .append(dir.getName())
                    .append(" ] \n")
                    .append(dir.getPath());
        }
    }

    //метод создания файла
    public static void setFile(File file, StringBuilder sb) {
        try {
            if (file.createNewFile()) {
                sb.append("\n Файл ( ")
                        .append(file.getName())
                        .append(" ) \n")
                        .append(file.getPath());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
