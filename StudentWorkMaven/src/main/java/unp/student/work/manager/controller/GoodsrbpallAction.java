package unp.student.work.manager.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.Goodsrbpall;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.GoodsrbpallService;

@Component
public class GoodsrbpallAction extends ActionSupport {
	private String id;
	private String name;
	private Double price;
	private String des;
	private Date time;
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private Goodsrbpall goodsrbpall = new Goodsrbpall();

	@Resource
	private GoodsrbpallService goodsrbpallService;

	public String add() throws Exception {

		Date d = new Date();
		personPersonInfo.setStudentid("221400401"); // 这里是获取当前session中的用户名的代码
		goodsrbpall.setName(name);
		goodsrbpall.setPrice(price);
		goodsrbpall.setDes(des);
		goodsrbpall.setTime(d);
		goodsrbpall.setPersonPersonInfo(personPersonInfo);
		goodsrbpallService.save(goodsrbpall);

		return SUCCESS;
	}

	public String delete() throws Exception {
		// personFavorite.setId(id);
		goodsrbpallService.delete(id);

		return SUCCESS;
	}

	public String modify() throws Exception {

		Date d = new Date();
		goodsrbpall.setId(Integer.parseInt(id));
		goodsrbpall.setName(name);
		goodsrbpall.setPrice(price);
		goodsrbpall.setDes(des);
		goodsrbpall.setTime(d);
		personPersonInfo.setStudentid("221400401"); // 这里是获取当前session中的用户名的代码
		goodsrbpall.setPersonPersonInfo(personPersonInfo);
		goodsrbpallService.modify(goodsrbpall);

		return SUCCESS;
	}

	public String search() throws Exception {

		return SUCCESS;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
