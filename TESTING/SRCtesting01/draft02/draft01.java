public class draft01
{
    public static void main(String[]args)
    {
        JSONclass jsonOBJ1 = new JSONclass();
        JSONWriter JWrite = new JSONWriter();

        String path = "C:\\Users\\Cameron\\Documents\\Coding_and_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\SRCtesting01\\draft02\\daft01Output\\";
        String jfile = "draftJSON.json";
        JWrite.configureJSONPath(path);
        JWrite.configureJSONfileName(jfile);

        boolean bool = true;
        int number = 25;
        String name = "Gussie";

        jsonOBJ1.JsetBool(bool);
        jsonOBJ1.JsetInt(number);
        jsonOBJ1.JsetStr(name);

        String OBJname = "Gussie-Kirkwood";

        String JsonStr1 = JWrite.ObjectToJSON(jsonOBJ1, OBJname);

        JSONclass jsonOBJ2 = new JSONclass();
        jsonOBJ2.JsetBool(false);
        jsonOBJ2.JsetInt(50);
        jsonOBJ2.JsetStr("nathan");

        String jsonStr2 = JWrite.ObjectToJSON(jsonOBJ2, "Nathan");

        String json = JWrite.AppendToJSON(JsonStr1, jsonStr2);

        JWrite.BuildJSON(json);
        
    }
}


