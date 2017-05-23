package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.mchange.v2.async.StrandedTaskReporting;

import unp.student.work.manager.dao.GroupActDao;
import unp.student.work.manager.domain.GroupAct;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupActDaoImpl implements GroupActDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		// TODO Auto-generated method stub
		List gas =(List) new ArrayList<GroupAct>();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_act where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupAct groupAct = new GroupAct();
				groupAct.setId(rs.getInt("act_id"));
				groupAct.setGroupId(rs.getInt("group_id"));
				groupAct.setName(rs.getString("act_name"));
				groupAct.setActTime(rs.getDate("act_time"));
				groupAct.setSt(rs.getBoolean("act_status"));
				groupAct.setText(rs.getString("act_text"));
				gas.add(groupAct);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return gas;
	}

	
	public void insert(GroupAct groupAct) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "insert into group_act(group_id,act_name,act_time,act_status,act_text) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupAct.getGroupId());
			pstmt.setString(2, groupAct.getName());
			pstmt.setDate(3,  new java.sql.Date(groupAct.getActTime().getTime()));
			pstmt.setBoolean(4, groupAct.getSt());
			pstmt.setString(5, groupAct.getText());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void update(GroupAct groupAct) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "update group_act set act_name=?,act_time=?,act_text=? where act_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupAct.getName());
			pstmt.setDate(2, new java.sql.Date(groupAct.getActTime().getTime()));
			pstmt.setString(3, groupAct.getText());
			pstmt.setInt(4, groupAct.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try{
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_act where act_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null,pstmt,conn);
		}
		
	}

	
	public GroupAct findById(Integer id) {
		// TODO Auto-generated method stub
		GroupAct groupAct = new GroupAct();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_act where act_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				groupAct.setId(rs.getInt("act_id"));
				groupAct.setGroupId(rs.getInt("group_id"));
				groupAct.setName(rs.getString("act_name"));
				groupAct.setActTime(rs.getDate("act_time"));
				groupAct.setSt(rs.getBoolean("act_status"));
				groupAct.setText(rs.getString("act_text"));
				} 
			}catch (SQLException e){
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, pstmt, conn);
			}
			return groupAct;
	}
}
