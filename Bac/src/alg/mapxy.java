package alg;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; 



public class mapxy {
   
   
   
   public static void main(String[] args) throws SQLException, SAXException, IOException, ParserConfigurationException {
        ArrayList<clip> list = new ArrayList<clip>();
        //List<Person> personlist = new List<Person>();
        try {
            // Step 1: Load the JDBC driver. jdbc:mysql://localhost:3306/travel
            Class.forName("com.mysql.jdbc.Driver");
 
            // Step 2: Establish the connection to the database.
            String url = "jdbc:mysql://203.253.70.34:3306/backpackers?autoReconnect=true";
            Connection conn = DriverManager.getConnection(url, "user2015", "!user2015");
            Statement st = conn.createStatement();
            ResultSet srs = st.executeQuery("SELECT * FROM clipboard");
            while (srs.next()) {
               clip place = new clip(null, null, null);
               place.setClip_code(srs.getString("clip_code"));
               place.setMapy(srs.getString("mapy"));
               place.setMapx(srs.getString("mapx"));
                list.add(place);
            }
 
            System.out.println(list.size());
           /*for(int i=0;i<list.size();i++){
                //System.out.println(list.get(i)); // 이렇게 하니깐 위치값 출력
                

            System.out.println(list.get(i).getClip_code());
            System.out.println(list.get(i).getMapy());
            System.out.println(list.get(i).getMapx()); 
           
           // System.out.println(list.get(0));
            }*/
         
               
        //System.out.println(list.);
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    //}
   
    //public void openapi(String[] args)throws SAXException, IOException, ParserConfigurationException {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         for(int s=1;s<list.size();s++){
            for(int e=1;e<list.size();e++){
               String adjacency_matrix[][] = new String[list.size() + 1][list.size() + 1];
               //if(s==e){System.out.println(999);}
               if(s==e){adjacency_matrix[s][e] = "999";}
               else{
         Document doc = builder.parse("http://api.openapi.io/traffic/appletree/v1/0/Path/PathSearch_Exit.asp?"

          + "SY="+ list.get(s).getMapy()   // 온도 표시 C or F

          + "&SX="+ list.get(s).getMapx()   // 국가 

          + "&EY="+ list.get(e).getMapy()
          + "&EX=" + list.get(e).getMapx()
          + "&x_api_key=" + get(s)
               //+ "SY="+ 37.505157232495456   // 온도 표시 C or
                //+ "&SX="+ 127.05709893474192   // 국가 

                //+ "&EY="+ 37.551111761905204
                //+ "&EX=" + 126.98784838350313
          + "&changeCount=5&optCount=1&resultCount=10&OPT=0&encoding=utf- 8&output=xml&radius=700:2000&weightTime=10:5:5:10:10:5&svcid=f78480bc1c06734607e4c7107d0642f3");  // 도시

        
      //xml���ϰ��
         System.out.println( get(s));
         
         
      NodeList list1 = doc.getElementsByTagName("info");
        for(int j=0; j<list1.getLength(); j++){
         for(Node node = list1.item(j).getFirstChild(); node!=null; node=node.getNextSibling()){
            if (node.getNodeName().equals("totalTime")){
               String a= node.getTextContent();
               
               adjacency_matrix[s][e] = node.getTextContent();
               }
               /*if (node.getNodeName().equals("totalWalk")){
                  //System.out.println("----------");
                  System.out.println(node.getTextContent());
               }*/
         }
         
         /*NodeList list2 = doc.getElementsByTagName("subPath");
                 for(int j=0; j<list2.getLength(); j++){
                  for(Node node2 = list2.item(j).getFirstChild(); node2!=null;  node2=node2.getNextSibling()){
                     if (node2.getNodeName().equals("startX")){
                        System.out.println("===="+node2.getTextContent()+"====");}
                        if (node2.getNodeName().equals("startY")){
                           //System.out.println("----------");
                           System.out.println(node2.getTextContent());
                        }
                        if (node2.getNodeName().equals("endX")){
                           System.out.println("===="+node2.getTextContent ()+"====");}
                           if (node2.getNodeName().equals("endY")){
                              //System.out.println("----------");
                              System.out.println(node2.getTextContent());
                           }
                  }
                 }*/
            
            
            }
         }//else
               System.out.println(adjacency_matrix[s][e]);
               
               
               
        }//for문e
         }//for문s
   }
   
   
   // TODO Auto-generated method stub
   
public static String get(int s) {
   // TODO Auto-generated method stub
   int i = s;
   String[] key = new String[8];
   //key[0] = "MjQ1NS0xNDI4NjczNjg3ODI4LWQzYTE2ZDNlLWE0M2QtNDg0MS1hMTZkLTNlYTQzZDI4NDE4MA==";
   key[1] = "MjQ1Ni0xNDI4Njk3MDI2MTE0LTAwNDEwNjk0LTY5MjQtNGViMC04MTA2LTk0NjkyNGFlYjBlYQ==";
   key[2] = "MjU3NS0xNDMyMDEyNzA0NTQ4LWM0MWIxYWQ2LWMxMzMtNDQ0Mi05YjFhLWQ2YzEzMzU0NDI1MQ==";
   key[3] = "MjU3Ni0xNDMyMDEzMzYwMjU3LTJhNzBkNGRkLWNlNzktNDc0OC1iMGQ0LWRkY2U3OTg3NDg3NA==";
   key[4] = "MjM4NS0xNDI2NjgwMjg0MzI4LTJiMTAxYTgyLWI2ODgtNDYwYy05MDFhLTgyYjY4OGQ2MGNjMw==";
   
   key[5] = "MjQ0NC0xNDI4NDMyNDg0NDU5LWVlYzRkYjE1LTI0ZTQtNGJmNS04NGRiLTE1MjRlNGViZjVkOQ==";
   key[6] = "MjU3My0xNDMxOTc4NDYxMTc5LTM5ZTc0OTk1LWU4OWEtNDkzYi1hNzQ5LTk1ZTg5YTU5M2IwNg==";
   key[7] = "MjU3OS0xNDMyMDE4NDc5OTgwLTMxNzJlNGRkLWNjNDctNGVlNi1iMmU0LWRkY2M0NzhlZTZhZQ==";
   if(i<=7){
   return key[i];
   }
   else if(7<i && i<=14){
      return key[i-7];
      
   }
   else{
      return key[i-14];
   }
}

/*
private String Key;
   public String getKey() {
       return Key;
    }
    public void setKey(String key) {
       this.Key = key;
    }
  */ 
}
