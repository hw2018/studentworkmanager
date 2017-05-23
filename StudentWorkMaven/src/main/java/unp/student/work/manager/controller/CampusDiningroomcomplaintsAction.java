package unp.student.work.manager.controller;

import java.util.Date;


import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.CampusDiningroomcomplaintsDao;
import unp.student.work.manager.domain.Diningroomcomplaints;
import unp.student.work.manager.service.CampusDiningroomcomplaintsService;
import unp.student.work.manager.service.impl.CampusDiningroomcomplaintsServiceImpl;
import unp.student.work.manager.utils.PageBean;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller
@Scope("prototype")
public class CampusDiningroomcomplaintsAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private Diningroomcomplaints diningroomcomplaints;
	private List diningroomcomplaintss;
	private PageBean pageBean;
	//默认装配方式为byType, 要确保该类型的bean唯一
	@Autowired
	private CampusDiningroomcomplaintsService  diningroomcomplaintsService;
    /**
     * 处理新增表单提交请求
     */
	public String add(){
		
		diningroomcomplaints.setTime(new Date());		
		diningroomcomplaintsService.save(diningroomcomplaints);
		return SUCCESS;
	}
	
	 /**
     * 处理分页显示请求
     */
	public String show(){
		pageBean=diningroomcomplaintsService.findByPage(pageNo, 10);
		return "showDiningroomcomplaintss";
	}
	
	 /**
     * 处理显示更新页面请求
     */
	public String update(){
		diningroomcomplaints=diningroomcomplaintsService.findById(id);
		return "update";
	}

	/**
     * 处理保存更新信息请求
     */
	public String save(){
		diningroomcomplaintsService.update(diningroomcomplaints);
		return SUCCESS;
	}
	/**
     * 处理删除页面请求
     */
	public String delete(){
		diningroomcomplaintsService.deleteById(id);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Diningroomcomplaints getDiningroomcomplaints() {
		return diningroomcomplaints;
	}

	public void setDiningroomcomplaints(Diningroomcomplaints diningroomcomplaints) {
		this.diningroomcomplaints = diningroomcomplaints;
	}

	public List getEquityprotects() {
		return diningroomcomplaintss;
	}

	public void setDiningroomcomplaintss(List diningroomcomplaintss) {
		this.diningroomcomplaintss = diningroomcomplaintss;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}

