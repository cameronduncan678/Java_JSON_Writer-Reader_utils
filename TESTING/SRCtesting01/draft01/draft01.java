public class draft01
{
    public static void main(String[]args)
    {
        JSONclass jsonOBJ1 = new JSONclass();
        JSONclass jsonOBJ2 = new JSONclass();
        JSONWriter JWrite = new JSONWriter();

        String path = "C:\\Users\\Cameron\\Documents\\Coding_and_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\SRCtesting01\\draft01\\daft01Output\\";
        String jfile = "draftJSON.json";
        JWrite.configureJSONPath(path);
        JWrite.configureJSONfileName(jfile);

        boolean bool = false;
        int number = 30;
        String name = "nathan";

        boolean torf = true;
        int value = 60;
        String show = "Modern Family";

        jsonOBJ1.JsetBool(bool);
        jsonOBJ1.JsetInt(number);
        jsonOBJ1.JsetStr(name);

        jsonOBJ2.JsetBool(torf);
        jsonOBJ2.JsetInt(value);
        jsonOBJ2.JsetStr(show);

        String JsonStr1 = JWrite.ObjectToJSON(jsonOBJ1);
        String JsonStr2 = JWrite.ObjectToJSON(jsonOBJ2);

        String JSONstring =  JWrite.AppendToJSON(JsonStr1, JsonStr2);

        JWrite.BuildJSON(JSONstring);
        
    }
}


