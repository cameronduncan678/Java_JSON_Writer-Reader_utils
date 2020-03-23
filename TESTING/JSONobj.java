import com.google.gson.*;
import java.io.*;

public class JSONobj
{
    public static void main(String[]args)throws IOException
    {
        String path = "C:\\Users\\Cameron\\Documents\\Coding and Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\testOutputs";
        Person Gussie = new Person();
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        Writer file = new FileWriter(path + "testJSON.json");

        String name = "Gussie";
        Gussie.setName(name);
        String jsonStr = json.toJson(Gussie);

        file.write(jsonStr);

        System.out.println(jsonStr);

        file.close();
    }
}

class Person
{
    public String name;
    public void setName(String name)
    {
        this.name = name;
    }
}