package practice.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestSet {
	private List<String> stringList;
	private List<Student1> studentList;
	private Map<String,String> map;
	private Set<String> set;
	
	public TestSet(){}
	
	public TestSet(List<String> stringList, List<Student1> studentList, Map<String, String> map, Set<String> set) {
		super();
		this.stringList = stringList;
		this.studentList = studentList;
		this.map = map;
		this.set = set;
	}
	
	@Override
	public String toString() {
		return "TestSet [stringList=" + stringList + ", studentList=" + studentList + ", map=" + map + ", set=" + set
				+ "]";
	}
	
	public List<String> getStringList() {
		return stringList;
	}
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
	public List<Student1> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student1> studentList) {
		this.studentList = studentList;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
}
