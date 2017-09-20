package dao;

import java.sql.*;
import java.util.*;

import bean.RegisterBean;
import pool.DBConnectionMgr;

public class MemberMgr {
	//������ : ��񿬰�
	private DBConnectionMgr pool = null;
	public MemberMgr(){
		try{
		pool = DBConnectionMgr.getInstance();
		}catch(Exception err){
			System.out.println("Ŀ�ؼ� ���� ����");
		}
	}
	//���̵� �ߺ� üũ
	public boolean checkId(String member_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = pool.getConnection();
			String strQuery = "select member_id from members where member_id = ?";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			result = rs.next();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error"+e);
		}finally{
			pool.freeConnection(con, pstmt, rs);
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
			con = pool.getConnection();
			String strQuery = "select * from members";
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while(rs.next()){
				RegisterBean regBean = new RegisterBean();
				regBean.setId(rs.getString("member_id"));
				regBean.setPassword(rs.getString("member_password"));
				regBean.setName(rs.getString("member_name"));
				memberList.addElement(regBean);
			}
		}catch(Exception ex){
			System.out.println("memberRead Error");
		}finally{
			pool.freeConnection(con, pstmt, rs);
		}
		return memberList;
	}
	
	public boolean memberInsert(RegisterBean regBean){
		boolean flag =false;
		Connection con  = null;
		PreparedStatement pstmt = null;
		try{
			con = pool.getConnection();
			String strQuery = "insert into members values(?,?,?)";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, regBean.getId());
			pstmt.setString(2, regBean.getPassword());
			pstmt.setString(3, regBean.getName());
			int count = pstmt.executeUpdate(); //insert sql���� ������� ó���� ������ �����̴�.
			if(count >0){
				flag = true;
			}			
		}catch(Exception ex){
			System.out.println("insert error");
		}finally{
			pool.freeConnection(con,pstmt);
		}	
		return flag;
	}
	
	public boolean loginCheck(String member_id, String member_password){
		boolean loginCon = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = pool.getConnection();
			String sql = "select member_id, member_password from members where member_id=? and member_password=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member_id);
			stmt.setString(2, member_password);
			
			rs = stmt.executeQuery();
			loginCon = rs.next();			
		}catch(Exception ex){
			System.out.println("error");
		}finally{
			pool.freeConnection(con, stmt, rs);
		}
		
		return loginCon; 
	}

	
	//������ ȸ������ ����
	public RegisterBean memberMyRead(String id){
		RegisterBean regBean = new RegisterBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = pool.getConnection();
			String strQuery = "select * from members where member_id=?";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				regBean.setId(rs.getString("member_id"));
				regBean.setPassword(rs.getString("member_password"));
				regBean.setName(rs.getString("member_name"));
				
			}
		}catch(Exception ex){
			System.out.println("memberRead Error");
		}finally{
			pool.freeConnection(con, pstmt, rs);
		}
		return regBean;
	}	
	
}
