package atm;
import java.io.Serializable;

public class Cashload   {
      int loadCash=0;
      public  Cashload() {
    	  
      }
      public  Cashload(int amt) {
   	   this.loadCash=amt;
       }
      public void setCash(int amt ) {
    	  this.loadCash+=amt;
      }
     public  int getCash() {
    	 return loadCash;
     } 
     public  void  remaining_cash(int amt) {
    	this.loadCash=amt;
    	
     }

}
