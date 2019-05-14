package com.ssy.student;
/*
 * Builder模式设计实体类
 */
public class Student {
	private final int id;						//学号
	private final String name;					//姓名
	private final String sex;					//性别
	private final int  age;					//年龄
	private final int score;				//排名
	
	
	public Student(StudentBuilder sb) {
		this.id = sb.getId();
		this.name = sb.getName();
		this.sex = sb.getSex();
		this.age = sb.getAge();
		this.score = sb.getScore();
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getScore() {
		return score;
	}
	public String toString() {
		return "Student Info: id:" + this.getId() 
			+ " name:" + this.getName() //
			+ " age:" + this.getAge() //
			+ " sex:" + this.getSex() //
			+ " score:" + this.getScore();
	}
	
	public static class StudentBuilder{
		private int id;						//学号
		private String name;					//姓名
		private String sex;					//性别
		private int  age;					//年龄
		private int score;				//排名
		
		public StudentBuilder(int id) {
			this.id = id;
		}
		
		public StudentBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public StudentBuilder score(int score) {
			this.score = score;
			return this;
		}
		
		public StudentBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public StudentBuilder sex(String sex) {
			this.sex = sex;
			return this;
		}
		
		public StudentBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		
		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getSex() {
			return sex;
		}

		public int getAge() {
			return age;
		}

		public int getScore() {
			return score;
		}

		public Student build() {
			return new Student(this);
		}
		
	}
		
}
