import com.google.gson.*;
import java.io.*;
import org.json.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;


//This class is for all methods to write to the .json file using JSONclass.  
class JSONWriter
{
    //JsonWriter class variables
    //These variables must be set first
    private String path;
    private String file_name;
    
    //JsonWriter class Methods

    //Set path and file name methods
    public void configureJSONPath(String setpath)
    {
        this.path = setpath;
    }
    public void configureJSONfileName(String setfname)
    {
        this.file_name = setfname;
    }

    //Method to write a single object to a .json string for later serialization 
    public String ObjectToJSON(JSONclass a, String OBJname)
    {
        Gson objjson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOBJ = objjson.toJson(a);
        return "\""+OBJname+"\""+":"+"\n"+jsonOBJ;
    } 

    //Method to append json objects to another
    public String AppendToJSON(String json, String ap)
    {
        return json + "," + "\n" + ap;
    }

    //Method to build or rebuild the JSON file 
    //This method is designed to overwrite the current .json file  
    public void BuildJSON(String json)
    {
        try
        {
            FileWriter file = new FileWriter(path + file_name);
            file.write("{\n"+json+"\n"+"}");
            file.close();
            System.out.println("Json Build successfully Built");
            System.out.println(json);
        }
        catch (IOException e)
        {
            System.out.println("An Error has ocurred[recommended check path String]");
            e.printStackTrace();
        }
    }

}

//This class is for all methods to read the .json file. 
//This should be used second to the JSONWriter and JSONclass classes
class JSONReader
{
    //Configure file path and name 
    public String setPath(String path, String file)
    {
        return path + file;
    } 
    //Method to retrieve Json data as a string
    //This is needed before all other methods
    public String getJSON_String(String Path) throws IOException
    {
        String JsonSTR = new String(Files.readAllBytes(Paths.get(Path)), StandardCharsets.UTF_8);
        return JsonSTR;
    } 

    //Method to return an array of object Key Names for further use
    //Useful for later parsing
    public String[] getJSON_ObjKeys(String JsonStr)
    {
        JSONObject JSONobj = new JSONObject(JsonStr);
        String[] Key_Names = JSONObject.getNames(JSONobj);
        return Key_Names;
    }

    //Method to print out string values from Json object 
    public void print_ObjVal_String(String JsonString, String Obj_Name)
    {
        JSONObject obj = new JSONObject(JsonString);
        String strVal = obj.getJSONObject(Obj_Name).getString("JclassStr");
        System.out.println("JclassSTr: "+ strVal);
        
    }

    //Method to print out int values from Json object
    public void print_ObjVal_Int(String JsonString, String Obj_Name)
    {
        JSONObject obj = new JSONObject(JsonString);
        int intVal = obj.getJSONObject(Obj_Name).getInt("Jclassint");
        System.out.println("Jclassint: "+ intVal);
        
    }

    //Method to print out boolean values from Json object
    public void print_ObjVal_Bool(String JsonString, String Obj_Name)
    {
        JSONObject obj = new JSONObject(JsonString);
        boolean boolVal = obj.getJSONObject(Obj_Name).getBoolean("JclassBool");
        System.out.println("JclassBool: "+ boolVal);
        
    }

} 


//This class is used for editing your class that you'll use with the Json classes
//This class is used for variable setting and getting
//methods within this class are only for variables to be put into the json file
class JSONclass
{
    //These variables are only a template
    public String JclassStr = "This string is testing";
    public int Jclassint = 55;
    public boolean JclassBool = true;

    //These methods are only a template
    //All methods should be for setting the varriables in this class
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


