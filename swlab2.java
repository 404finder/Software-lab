import java.util.*;
import java.io.*;
public class swlab2 {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		String path=sc.next();	//Get the path to the file.
		int level=sc.nextInt();//Get the required level.
		String ans=yh(path,level);
		System.out.print(ans);
	}
	public static String yh(String path,int level) throws FileNotFoundException {
			Set<String> key=new HashSet<String>();	//Declare a heap to hold all the keywords that need to be counted.
			key.add("auto");
			key.add("break");
			key.add("case");
			key.add("char");
			key.add("const");
			key.add("continue");
			key.add("default");
			key.add("do ");
			key.add("double");
			key.add("else");
			key.add("enum");
			key.add("extern");
			key.add("float");
			key.add("for");
			key.add("goto");
			key.add("if");
			key.add("int");
			key.add("long");
			key.add("register");
			key.add("return");
			key.add("short");
			key.add("signed");
			key.add("sizeof");
			key.add("static");
			key.add("struct");
			key.add("switch");
			key.add("typedef");
			key.add("union");
			key.add("unsigned");
			key.add("void");
			key.add("wolatile");
			key.add("while"); 
			int [] csarray=new int[100];	//Declares an array to hold the number of "cases" for each group of switches.
			FileReader file=new FileReader(path); //read file.
			BufferedReader inBR=new BufferedReader(file);
			
			Deque<String> stack=new LinkedList<String>();	//Declare a stack.
			String str=null;
			String ans="";
			int countsw=0,countcs=0,countifelse=0,countifelseif=0,total=0,swnum=-1;
		try {
			while((str=inBR.readLine())!=null) {
				
			//level 1 Count the total number of keywords.
				
			for(String str2:key) {
				if(str.contains(str2)) {
					total++;
				}
		    }
			
			//level 2 Calculate the total number of "switch" and the corresponding number of "case".
			
			if(str.contains("switch")) {
				countsw++;
				swnum++;
			}
			if(str.contains("case")) {
				csarray[swnum]++;
			}
			
			//level 3 and 4 Count how many "if-else"and "if-else if-else" there are, and push any statement that contains an "if" onto the stack.
			
			if(str.contains("if")||str.contains("else if")) {
				stack.push(str);
			}
			//If "else" is encountered, the first one in the stack is pop out until an "if" is pop out.
			else if(str.contains("else")) {
				String str1=stack.pop();
				boolean haselseif=false;
				while(str1.contains("else if")) {
					haselseif=true;
					str1=stack.pop();
				}
				if(haselseif) {
					countifelseif++;
				}else {
					countifelse++;
				}
				
			}	
			}
			
			//display each count by different level.
			if(level==1) {
				ans+="total num:"+total+"\n";
			}if(level==2) {
				ans+="total num:"+total+"\n";
				ans+="switch num:"+countsw+"\n";
				ans+="case num:";
				for(int i=0;i<swnum+1;i++) {
					ans+=csarray[i]+" ";
				}
			}if(level==3) {
				ans+="total num:"+total+"\n";
				ans+="switch num:"+countsw+"\n";
				ans+="case num:";
				for(int i=0;i<swnum+1;i++) {
					ans+=csarray[i]+" ";
				}
				ans+="\n";
				ans+="if-else num:"+countifelse+"\n";
			}if(level==4) {
				ans+="total num:"+total+"\n";
				ans+="switch num:"+countsw+"\n";
				ans+="case num:";
				for(int i=0;i<swnum+1;i++) {
					ans+=csarray[i]+" ";
				}
				ans+="\n";
				ans+="if-else num:"+countifelse+"\n";
				ans+="if-elseif-else num:"+countifelseif+"\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           return ans;
	}
}
