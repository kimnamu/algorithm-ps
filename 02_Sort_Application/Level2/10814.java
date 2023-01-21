// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//나이순 정렬
//https://www.acmicpc.net/problem/10814

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// age, name 정보를 가진 Customer Class
class Customer implements Comparable<Customer>{
	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}
	int age;
	String name;
	
	@Override
	public int compareTo(Customer o) {
		// age 오름차순으로 정렬
		return this.age - o.age;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Customer> customerArr = new ArrayList<>();
		
		// 1. age와 name을 받아 customer class 생성 후 ArrayList에 순차적으로 입력
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			
			customerArr.add(new Customer(age, name));
		}
		
		// 2. Customer Class에 정의된 compareTo 함수(age 오름차순)에 맞게 정렬
		Collections.sort(customerArr);
		
		for (int i = 0; i < N; i++) {
			System.out.println(customerArr.get(i).age + " " + customerArr.get(i).name);
		}
	}
}
