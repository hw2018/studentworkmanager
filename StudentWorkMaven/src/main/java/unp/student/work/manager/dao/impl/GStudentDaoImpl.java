package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.support.nativejdbc.Jdbc4NativeJdbcExtractor;

import unp.student.work.manager.utils.*;
import unp.student.work.manager.dao.GStudentDao;
import unp.student.work.manager.domain.GStudent;

public class GStudentDaoImpl implements GStudentDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	
	public List findByGid(Integer id) {
		List gStudents = (List) new ArrayList<GStudent>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_student where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GStudent gStudent = new GStudent();
				gStudent.setId(rs.getInt("id"));
				gStudent.setGroupId(rs.getInt("group_id"));
				gStudent.setJob(rs.getString("job"));
				gStudent.setStuno(rs.getString("stuno"));
				gStudents.add(gStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return gStudents;
	}

	
	public void insert(GStudent gStudent) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into group_student(group_id, job,stuno) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gStudent.getGroupId());
			pstmt.setString(2, gStudent.getJob());
			pstmt.setString(3, gStudent.getStuno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void update(GStudent gStudent) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql ="update group_student set stuno=?,job=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gStudent.getStuno());
			pstmt.setString(2, gStudent.getJob());
			pstmt.setInt(3, gStudent.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}
	
	public GStudent findById(Integer id){
		GStudent gStudent = new GStudent();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				gStudent.setId(rs.getInt("id"));
				gStudent.setGroupId(rs.getInt("group_id"));
				gStudent.setJob(rs.getString("job"));
				gStudent.setStuno(rs.getString("stuno"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return gStudent;
	}
	
	public List findByStuno(String id){
		List gStudents = (List) new ArrayList<GStudent>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_student where stuno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GStudent gStudent = new GStudent();
				gStudent.setId(rs.getInt("id"));
				gStudent.setGroupId(rs.getInt("group_id"));
				gStudent.setJob(rs.getString("job"));
				gStudent.setStuno(rs.getString("stuno"));
				gStudents.add(gStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return gStudents;
	}
}
