
package kata5p1;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
public class MailListReader {

    
    public List<String> read(String fileName)throws Exception{
        List<String> lista = new ArrayList<>(); 
        File doc = new File(fileName);
        BufferedReader obj = new BufferedReader(new FileReader(doc));
        String aux = "";
        while ((aux = obj.readLine()) != null){
            if(!aux.contains("@")){
                continue;
            }
            lista.add(aux);
        }
        return lista;
    }
}
