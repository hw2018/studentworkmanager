package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.nativejdbc.Jdbc4NativeJdbcExtractor;

import unp.student.work.manager.dao.GroupMeetingDao;
import unp.student.work.manager.domain.GroupMeeting;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupMeetingDaoImpl implements GroupMeetingDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		List gms = (List) new ArrayList<GroupMeeting>();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_meeting where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupMeeting groupMeeting = new GroupMeeting();
				groupMeeting.setId(rs.getInt("meeting_id"));
				groupMeeting.setName(rs.getString("meeting_name"));
				groupMeeting.setGroupId(rs.getInt("group_id"));
				groupMeeting.setStartTime(rs.getDate("meeting_time"));
				groupMeeting.setText(rs.getString("meeting_text"));
				groupMeeting.setSt(rs.getBoolean("meeting_status"));
				gms.add(groupMeeting);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return gms;
	}

	
	public void insert(GroupMeeting groupMeeting) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql= "insert into group_meeting(group_id,meeting_name,meeting_time,meeting_status,meeting_text) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupMeeting.getGroupId());
			pstmt.setString(2, groupMeeting.getName());
			pstmt.setDate(3, new java.sql.Date(groupMeeting.getStartTime().getTime()));
			pstmt.setBoolean(4, groupMeeting.getSt());
			pstmt.setString(5, groupMeeting.getText());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}

	}
	
	public void delete(Integer id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try{
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_meeting where meeting_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
	}
	
	
	public void update(GroupMeeting groupMeeting) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql ="update group_meeting set meeting_name=?,meeting_time=?,meeting_text=? where meeting_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupMeeting.getName());
			pstmt.setDate(2, new java.sql.Date(groupMeeting.getStartTime().getTime()));
			pstmt.setString(3, groupMeeting.getText());
			pstmt.setInt(4, groupMeeting.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}

	}
	
	
	public GroupMeeting findById(Integer id) {
		// TODO Auto-generated method stub
		GroupMeeting groupMeeting = new GroupMeeting();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_meeting where meeting_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				groupMeeting.setGroupId(rs.getInt("group_id"));
				groupMeeting.setId(rs.getInt("meeting_id"));
				groupMeeting.setName(rs.getString("meeting_name"));
				groupMeeting.setSt(rs.getBoolean("meeting_status"));
				groupMeeting.setText(rs.getString("meeting_text"));
				groupMeeting.setStartTime(rs.getDate("meeting_time"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return groupMeeting;
	}

}
