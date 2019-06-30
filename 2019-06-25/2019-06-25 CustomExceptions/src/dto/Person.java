package dto;

public class Person {
	
	private String name;
	private int age;
	private double height;
	private boolean married;
	
	public Person(String name, int age, double height, boolean married) throws WrongDataException {
		super();
		setName(name);
		setAge(age);
		setHeight(height);
		setMarried(married);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws WrongDataException {
		if (name == null) throw new WrongDataException("name is null");
		if (name.isEmpty()) throw new WrongDataException("name is empty");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws WrongDataException {
		if (age < 0) throw new WrongDataException("negative age: "+age);
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", married=" + married + "]";
	}
	
	

}
