package testtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	public int checkId(String usrid) throws Exception{
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   int re = 0;
		   try{
		          con = db.getConnection();
		    String selectSQL="select * from user_t where usrid=?";
		    pstmt = con.prepareStatement(selectSQL);
		    pstmt.setString(1,usrid);
		    ResultSet rs = pstmt.executeQuery();
		    if(rs.next()){
		     re = 1;
		    }
		   }finally{
		    db.close(con,pstmt);
		   }
		   return re;
		 }//end list()
}
