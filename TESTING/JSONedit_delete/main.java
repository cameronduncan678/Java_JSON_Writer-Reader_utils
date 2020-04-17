import java.io.IOException;

public class main
{
    public static void main(String[]args)throws IOException
    {
        String file_path = "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\JSONedit_delete\\";
        String file_name = "del_test.json";
        JSONWriter Jwrite = new JSONWriter();
        Jwrite.configureJSONPath(file_path);
        Jwrite.configureJSONfileName(file_name);

        Person Gussie = new Person();

        Gussie.Name = "Augusta Kirkwood";
        Gussie.Age = 26;
        Gussie.Hometown = "Grantown";

        Person Nathan = new Person();

        Nathan.Name = "Nathan Nelson";
        Nathan.Age = 27;
        Nathan.Hometown = "Ayr";

        Person Ashleigh = new Person();

        Ashleigh.Name = "Ashleigh Love";
        Ashleigh.Age = 24;
        Ashleigh.Hometown = "Paisley";

        Person Rory = new Person();

        Rory.Name = "Rory Martin";
        Rory.Age = 24;
        Rory.Hometown = "StoneHaven";

        String init_JSON = Jwrite.ObjectToJSON(Gussie, "Gussie");
        String sec_JSON = Jwrite.ObjectToJSON(Nathan, "Nathan");
        String third_JSON = Jwrite.ObjectToJSON(Ashleigh, "Ahleigh");
        String for_JSON = Jwrite.ObjectToJSON(Rory, "Rory");

        String append1 = Jwrite.AppendToJSON(init_JSON, sec_JSON);
        String append2 = Jwrite.AppendToJSON(append1, third_JSON);
        String append3 = Jwrite.AppendToJSON(append2, for_JSON);

        Jwrite.BuildJSON(append3);

        JSONEditor Jedit = new JSONEditor();

        Jedit.deleteJSON_object(file_path, file_name, "Nathan");

        JSONReader Jread = new JSONReader();

        String JsonSTR = Jread.JSON_String(file_path+file_name);

        String[] keynames = Jread.getJSON_Keys(JsonSTR);

        for(int i = 0; i < keynames.length; i++)
        {
            System.out.println(keynames[i]);
        }

        System.out.println();

        String[] objKeys = Jread.getJSON_objKeys(JsonSTR, keynames[1]);

        for(int i = 0; i < objKeys.length; i++)
        {
            System.out.println(objKeys[i]);
        }



    }
}

class Person extends JSONclass 
{
    public String Name;
    public int Age;
    public String Hometown;
}