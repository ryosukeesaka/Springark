package com.example.demo.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import com.example.demo.Entity.MItemCategory;

public class Csv {
	
	public  void exportCsv(List<MItemCategory> users) {
		
		try {
			
//			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
//			        new FileOutputStream("C:\\temp\\data99.csv", true),"Shift-JIS")));

			FileWriter fw = new FileWriter("C:\\temp\\data3.csv", false);
			 //PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C://temp//test.csv", false)));
			 
			 File f = new File("C:\\temp\\data3.csv");
		      OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(f,false),"Shift-JIS");
		      BufferedWriter bw = new BufferedWriter(osw);
		      bw.write("１行目");
		      bw.newLine();

		      for(int i = 0; i < users.size(); i++){
	                bw.write(users.get(i).getItemCategoryName());
	                bw.write(",");
	                bw.write(users.get(i).getItemCategoryId());
	                bw.write(",");
	        
	            }
		      bw.close();
	           
			 
			 pw.print("社員番号");
	            pw.print(",");
	            pw.print("名前");
	            pw.print(",");
	            pw.print("性別");
	            pw.print(",");
	            pw.print("部署");
	            pw.print(",");
	            pw.print("給料");
	            pw.println();
	            
	            for(int i = 0; i < users.size(); i++){
	                pw.print(users.get(i).getItemCategoryName());
	                pw.print(",");
	                pw.print(users.get(i).getItemCategoryId());
	                pw.print(",");
	                pw.println();
	            }
	            
	            pw.close();
	            
	            // 出力確認用のメッセージ
	            System.out.println("csvファイルを出力しました");
	            
//	            PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
//	                    new FileOutputStream("C:\\Users\\user\\Desktop\\Java\\test.csv", false),"Shift-JIS")));
	            
	        
		
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		 
		
	}

}
