package application;

import java.util.List;
import java.util.Scanner;

import dao.DepartmentDAO;
import dao.daoFactory;
import entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDAO departmentDao = daoFactory.createDepartmentDAO();

		System.out.println("==== TEST 1: findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);  
		
		System.out.println();

		System.out.println("==== TEST 2: findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println();
		
		System.out.println("==== TEST 3: INSERT ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println();

		System.out.println("==== TEST 4: UPDATE ====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println();
		
		System.out.println("==== TEST 5: DELETE ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
}