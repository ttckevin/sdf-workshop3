package vttp2022.workshop3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name){
        this.username = name;
        
    }
    public String getUsername() {
        return username;
    }

    public void add(String item){
        for(String inCart: contents)
            if(inCart.equals(item))
            contents.add(item);
    }


    public String delete(int index){
        if( index < contents.size())
            return contents.remove(index);
        return "nothing"; 
    }

   //Normally throws out IO exception
    public void load(InputStream is) throws IOException{
        InputStreamReader isr = new InputStreamReader(is);
        //Raw file reading
        BufferedReader br = new BufferedReader(isr);
        //Buffer reader reads line by line
        String item;
        //Null is use to check the end of file
        while((item = br.readLine()) !=null)
            contents.add(item);
        br.close();
        isr.close();
    }
    
    public void save(OutputStream os) throws IOException{
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);
        for(String item: contents)
            bw.write(item + "\n");
        
        ows.flush();
        bw.flush();
        ows.close();
        bw.close();

    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }



    public void setUsername(String username) {
        this.username = username;
    }

}
