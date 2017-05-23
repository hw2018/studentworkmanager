package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unp.student.work.manager.dao.GroupWorkDao;
import unp.student.work.manager.domain.GroupWork;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupWorkDaoImpl implements GroupWorkDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		// TODO Auto-generated method stub
		List gws = (List) new ArrayList<GroupWork>();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_work where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupWork groupWork = new GroupWork();
				groupWork.setId(rs.getInt("id"));
				groupWork.setGroupId(rs.getInt("group_id"));
				groupWork.setTime(rs.getInt("work_time"));
				groupWork.setPlace(rs.getString("work_place"));
				groupWork.setStuno(rs.getString("stuno"));
				gws.add(groupWork);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return gws;
	}

	
	public void insert(GroupWork groupWork) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "insert into group_work(id,group_id,work_time,work_place,stuno) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupWork.getId());
			pstmt.setInt(2, groupWork.getGroupId());
			pstmt.setInt(3, groupWork.getTime());
			pstmt.setString(4, groupWork.getPlace());
			pstmt.setString(5, groupWork.getStuno());
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void update(GroupWork groupWork) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "update group_work set work_place=?,stuno=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupWork.getPlace());
			pstmt.setString(2, groupWork.getStuno());
			pstmt.setInt(3, groupWork.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public GroupWork findById(Integer id) {
		// TODO Auto-generated method stub
		GroupWork groupWork = new GroupWork();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_work where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				groupWork.setId(rs.getInt("id"));
				groupWork.setGroupId(rs.getInt("group_id"));
				groupWork.setTime(rs.getInt("work_time"));
				groupWork.setPlace(rs.getString("work_place"));
				groupWork.setStuno(rs.getString("stuno"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return groupWork;
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try{
			conn = JDBCUtil.getConnection();
			String sql ="delete from group_work where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}
	
	public GroupWork findByGIdAndTime(Integer id,Integer time){
		GroupWork groupWork = new GroupWork();
		try{
			conn = JDBCUtil.getConnection();
			String sql ="select * from group_work where group_id=? and work_time=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, time);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				groupWork.setId(rs.getInt("id"));
				groupWork.setGroupId(rs.getInt("group_id"));
				groupWork.setTime(rs.getInt("work_time"));
				groupWork.setPlace(rs.getString("work_place"));
				groupWork.setStuno(rs.getString("stuno"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return groupWork;
	}

}
