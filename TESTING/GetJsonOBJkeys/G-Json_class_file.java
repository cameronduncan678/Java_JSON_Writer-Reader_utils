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
    //Please add: throws IOException on your main function
    public String getJSON_String(String Path) throws IOException
    {
        String JsonSTR = new String(Files.readAllBytes(Paths.get(Path)), StandardCharsets.UTF_8);
        return JsonSTR;
    } 

    //Method to return an array of object Key Names for further use
    //Needed for retrieving imbeded keys with getJSON_objKeys() 
    public String[] getJSON_Keys(String JsonStr)
    {
        JSONObject JSONobj = new JSONObject(JsonStr);
        String[] Key_Names = JSONObject.getNames(JSONobj);
        return Key_Names;
    }

    //Method to get the keys for values witin the json objects 
    //Use getJSON_Keys() to retrieve the object names 
    public String[] getJSON_objKeys(String JsonStr, String Objname)
    {
        JSONObject mastObj = new JSONObject(JsonStr);
        JSONObject Obj = mastObj.getJSONObject(Objname);
        String[] Key_Names = JSONObject.getNames(Obj);
        return Key_Names;
    }

} 


//JSONclass is an empty parent class 
//to use effectively please add extends JSONclass to your class
class JSONclass{}




