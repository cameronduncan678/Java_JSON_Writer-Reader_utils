import java.io.IOException;

public class main 
{
    public static void main(String[]args) throws IOException
    {
        Employee Gussie = new Employee();
        Gussie.name = "Agusta Kirkwood";
        Gussie.id = 144567;
        Gussie.location = "Edinburgh";
        Gussie.in_Office = true;

        Employee Nathan = new Employee();
        Nathan.name = "Nathan Nelson";
        Nathan.id = 556890;
        Nathan.location = "Glasgow";
        Nathan.in_Office = false;

        JSONWriter Jwrite = new JSONWriter();
        String file_path = "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\AppendJSONStr\\";
        String file_name = "mainJSON.json";
        Jwrite.configureJSONPath(file_path);
        Jwrite.configureJSONfileName(file_name);

        String initJSONstring = Jwrite.ObjectToJSON(Gussie, "Gussie");
        String secJSONString = Jwrite.ObjectToJSON(Nathan, "Nate");

        String mastJSONstring = Jwrite.AppendToJSON(initJSONstring, secJSONString);

        Jwrite.BuildJSON(mastJSONstring);

        JSONReader Jread = new JSONReader();

        String json_str = Jread.JSON_String(file_path+file_name);

        String openString = json_str.substring(1, (json_str.length()-2));

        System.out.println(openString);

        Employee Ash = new Employee();
        Ash.name = "Ashleigh Love";
        Ash.id = 2233145;
        Ash.location = "Glasgow";
        Ash.in_Office = true;

        
        String newJobj = Jwrite.ObjectToJSON(Ash, "Ash");

        String newJson = Jwrite.AppendToJSON(openString, newJobj);

        Jwrite.configureJSONfileName("newJson.json");
        Jwrite.BuildJSON(newJson);
        
    }

}

class Employee extends JSONclass
{
    String name;
    int id;
    String location;
    boolean in_Office;
}