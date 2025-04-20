import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReplaceLines {

    public static void main(String[] args) {
        String file1Path = "src/dataset/file1.txt"; // 修改为你的文件1路径
        String file2Path = "src/dataset/file2.txt"; // 修改为你的文件2路径

        try {
            List<String> file1Lines = readLinesFromFile(file1Path);
            List<String> file2Lines = readLinesFromFile(file2Path);

            for (int i = 0; i < file1Lines.size(); i++) {
                String lineA = file1Lines.get(i);
                int countA = countOccurrences(lineA, "-1");
                System.out.println(i);

                if (countA > 7) {
                    for (int j = 0; j < file2Lines.size(); j++) {
                        String lineB = file2Lines.get(j);
                        int countB = countOccurrences(lineB, "-1");

                        if (countB < 5) {
                            file1Lines.set(i, lineB);
                            file2Lines.remove(j);
                            break;
                        }
                    }
                }
            }

            writeLinesToFile(file1Path, file1Lines);
            writeLinesToFile(file2Path, file2Lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void writeLinesToFile(String filePath, List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    private static int countOccurrences(String line, String target) {
        int count = 0;
        int index = 0;

        while ((index = line.indexOf(target, index)) != -1) {
            count++;
            index += target.length(); // move to the end of the target string
        }

        return count;
    }
}
