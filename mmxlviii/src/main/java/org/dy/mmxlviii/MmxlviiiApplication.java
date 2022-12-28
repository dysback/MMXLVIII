 package org.dy.mmxlviii;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MmxlviiiApplication {
	public static List<Integer> lista = new ArrayList<Integer>();
	public static Game game;

	public static void main(String[] args) {
		SpringApplication.run(MmxlviiiApplication.class, args);
	}

	public static String printItems(){
		String ret = "";
		for (Integer item : lista) {
			ret += " " + item;
		}

		return ret;
	}

}
