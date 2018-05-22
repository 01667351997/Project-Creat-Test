package listrandom;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
/**
 *
 * @author binhminh
 */
public class CreateListInt {
    public ArrayList ListInt (int n,int total){
        ArrayList list = new ArrayList();
        
        Random rd = new Random();
        Vector v = new Vector();
        
        int iNew = 0;
        for (int i = 0; i < n;  ) {
            iNew = rd.nextInt(total);
            if (!v.contains(iNew)){
                i++;
                v.add(iNew);
                list.add(iNew);
            }
        }  
        return list;
    }
    
    
    
}
