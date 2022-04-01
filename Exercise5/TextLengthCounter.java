package TCPclientTextLength;

/**
 * 
 * @author qiaohui
 *
 */

public class TextLengthCounter {
	/**
	 * This method count length of text.
	 * 
	 * @return length
	 */
	public int getTextLength(String text) {
		
		 int length = 0;  
	      
         char ch[]= new char[text.length()];     
         for(int i=0;i<text.length();i++)  
         {  
             ch[i]= text.charAt(i);  
             if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
            	 length++;  
         }   
		
		return length;
		
	}
}