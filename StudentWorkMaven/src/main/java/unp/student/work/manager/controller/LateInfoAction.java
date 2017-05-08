package unp.student.work.manager.controller;


import java.util.Date;
import java.util.Iterator;
import java.util.Map;










import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.annotations.Sort;
import org.springframework.stereotype.Controller;

import unp.student.work.manager.model.late_info;
import unp.student.work.manager.model.late_person;
import unp.student.work.manager.service.LateInfoService;
import unp.student.work.manager.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;

@Controller("lateinfoAction")
public class LateInfoAction extends ActionSupport implements ModelDriven<late_info>,RequestAware,SessionAware{
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	public late_info lateInfo=new late_info();
	private int latepersonid;//晚点信息 id
	private String reason;//申诉理由
	private String studentid;
	private String situation;//晚点缺勤人员学号
	private String date;
	private int pageno=1;
	
	
	@Resource
	private LateInfoService lateInfoService;
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int getLatepersonid() {
		return latepersonid;
	}

	public void setLatepersonid(int latepersonid) {
		this.latepersonid = latepersonid;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}


	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}


	public String add(){  //添加晚点信息
		
		String id=(String) session.get("user");
		lateInfo.setTime(new Date(date));
		lateInfoService.add(lateInfo,id,situation);
		return "success";
	}
	
	public String delete(){   //删除晚点信息
		lateInfoService.delete(lateInfo);
		return "success";
	}

	public String update(){  //更新晚点信息
		lateInfoService.update(lateInfo,situation);
		return "success";
	}
	
	public String show(){  //查看晚点信息
		
		PageBean pageBean=lateInfoService.findByPage(pageno);
		request.put("pageBean", pageBean);
		return "show";
	}

	public String get(){  //获取晚点信息
		lateInfo=lateInfoService.get(lateInfo.getId());
		request.put("lateinfo", lateInfo);
		return "update";
	}
	public String info(){   //查看晚点具体信息
		lateInfo=lateInfoService.get(lateInfo.getId());
		request.put("lateinfo", lateInfo);
		return "info";
	}
	public String addinfo(){  //增加缺勤人员
		lateInfoService.addinfo(lateInfo.getId(), studentid);
		lateInfo=lateInfoService.get(lateInfo.getId());
		request.put("lateinfo", lateInfo);
		//未传入lateinfo.lateperson
		return "infosuccess";
		
	}
	public String deleteinfo(){  //删除缺勤人员
		lateInfoService.deleteinfo(lateInfo.getId(),latepersonid);
		late_info late_info1=lateInfoService.get(lateInfo.getId());
		
		request.put("lateinfo", lateInfoService.get(lateInfo.getId()));
		return "infosuccess";
	}
	
	public String applyinfo(){  //添加缺勤申诉
		
		if(session.get("user").equals(studentid)){
			lateInfoService.updateinfo(latepersonid, reason);
			request.put("lateinfo", lateInfoService.get(lateInfo.getId()));
			return "infosuccess";
		}else{
			return "error";
		}
		
	}
	
	public String dealinfo(){  //处理缺勤申诉
		
		lateInfoService.dealinfo(lateInfo.getId(), latepersonid);
		request.put("lateinfo", lateInfoService.get(lateInfo.getId()));
		return "infosuccess";
	}
	public late_info getModel() {
		// TODO Auto-generated method stub
		
		return lateInfo;
	}
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
		
	}
	

	
}
