package asw.agents.webService;
 

 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.Collection; 
import java.util.HashMap;
 
import asw.dbManagement.model.Agent;
 
 
public class CsvReader {
 
  private static CsvReader instance;
  //private ReadList loader; 
  private static HashMap<Integer, String> mapa = new HashMap<Integer,String>();

 
  private CsvReader() { 
  }
 
  public static CsvReader getInstance(String path) { 
    if(mapa.isEmpty()) { 
      leerCSV(path);
      return getInstance();
    }
    return getInstance(); 
  }
 
  
  public static CsvReader getInstance() {
    if (instance == null) 
      instance = new CsvReader();
 
    return instance;
 
  }
  
 
  public static void leerCSV(String path) {
    BufferedReader br = null;

        try { 
           br =new BufferedReader(new FileReader(path)); 
           String line = br.readLine(); 
           while (null!=line) { 
              String [] fields = line.split(","); 
              mapa.put(Integer.parseInt(fields[0]),fields[1]);
              line = br.readLine();
          }
        } catch (IOException ioe) {
 
        System.err.println("Problema con la lectura del CSV"); 
        //ReportWriter.getInstance().getWriteReport().log(Level.WARNING, 
            //"Problema con la lectura del CSV");
        }finally { 
          if(br!=null) { 
              try {
            br.close(); 
          } catch (IOException e) { 
            e.printStackTrace();
          } 
          } 
        }
  } 
  
 
  public HashMap<Integer,String> getMapa(){
    return new HashMap<Integer, String>(mapa); 
  }

  
  public int obtainType(String type){    
     Collection<String> suitableTypes =  mapa.values(); 
     int typeNumeric = 0; 
     int contador = 1;
     for(String str:suitableTypes) { 
       if(type.toLowerCase().equals(str.toLowerCase())) { 
         typeNumeric = contador;
         break; 
       } 
       contador++; 
     } 
    return typeNumeric;
 
  }
 
  public boolean checkType(String type, Agent agenteDeLaLey){
      int typeNumeric = obtainType(type);
      if (typeNumeric==agenteDeLaLey.getTipoCode()){
    		  return true; 
      }
      return false;    
    } 
}
 
