package unp.student.work.manager.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
public class Category extends AbstractCategory implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String type, Boolean hot) {
		super(type, hot);
	}

}
