package creat;

import java.io.*;
import java.util.ArrayList;

public class FileCSV {
    public String FILE_PATH = "/Users/thaodangxuan/IdeaProjects/TEST_MD2/src/creat/contact.csv";

    File file = new File(FILE_PATH);

    public void writer(ArrayList<Contact> list, String filePath) throws IOException {
        FileWriter fw = new FileWriter(new File(filePath));
        for (Contact s : list) {
            fw.write(s.getName() + "," + s.getTelephone() + "," + s.getAddress() + ","
                    + s.getEmail() + "," + s.getFacebook() + "\n");
        }
        fw.close();
    }

    public String reader(String filePath) throws IOException {
        String result = "";

        FileReader fr = new FileReader(new File(filePath));
        BufferedReader bfr = new BufferedReader(fr);

        String line;
        while ((line = bfr.readLine()) != null) {
            result = result.concat(line + "\n");
        }
        bfr.close();
        fr.close();

        return result;
    }

    public ArrayList<Contact> swapFileCSV(String content) {
        ArrayList<Contact> lists = new ArrayList<>();

        String[] students = content.split("\n");

        for (int i = 0; i < students.length; i++) {
            String studentItem = students[i];
            String[] elements = studentItem.split(",");
            if (elements.length == 5) {
                lists.add(new Contact(elements[0], elements[1], elements[2],
                        elements[3], elements[4]));
            }
        }
        return lists;
    }
}
