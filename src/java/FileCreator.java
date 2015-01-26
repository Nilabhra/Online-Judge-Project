import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileCreator {
	
	String fileName,content,in="in.txt",userCase,userIn="uin.txt";
        boolean isUserCase;
	public FileCreator(String x,String y,boolean z) {
		// TODO Auto-generated constructor stub
		System.out.println("File Creator...");
		fileName=x;
		content=y;
                isUserCase=z;
	}
	protected void writeUserCase(String x)
        {
            userCase=x;
        }
	protected void createFile()
	{
		File f=new File(fileName);
		File input;
                if(isUserCase){
                    input=new File(userIn);
                if(f.exists())
                    f.delete();
                }                
                else
                    input=new File(in);
                    
                if(isUserCase)
                {
                    try {
                        PrintWriter p=new PrintWriter(input);
                        p.write(userCase);
                        p.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileCreator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                        
		try {                        
                        System.out.println("Input file exits: "+input.exists()+" "+input.getAbsolutePath());
			System.out.println("Source file Created: "+f.createNewFile());
                    try (PrintWriter p = new PrintWriter(f)) {
                        p.println(content);
                    }
			System.out.println(f.getAbsolutePath());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			                 System.out.println(e);
		}
		
	}
}
