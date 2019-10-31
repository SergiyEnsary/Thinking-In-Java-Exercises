package chapter17practices;

import java.io.*;

public class DirectoryDemo {
  public static void main(String[] args) {
    
    PPrint.pprint(Directory.walk(".").dirs);
    
    for(File file : Directory.local(".", "T.*"))
      System.out.print(file);
    System.out.print("----------------------");
    
    for(File file : Directory.walk(".", "T.*\\.java"))
    	System.out.print(file);
    System.out.print("======================");
    
    for(File file : Directory.walk(".",".*[Zz].*\\.class"))
    	System.out.print(file);
  }
}