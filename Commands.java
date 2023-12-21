import java.io.*;
import java.util.ArrayList;

public class Commands extends ArrayList<String>{

    public Commands(String fileName){
        loadCommands(fileName);
    }

    public void loadCommands(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/" + fileName))) {
            String command;
            while ((command = reader.readLine()) != null) {
                this.add(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
