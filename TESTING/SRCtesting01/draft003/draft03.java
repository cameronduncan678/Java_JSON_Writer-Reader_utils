import java.io.IOException;

public class draft03 
{
    public static void main(String[]args)throws IOException
    {
        //Create new object for json conversion
        //Create new json writer class
        JSONclass jsonOBJ1 = new JSONclass();
        JSONWriter JWrite = new JSONWriter();

        //Set string to the .json output path
        //set json file name 
        String path = "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\SRCtesting01\\draft003\\output\\";
        String jfile = "draftJSON03.json";
        //Add both path and filename to the json writer class
        JWrite.configureJSONPath(path);
        JWrite.configureJSONfileName(jfile);

        //Seperate variables to be added to the 
        boolean bool = true;
        int number = 25;
        String name = "Gussie";

        //Set the variables to json class
        jsonOBJ1.JsetBool(bool);
        jsonOBJ1.JsetInt(number);
        jsonOBJ1.JsetStr(name);

        //Set an object name for json class
        String OBJname = "Gussie-Kirkwood";
        //Set json class and object name to the json writer class
        //This creates a json string 
        String JsonStr1 = JWrite.ObjectToJSON(jsonOBJ1, OBJname);

        //Create new object for json conversion
        //This uses a more simplified method
        JSONclass jsonOBJ2 = new JSONclass();
        jsonOBJ2.JsetBool(false);
        jsonOBJ2.JsetInt(50);
        jsonOBJ2.JsetStr("Nathan");

        //Create the second json string from second object
        String jsonStr2 = JWrite.ObjectToJSON(jsonOBJ2, "Nathan");
        //Append the second json string to first json string
        String json = JWrite.AppendToJSON(JsonStr1, jsonStr2);

        //create the .json file 
        JWrite.BuildJSON(json);

        /*At this point the .json should have been built 
          The following code shows how to read the json file */

        System.out.println("");

        //create a json reader class
        JSONReader JRead = new JSONReader();

        //Set the reader file path to the .json file 
        String path_to_Json = JRead.setPath(path, jfile);

        //Create String from Json file
        String jsonD3_str = JRead.getJSON_String(path_to_Json);

        //Retrieve all 
        String[] JKeys = JRead.getJSON_ObjKeys(jsonD3_str);
        
        //Print all Keys Numerically
        for (String i : JKeys)
        {
            int num = 0;
            System.out.println(num + ": "+ i);
            num++;
        }

        System.out.println("");
        
        //print specific values from json objects
        JRead.print_ObjVal_String(jsonD3_str, "Gussie-Kirkwood");
        JRead.print_ObjVal_Int(jsonD3_str, "Gussie-Kirkwood");
        JRead.print_ObjVal_Bool(jsonD3_str, "Gussie-Kirkwood");

       






    }
    

}