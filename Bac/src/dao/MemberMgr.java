package dao;

import java.sql.*;
import java.util.*;

import bean.RegisterBean;
import connector.DBConnectionMgr;

public class MemberMgr {
	//������ : ��񿬰�
	private DBConnectionMgr connector = null;
	public MemberMgr(){
		try{
		connector = DBConnectionMgr.getInstance();
		}catch(Exception err){
			System.out.println("connection error");
		}
	}
	//���̵� �ߺ� üũ
	public boolean checkId(String member_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = connector.getConnection();
			String strQuery = "select member_id from members where member_id = ?";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			result = rs.next();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error"+e);
		}finally{
			connector.freeConnection(con, pstmt, rs);
		}
				
		return result;
	}
	
	//������ ȸ������ ����
	public Vector memberRead(){
		Vector memberList = new Vector();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = connector.getConnection();
			String strQuery = "select * from members";
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while(rs.next()){
				RegisterBean regBean = new RegisterBean();
				regBean.setMember_id(rs.getString("member_id"));
				regBean.setMember_pw(rs.getString("member_pw"));
				regBean.setMember_name(rs.getString("member_name"));
				memberList.addElement(regBean);
			}
		}catch(Exception ex){
			System.out.println("memberRead Error");
		}finally{
			connector.freeConnection(con, pstmt, rs);
		}
		return memberList;
	}
	//ȸ������
	public boolean memberInsert(RegisterBean regBean){
		boolean flag =false;
		Connection con  = null;
		PreparedStatement pstmt = null;
		try{
			con = connector.getConnection();
			String strQuery = "insert into members values(?,?,?)";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, regBean.getMember_id());
			pstmt.setString(2, regBean.getMember_pw());
			pstmt.setString(3, regBean.getMember_name());
			int count = pstmt.executeUpdate(); //insert sql���� ������� ó���� ������ �����̴�.
			if(count >0){
				flag = true;
			}			
		}catch(Exception ex){
			System.out.println("insert error");
		}finally{
			connector.freeConnection(con,pstmt);
		}	
		return flag;
	}
	//�α��� 
	public boolean loginCheck(String member_id, String member_pw){
		boolean loginCon = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = connector.getConnection();
			String sql = "select member_id, member_pw from members where member_id=? and member_pw=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member_id);
			stmt.setString(2, member_pw);
			
			rs = stmt.executeQuery();
			loginCon = rs.next();			
		}catch(Exception ex){
			System.out.println("error");
		}finally{
			connector.freeConnection(con, stmt, rs);
		}
		
		return loginCon; 
	}

	
	//������ ȸ������ ����
	public RegisterBean memberMyRead(String member_id){
		RegisterBean regBean = new RegisterBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = connector.getConnection();
			String strQuery = "select * from members where member_id=?";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				regBean.setMember_id(rs.getString("member_id"));
				regBean.setMember_pw(rs.getString("member_pw"));
				regBean.setMember_name(rs.getString("member_name"));
			}
		}catch(Exception ex){
			System.out.println("memberRead Error");
		}finally{
			connector.freeConnection(con, pstmt, rs);
		}
		return regBean;
	}	
	
}
