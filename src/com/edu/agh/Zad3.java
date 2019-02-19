package com.edu.agh;

import java.io.*;

public class Zad3 {

        public static void main(String[] args) throws IOException {

            try(InputStream is = new FileInputStream("test.txt");
                OutputStream os = new FileOutputStream("output.txt")) {

                int c;

                while((c = is.read()) != -1)
                    os.write(c);

            } catch(IOException e){
                e.printStackTrace();
            }

            try(Reader fr = new FileReader("test.txt");
                Writer fw = new FileWriter("output1.txt")){
                int c;
                while((c = fr.read()) != -1){
                    fw.write(c);
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try(BufferedReader br = new BufferedReader(new FileReader("test.txt"));
                PrintWriter pw = new PrintWriter((new FileWriter("out2.txt")))){

                String line;
                while((line = br.readLine()) != null){
                    pw.write(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }


}
}
