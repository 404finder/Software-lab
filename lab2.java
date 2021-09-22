import java.util.*;
import java.io.*;
public class lab2 {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		//Get the path to the file.
		String path=sc.next();
		//Get the required level.
		int level=sc.nextInt();
		//read file
		FileReader file=new FileReader(path);
		BufferedReader inBR=new BufferedReader(file);
		String str=null;
		//Declare a stack.
		Deque<String> stack=new LinkedList<String>();
		//Declares an array to hold the number of "cases" for each group of switches.
		int [] csarray=new int[100];
		int swnum=-1;
		int countsw=0,countcs=0,countifelse=0,countifelseif=0,total=0;
		//Declare a heap to hold all the keywords that need to be counted.
		Set<String> key=new HashSet<String>();
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
				System.out.println("total num:"+total);
			}if(level==2) {
				System.out.println("total num:"+total);
				System.out.println("switch num: "+countsw);
				System.out.println("case num:");
				for(int i=0;i<swnum+1;i++) {
					System.out.print(csarray[i]+" ");
				}
			}if(level==3) {
				System.out.println("total num:"+total);
				System.out.println("switch num: "+countsw);
				System.out.print("case num:");
				for(int i=0;i<swnum+1;i++) {
					System.out.print(csarray[i]+" ");
				}
				System.out.println();
				System.out.println("if-else num:"+countifelse);
			}if(level==4) {
				System.out.println("total num:"+total);
				System.out.println("switch num: "+countsw);
				System.out.print("case num:");
				for(int i=0;i<swnum+1;i++) {
					System.out.print(csarray[i]+" ");
				}
				System.out.println();
				System.out.println("if-else num:"+countifelse);
				System.out.println("if-elseif-else num:"+countifelseif);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}