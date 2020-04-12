import java.io.IOException;

public class test
{
    public static void main(String[]args)throws IOException
    {
        JSONWriter Jwrite = new JSONWriter();
        JSONReader Jread = new JSONReader();
        Tester testclass = new Tester();

        Jwrite.configureJSONPath("V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\GetJsonOBJkeys\\");
        Jwrite.configureJSONfileName("keytest.json");

        String JFile = Jwrite.ObjectToJSON(testclass, "testObj");
        Jwrite.BuildJSON(JFile);

        String path = Jread.setPath("V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\GetJsonOBJkeys\\", "keytest.json");
        String parse = Jread.getJSON_String(path);

        String[] keys = Jread.getJSON_objKeys(parse, "testObj");

        for(String i : keys)
        {
            System.out.println(i);
        }

        System.out.println(keys[0]);

    }
}

class Tester extends JSONclass
{
    int INT = 3;
    int AINT = 50;
    boolean truth = true;
    String sentence = "This is a test";
}