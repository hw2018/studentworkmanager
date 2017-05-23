package unp.student.work.manager.dao.impl;

import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unp.student.work.manager.dao.GroupSupportDao;
import unp.student.work.manager.domain.GroupSupport;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupSupportDaoImpl implements GroupSupportDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		// TODO Auto-generated method stub
		List gsps = (List) new ArrayList<GroupSupport>();
		try{
			conn =JDBCUtil.getConnection();
			String sql = "select * from group_support where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupSupport groupSupport = new GroupSupport();
				groupSupport.setId(rs.getInt("id"));
				groupSupport.setGroupId(rs.getInt("group_id"));
				groupSupport.setMoney(rs.getInt("support_money"));
				groupSupport.setName(rs.getString("support_name"));
				groupSupport.setActId(rs.getInt("act_id"));
				groupSupport.setText(rs.getString("support_text"));
				gsps.add(groupSupport);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return gsps;
	}

	
	public void insert(GroupSupport groupSupport) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql ="insert into group_support(group_id,support_money,support_name,act_id,support_text) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupSupport.getGroupId());
			pstmt.setInt(2, groupSupport.getMoney());
			pstmt.setString(3, groupSupport.getName());
			pstmt.setInt(4, groupSupport.getActId());
			pstmt.setString(5, groupSupport.getText());
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public void update(GroupSupport groupSupport) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql ="update group_support set support_money=?,support_name=?,support_text=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupSupport.getMoney());
			pstmt.setString(2, groupSupport.getName());
			pstmt.setString(3, groupSupport.getText());
			pstmt.setInt(4, groupSupport.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}

	}

	
	public GroupSupport findById(Integer id) {
		// TODO Auto-generated method stub
		GroupSupport groupSupport = new GroupSupport();
		try{
			conn = JDBCUtil.getConnection();
			String sql ="select * from group_support where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				groupSupport.setId(rs.getInt("id"));
				groupSupport.setGroupId(rs.getInt("group_id"));
				groupSupport.setMoney(rs.getInt("support_money"));
				groupSupport.setName(rs.getString("support_name"));
				groupSupport.setActId(rs.getInt("act_id"));
				groupSupport.setText(rs.getString("support_text"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return groupSupport;
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try{
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_support where id=?";
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
	}

}
