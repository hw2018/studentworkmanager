package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unp.student.work.manager.utils.*;
import java.util.List;

import javax.persistence.NamedNativeQueries;

import unp.student.work.manager.dao.GStudentDao;
import unp.student.work.manager.domain.GStudent;
import unp.student.work.manager.dao.GroupDao;
import unp.student.work.manager.domain.Group;
import unp.student.work.manager.dao.GStudentDao;
import unp.student.work.manager.dao.impl.GStudentDaoImpl;

public class GroupDaoImpl implements GroupDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	
	public List findAll() {
		List groups = (List) new ArrayList<Group>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_info";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("group_name"));
				group.setDescription(rs.getString("group_description"));
				group.setRes(rs.getString("res_name"));
				group.setCreateTime(rs.getDate("group_time"));
				groups.add(group);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return groups;
	}

	
	public void insert(Group group) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into group_info(group_name, group_description, res_name, group_time) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setString(2, group.getDescription());
			pstmt.setString(3, group.getRes());
			// 需要把java.util.Date 转为 java.sql.Date
			pstmt.setDate(4, new java.sql.Date(group.getCreateTime().getTime()));
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_info where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}

	}

	public void update(Group group) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update group_info set group_name=?,res_name=?,group_description=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setString(2, group.getRes());
			pstmt.setString(3, group.getDescription());
			pstmt.setInt(4, group.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public Group findById(Integer id){
		Group group =new Group();
		try{
			conn= JDBCUtil.getConnection();
			String sql = "select * from group_info where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("group_name"));
				group.setDescription(rs.getString("group_description"));
				group.setRes(rs.getString("res_name"));
				group.setCreateTime(rs.getDate("group_time"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return group;
	}
	
	public List findByStuno(String id){
		List groups = (List) new ArrayList<Group>();
		GStudentDao gStudentDao=new GStudentDaoImpl();
		Group group =new Group();
		List<GStudent> gstudents = (List<GStudent>) gStudentDao.findByStuno(id);
		try{
			conn = JDBCUtil.getConnection();
			for(GStudent gStudent :gstudents){
				String sql = "select * from group_info where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gStudent.getGroupId());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					group.setId(rs.getInt("id"));
					group.setName(rs.getString("group_name"));
					group.setDescription(rs.getString("group_description"));
					group.setRes(rs.getString("res_name"));
					group.setCreateTime(rs.getDate("group_time"));
				}
				groups.add(group);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return groups;
	}

}
