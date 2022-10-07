package atm;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustDetails implements Serializable {
 static List<Customers>  l=new ArrayList<>();
static int p=0;
   public  List<Customers> getDetails(){
	//  List<Customers> l1=new ArrayList<Customers>();
	
	Customers c1=new Customers(2372745,"manikandan","9843319089","3/5/2001",5000,9843);
	Customers c2=new Customers(2372746,"harish","9843319088","3/6/2002",5000,9790);
	Customers c3=new Customers(2372747,"poomani","9843319087","3/8/2000",5000,9585);
	Customers c4=new Customers(2372748,"suresh","9843319086","1/4/2003",5000,9943);
//    Customers a[]=new Customers[] {c1,c2,c3,c4};
	if(p==0) {
       l.add(c1);
       l.add(c2);
       l.add(c3);
       l.add(c4);
    p=1;
	}//       l1.addAll(l);
//       l.removeAll(l1);
      return l;
 
     }
     
} 
   
