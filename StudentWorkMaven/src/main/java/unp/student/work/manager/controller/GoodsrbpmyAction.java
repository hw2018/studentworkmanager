package unp.student.work.manager.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.Goodsrbpmy;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.GoodsrbpmyService;

@Component
public class GoodsrbpmyAction extends ActionSupport {
	private String id;
	private String name;
	private Double price;
	private String des;
	private Date time;
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private Goodsrbpmy goodsrbpmy = new Goodsrbpmy();

	@Resource
	private GoodsrbpmyService goodsrbpmyService;

	public String add() throws Exception {

		Date d = new Date();
		personPersonInfo.setStudentid("221400401"); // 这里是获取当前session中的用户名的代码
		goodsrbpmy.setName(name);
		goodsrbpmy.setPrice(price);
		goodsrbpmy.setDes(des);
		goodsrbpmy.setTime(d);
		goodsrbpmy.setPersonPersonInfo(personPersonInfo);
		goodsrbpmyService.save(goodsrbpmy);

		return SUCCESS;
	}

	public String delete() throws Exception {
		// personFavorite.setId(id);
		goodsrbpmyService.delete(id);

		return SUCCESS;
	}

	public String modify() throws Exception {

		Date d = new Date();
		goodsrbpmy.setId(Integer.parseInt(id));
		goodsrbpmy.setName(name);
		goodsrbpmy.setPrice(price);
		goodsrbpmy.setDes(des);
		goodsrbpmy.setTime(d);
		personPersonInfo.setStudentid("221400401"); // 这里是获取当前session中的用户名的代码
		goodsrbpmy.setPersonPersonInfo(personPersonInfo);
		goodsrbpmyService.modify(goodsrbpmy);

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
