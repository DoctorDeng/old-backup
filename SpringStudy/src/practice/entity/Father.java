package practice.entity;

public class Father {
	private Child child;

	public Father(){}
	
	public Father(Child child) {
		this.child = child;
	}
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
