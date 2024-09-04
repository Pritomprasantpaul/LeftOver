package com.demo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		list.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		list.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		list.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		list.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		list.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		list.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		list.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		list.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		list.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		list.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		list.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		list.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		list.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		list.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		list.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		//Print count of genders
		Map<String, Long> map = list.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
//		System.out.println(map);
		
		//Print all department
//		list.stream()
//		.map(Employee::getDepartment)
//		.distinct().forEach(System.out::println);
		
		//Print average of gender
		Map<String, Double> avgAge = list.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		
//		System.out.println(avgAge);
		
		//Highest paid employee
		Employee highestPaid = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).orElse(null);
		
//		System.out.println(highestPaid);
		
		//Joined after 2015
//		list.stream()
//		.filter(e -> e.getYearOfJoining()>2015)
//		.map(Employee::getName)
//		.forEach(System.out::println);
		
		//Count employee in each department
		Map<String, Long> eachDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//		System.out.println(eachDepartment);
		
		//Avg salary each department
		Map<String, Double> avgSalDepartment = list.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		
//		System.out.println(avgSalDepartment);
		
		//Youngest Male Employee in Product dev departement
		Employee youngMaleEmp = list.stream()
		.filter(e -> e.getGender().equals("Male"))
		.filter(e -> e.getDepartment().equals("Product Development"))
		.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge))).orElse(null);
		
//		System.out.println(youngMaleEmp);
		
		//most experience employee
		Employee mostExperiences = list.stream()
		.collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))).orElse(null);
		
//		System.out.println(mostExperiences);
		
		//Count of male and females in Sales team
		Map<String, Long> count  = list.stream()
		.filter(e -> e.getDepartment().equals("Sales And Marketing"))
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//		System.out.println(count);
		
		//Avg Salary of male and female
		Map<String, Double> avgSal = list.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
//		System.out.println(avgSal);
		
		//all emp names all dept
//		list.stream()
//		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())))
//		.forEach( (dept, l) -> 
//			System.out.println(dept +": "+ l)
//				);
		
		//avgSal and total sal 
//		DoubleSummaryStatistics dss = list.stream()
//		.collect(Collectors.summarizingDouble(Employee::getSalary));
//		System.out.println(dss.getAverage());
//		System.out.println(dss.getSum());
		
		//separate emp ...<25<...
		list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
	}

}
