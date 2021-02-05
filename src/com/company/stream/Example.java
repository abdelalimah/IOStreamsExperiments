package com.company.stream;

import java.io.*;
import java.util.Scanner;

public class Example {

    public Example() {
        //exp01();
        //exp02();
        //exp03();
        exp04();
    }

    public void exp01(){
        //writing to a file
        try(
                Scanner in = new Scanner(System.in);
                BufferedWriter out = new BufferedWriter(new FileWriter("resources/test.txt",true));
                ){



            String msg = in.nextLine();
            System.out.println("the message is the following : "+msg);

            out.write(msg);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void exp02(){
        try(
                BufferedReader in = new BufferedReader(new FileReader("resources/test.txt"));
                ){

            StringBuilder msg = new StringBuilder();

            int i = in.read();

            while(i != -1){
                msg.append((char) i);
                i=in.read();
            }

            System.out.println(msg);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void exp03(){
        try(
                Scanner in = new Scanner(System.in);
                FileOutputStream out = new FileOutputStream("resources/test.txt");
                ){

            byte b = in.nextByte();
            while(true){
                out.write(b);
                b = in.nextByte();
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void exp04(){
        try(
                FileInputStream in = new FileInputStream("resources/test.txt");
                ){

            byte[] b = new byte[10];
            in.read(b);

            for (byte i:
                 b) {
                System.out.println((char)i);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example();
    }
}
