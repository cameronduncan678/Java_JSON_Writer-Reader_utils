
import java.io.IOException; 

public class source 
{
    public static void main(String[]args)throws IOException
    {
        String file_path =  "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\AppendJSONStr\\";
        String file_name = "third.json";
        JSONReader Jread = new JSONReader();
        JSONEditor Jedit = new JSONEditor();

        String json_String = Jread.JSON_String("V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\AppendJSONStr\\newJson.json");

        String open = Jedit.OPENjson(json_String);

        JSONWriter Jwrite = new JSONWriter();

        Jwrite.configureJSONPath(file_path);
        Jwrite.configureJSONfileName(file_name);

        Rando testOBJ = new Rando();
        String newobj = Jwrite.ObjectToJSON(testOBJ, "Random");

        String rebuildJSON = Jwrite.AppendToJSON(newobj, open);

        Jwrite.BuildJSON(rebuildJSON);

    }

}

class Rando extends JSONclass
{
    String daSTR = "blaggaflagga";
    int brains_of_a = 3;
    boolean retarted = true; 
}