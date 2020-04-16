import java.io.IOException;

import com.google.gson.stream.JsonReader;

import org.json.*;

import java.util.*;

public class main
{
    public static void main(String[]args)throws IOException
    {
        /*
        JSONReader Reading = new JSONReader();
        String json_str = Reading.getJSON_String("V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\JsonGetvals\\outTest.json");


        String[] keyArray = Reading.getJSON_Keys(json_str);
        // JSONObject mastObj = new JSONObject(json_str);
        //int parse_value = mastObj.getJSONObject("JsonTestObj").getInt("valueBase");
        System.out.println();
        String[] objkeyArray = Reading.getJSON_objKeys(json_str, keyArray[0]);
        for (int i = 0; i < keyArray.length; i++){}
        for (int i = 0; i < objkeyArray.length; i++){}
        System.out.println();
        String[] objkeyArray2 = Reading.getJSON_objKeys(json_str, keyArray[1]);
        for (int i = 0; i < objkeyArray2.length; i++){}
        */

        JSONReader Wread = new JSONReader();
        String secondTest = Wread.getJSON_String("V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\TESTING\\JsonGetvals\\secondtest.plist");
        String[] obj_keys = Wread.getJSON_Keys(secondTest);

        Scanner ScanInput = new Scanner(System.in);
        int userinput = ScanInput.nextInt();
        String[] value_keys = Wread.getJSON_objKeys(secondTest, obj_keys[userinput]);
        System.out.println();
        //String[] objkeys = Wread.getJSON_objKeys(secondTest, keysobj[2]);

        for(int i = 0; i < value_keys.length; i++){}

        ScanInput.close();



        
         
    }
}

class Tester extends JSONclass
{
    int valueBase = 4;
    int monthCurrent = 4;
    String Priority = "Top: please attend first";
}

/*
public int GetJSON_Int(String JsonString, String JsonObject, String KeyName)
{
    JSONObject mastObj = new JSONObject(JsonString);
    int parse_value = mastObj.getJSONObject(JsonObject).getInt(KeyName);
    return parse_value;
}
*/

