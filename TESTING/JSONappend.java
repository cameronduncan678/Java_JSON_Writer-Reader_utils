import com.google.gson.*;
import java.io.*;

public class JSONappend
{
    public static void main(String[]args)throws IOException
    {
        String path = "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\testOutputs\\";
        Writer file = new FileWriter(path + "appendJSON.json");

        String name1 = "Gussie";
        Person Gussie = new Person();
        Gussie.setName(name1);

        String name2 = "Nathan";
        Person Nathan = new Person();
        Nathan.setName(name2);

        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String jsonin1 = json.toJson(Gussie);
        String jsonin2 = json.toJson(Nathan);

        String jsonStart = "[ ";
        String jsonEnd = " ]";

        file.write(jsonStart + "\n" +jsonin1 + "\n" + jsonin2 + "\n" + jsonEnd);

        System.out.println(jsonStart + "\n" +jsonin1 + "\n" + jsonin2 + "\n" + jsonEnd);

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