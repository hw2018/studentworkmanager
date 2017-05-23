package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.annotations.ResultsetMappingSecondPass;

import com.opensymphony.xwork2.Result;

import unp.student.work.manager.dao.GroupMoneyDao;
import unp.student.work.manager.domain.GroupMoney;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupMoneyDaoImpl implements GroupMoneyDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		// TODO Auto-generated method stub
		List gmoneys = (List) new ArrayList<GroupMoney>();
		try{
			conn = JDBCUtil.getConnection();
			String sql ="select * from group_money where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupMoney groupMoney = new GroupMoney();
				groupMoney.setId(rs.getInt("id"));
				groupMoney.setGroupId(rs.getInt("group_id"));
				groupMoney.setMoney(rs.getInt("money"));
				groupMoney.setMoneyIn(rs.getBoolean("money_in"));
				groupMoney.setMoneyOut(rs.getBoolean("money_out"));
				groupMoney.setText(rs.getString("text"));
				gmoneys.add(groupMoney);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return gmoneys;
	}

	
	public void insert(GroupMoney groupMoney) {
		// TODO Auto-generated method stub
		try{
			conn = JDBCUtil.getConnection();
			String sql = "insert into group_money(group_id,money,money_in,money_out,text) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupMoney.getGroupId());
			pstmt.setInt(2, groupMoney.getMoney());
			pstmt.setBoolean(3, groupMoney.isMoneyIn());
			pstmt.setBoolean(4, groupMoney.isMoneyOut());
			pstmt.setString(5, groupMoney.getText());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public GroupMoney findById(Integer id) {
		// TODO Auto-generated method stub
		GroupMoney groupMoney = new GroupMoney();
		try{
			conn = JDBCUtil.getConnection();
			String sql ="select * from group_money where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				groupMoney.setId(rs.getInt("id"));
				groupMoney.setGroupId(rs.getInt("group_id"));
				groupMoney.setMoney(rs.getInt("money"));
				groupMoney.setMoneyIn(rs.getBoolean("money_in"));
				groupMoney.setMoneyOut(rs.getBoolean("money_out"));
				groupMoney.setText(rs.getString("text"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return groupMoney;
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from group_money where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	
	public Integer totalOfGroup(Integer id) {
		// TODO Auto-generated method stub
		Integer totalmoney = 0;
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_money where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getBoolean("money_in")==true)
					totalmoney += rs.getInt("money");
				else
					totalmoney -=rs.getInt("money");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return totalmoney;
	}

}
