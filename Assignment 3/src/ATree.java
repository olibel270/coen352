import java.io.*; 

public class ATree {
	//Test BST implementation
	public static void main(String[] args)throws Exception 
	  { 
	  File file = new File("src/" + args[0]); 
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  String st; 
	  while ((st = br.readLine()) != null) 
	    if (st.charAt(0)=='a')
	    	System.out.println("ADD: " + st);
	    else if (st.charAt(0)=='f')
	    	System.out.println("FIND: " + st);
	    else if (st.charAt(0)=='r')
	    	System.out.println("REMOVE: " + st);
	  br.close();
	  } 
}
