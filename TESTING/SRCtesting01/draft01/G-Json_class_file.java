import com.google.gson.*;
import java.io.*;

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
    public String ObjectToJSON(JSONclass a)
    {
        Gson objjson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOBJ = objjson.toJson(a);
        return jsonOBJ;
    } 
    //Method to append objects to periosly built .json file
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
            file.write("[\n"+json+"\n"+"]");
            file.close();
            System.out.println("Json successfully Built");
            System.out.println(json);
        }
        catch (IOException e)
        {
            System.out.println("An Error has ocurred");
            e.printStackTrace();
        }
    }

}

//This class is for all methods to read the .json file. 
//This should be used second to the JSONWriter and JSONclass classes
class JSONReader
{

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


