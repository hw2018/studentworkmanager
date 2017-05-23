package unp.student.work.manager.dao.impl;

import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unp.student.work.manager.dao.GroupThingDao;
import unp.student.work.manager.domain.GroupThing;
import unp.student.work.manager.utils.JDBCUtil;

public class GroupThingDaoImpl implements GroupThingDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public List findByGid(Integer id) {
		// TODO Auto-generated method stub
		List gts =(List) new ArrayList<GroupThing>();
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from group_thing where group_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GroupThing groupThing = new GroupThing();
				groupThing.setId(rs.getInt("id"));
				groupThing.setGroupId(rs.getInt("group_id"));
				groupThing.setName(rs.getString("name"));
				groupThing.setStatus(rs.getBoolean("status"));
				groupThing.setCurrent_user(rs.getString("current_user"));
				groupThing.setNow_user(rs.getString("now_user"));
				gts.add(groupThing);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, pstmt, conn);
		}
		return null;
	}

	
	public GroupThing findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void insert(GroupThing groupThing) {
		// TODO Auto-generated method stub

	}

	
	public void upadate(GroupThing groupThing) {
		// TODO Auto-generated method stub

	}

	
	public void delete(GroupThing groupThing) {
		// TODO Auto-generated method stub

	}

}
