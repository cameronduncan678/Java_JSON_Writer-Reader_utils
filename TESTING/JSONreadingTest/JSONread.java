import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;


public class JSONread
{
    public static void main(String[]args) throws IOException
    {
        String path = "C:\\Users\\Cameron\\Documents\\Coding_and_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\JSONreadingTest\\jsonfiles\\draftJSON.json";

        String JsonSTR = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        
        System.out.println(JsonSTR);

        
        //org.json-objectvariable
        JSONObject obj = new JSONObject(JsonSTR);
        String pageName = obj.getJSONObject("Gussie-Kirkwood").getString("JclassStr");
        int number = obj.getJSONObject("Nathan").getInt("Jclassint");
        String[] fieldnames = JSONObject.getNames(obj);

        for (int i = 0; i < fieldnames.length; i++)
        {
            System.out.println(i + ":"+ " "+fieldnames[i]);
        }
        
        
        
        // System.out.println(pageName);
        //System.out.println(number);

    }
}


class JSONclass
{
    public String JclassStr;
    public int Jclassint;
    public boolean JclassBool;

    public void JsetStr(String set)
    {
        this.JclassStr = set;
    }
    public void JsetInt(int set)
    {
        this.Jclassint = set;
    }
    public void JsetBool(boolean set)
    {
        this.JclassBool = set;
    }

}