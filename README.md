# Java_JSON_Writer-Reader_utils

Easy to use functions for reading and writing to JSON files using the GSON and org.json library.  These are for ease of use on Personal projects and not for commercial reasons.

To use the methods in this project copy and paste:

G-Json_class_file.java

Into the project directory with your .java file.  
So all methods work please copy and paste:

DIR .vscode

Into the project directory with your .java file.
You can also add the .jar files in the Externals folder.  
These contain the necessary libraries used for the classes.
The libraries inclue the Gson library and org.json library.  
These are available in the Externals directory or at these links:

Gson:
filename// gson-2.8.6.jar
weblink//  https://search.maven.org/artifact/com.google.code.gson/gson/2.8.6/jar

org.json:
filename// json-20190722.jar
weblink//  https://github.com/stleary/JSON-java

You will will also need to add a throws IOException to your main function in order for the classes to function.

-----------------------------------------------------------------------------------------------------------------------

#CLASSES

The following contains info on all the classes and their methods.  Please read to familiarize with the working order of these classes.  

The class library contains 4 classes:

-JSONWriter
-JSONReader
-JSONEditor
-JSONClass

Folowing contains indepth info on each class

-----------------------------------------------------------------------------------------------------------------------

# CLASS|| JSONWriter

The JSONWriter class is used to build an initial .json file with java.  This class is necessary for use with any other class in this library.  

Follows is a breakdown of all the variables and methods in the class


# var|| private String path;

This variable is used for storing the file path to the .json file to be created.  This must be initialised first before any methods are used for building the .json file.

# var|| private String file_name;

This variable is used for storing the file name of the .json file to be created.  This must be initialised first before any methods are used for building the .json file.

# method|| public void configureJSONPath(String setpath)

This method can be used to initialise the path variable for the class.  Use this to set a custom path for the .json file.  This method takes a string value.  

#method|| public void configureJSONfileName(String setfname)

This method can be used to initialise the file_name variable for the class.  Use this to set a custom file name for the .json file.  This method takes a string value.

#method|| public String ObjectToJSON(JSONClass a, String OBJname)

This method can be used to build a JSON Object from a pre made class (*see JSONClass to see how to set custom class*).  The method will return a string value which you can write to the .json file or append to another string initialised using this method.  Method takes a JSONClass and a String value which will be used to name the JSON object.   

#method|| public String AppendToJSON(String json, String ap)

This method can be used to combine two JSON strings built with ObjectToJSON() method.  This returns a string value for use in writing to the .json file.  The method takes two strings, input two JSON strings built with ObjectToJSON() method.

#method|| public void BuildJSON(String json)

This method is a final build method used to write the initial .json file from strings made with ObjectToJSON() and AppendToJSON() methods. This method takes a single JSON string so it is advised to use AppendToJSON() on any loose json strings before using this method.  It is also important that you configure the path and file name with configureJSONPath() and configureJSONfileName() before using this method.  

-----------------------------------------------------------------------------------------------------------------------

#CLASS JSONReader

The JSONReader class is used to read a.json file with java and collect values.  To use this class effectively it is advised you use the JSONWriter class methods before hand to create a .json file.  If not this may result in unwanted results.  

Follows is a breakdown of all the variables and methods in the class

#method|| public String JSON_String(String Path) 

This method will convert the entire .json file to a string value that can be used in your program.  The method takes a string value.  This is a path to your .json file.  Make sure to include the file name followed by .json in your string value.  

#method|| public String[] getJSON_Keys(String JsonStr)

This method is used to retrieve the key names of the .json JSON objects.  The method will push these to an array.  Be aware due to the unpredictability usually found with .json files, keys will sometimes appear out of order.  This method takes a JSON string which can be generated with JSON_String().  

#method|| public String[] getJSON_objKeys(String JsonStr, String Objname)

This method can be used to retrieve the key names for values within the seperate JSON objects.  To retrieve key names for objects use getJSON_Keys().  This method takes a JSON string whic can be generated with JSON_String(). The method also takes an object name string.  You can find object names with the getJSON_Keys() method. 

#method|| public intGetJVAL_Int(String JsonString, String JsonObject, String KeyName)

This method can be used to retrieve specific int values from the JSON objects within the .json file.  This method takes a JSON string (which can be retrieved with JSON_String()), a JSON object name (which can be retrieved with getJSON_Keys()), and a specific value keyname (which can be retrieved with getJSON_objKeys()).  

#method|| public String GetJVAL_String(String JsonString, String JsonObject, String KeyName)

This method can be used to retrieve specific String values from the JSON objects within the .json file.  This method takes a JSON string (which can be retrieved with JSON_String()), a JSON object name (which can be retrieved with getJSON_Keys()), and a specific value keyname (which can be retrieved with getJSON_objKeys()). 

#method|| public boolean GetJVAL_Bool(String JsonString, String JsonObject, String KeyName)

This method can be used to retrieve specific boolean values from the JSON objects within the .json file.  This method takes a JSON string (which can be retrieved with JSON_String()), a JSON object name (which can be retrieved with getJSON_Keys()), and a specific value keyname (which can be retrieved with getJSON_objKeys()).

-----------------------------------------------------------------------------------------------------------------------

#CLASS|| JSONEditor

The JSONEditor class is used to edit a.json file with java and collect values.  To use this class effectively it is advised you use the JSONWriter class methods before hand to create a .json file.  If not this may result in unwanted results.  

Follows is a breakdown of all the variables and methods in the class

# method|| public void deleteJSON_file(String Path, String FileName)

This method can be used to delete the entire .json file.  The method takes a string for the file path and one for the file name.  

#method||  public void deleteJSON_object(String Path, String FileName, String JSONobj)

This metod is used to delete a JSON object from the file and overwrite the file without the JSON object.  It is advised you use the JSONWriter class to build a .json file to be used with this, otherwise this could result in unexpected results.  The method takes a string value for the file path, a string value for the file name and a string value for the object key (you can use the JSONReader::getJSON_Keys() method to retrieve object keynames)

-----------------------------------------------------------------------------------------------------------------------

#CLASS|| JSONClass

The JSONEditor class is used to interact with the classes above. The class contains no variables or methods and is intended as a parent class.  You will need to use this class to use methods in the JSONWriter class.  To use the class set an extends followed by the class name with your own class(es).  


