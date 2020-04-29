import java.io.IOException;

public class main 
{

    public static void main(String[]args)throws IOException
    {
        DesignJob Job1 = new DesignJob();

        String json_path = "V:\\Pictures\\Coding_Programming\\Projects\\Java_JSON_Writer-Reader_utils\\OPTIMISE\\phase01\\";
        String json_name = "optimise.json";

        JSONWriter Jwrite = new JSONWriter(json_path, json_name);
        
        String initJson = Jwrite.ObjectToJSON(Job1, "McDesignerBob");

        Jwrite.BuildJSON(initJson);

        JSONReader Jread = new JSONReader(json_path, json_name);

        String Jstr = Jread.JSON_String();

        String JobjStr = Jread.GetJVAL_String(Jstr, "McDesignerBob", "design");

        System.out.println(JobjStr);

        JSONEditor Jedit = new JSONEditor(json_path, json_name);

        String open = Jedit.OPENjson(Jstr);

        System.out.println(open);

        Hackboggie slim = new Hackboggie();

        String newobj = Jwrite.ObjectToJSON(slim, "Hackboogie");

        String overide = Jwrite.AppendToJSON(open, newobj);

        Jwrite.BuildJSON(overide);

        

    }

}

class DesignJob extends JSONclass
{
    String design = "poster";
    String designer = "Malcom mcPretentios";
    int work_completed = 5;
}

class Hackboggie extends JSONclass
{
    String blobby = "walalaa";
    String sagungun = "eck";
    int BAH = 9;
    boolean finby = true;
}