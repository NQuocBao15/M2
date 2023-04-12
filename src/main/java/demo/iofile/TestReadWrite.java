package demo.iofile;

import java.util.List;

public class TestReadWrite {

    public static int countCharacter(List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).length();
        }
        return count;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> list = readAndWriteFile.readFile("./string.txt");
        list.add(String.valueOf(countCharacter(list)));
        readAndWriteFile.writeFile("./result.txt",list);
    }
}