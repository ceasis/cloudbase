package com.apps.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

	private List<String> listData = new ArrayList<String>();

	public MainController() {
		listData.add("Japan");
		listData.add("Canada");
		listData.add("Iran");
		listData.add("China");
		listData.add("Malaysia");
		listData.add("Singapore");
		listData.add("Philippines");
		listData.add("Thailand");
		listData.add("Australia");
		listData.add("USA");
		listData.add("Ukraine");
		listData.add("Argentina");
		listData.add("Mexico");

	}

	/*
	 * Returns a simple message
	 */
	@GetMapping("/")
	public String getPage() {
		return "index";
	}

	/*
	 * Returns the listData as JSON
	 */
	@GetMapping("/data")
	@ResponseBody
	public List<String> getData(HttpServletResponse response) {
		RestTemplate restTemplate = new RestTemplate();
		List<String> results = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		response.setStatus(222);

		Collections.shuffle(listData);
		temp = listData.subList(0, (int) (Math.random() * (listData.size() - 1)) + 1);

		for (String s : temp) {
			Boolean result = restTemplate.getForObject("http://localhost:6060/validate-data/" + s, Boolean.class);
			if (result == true) {
				results.add(s);
			}
		}

		return results;
	}

	/*
	 * Returns the listData as JSON
	 */
	@GetMapping("/validate-data/{data}")
	@ResponseBody
	public boolean getValidateData(@PathVariable String data) throws InterruptedException {

		if (data.equalsIgnoreCase("Philippines")) {
			Thread.sleep((long) (Math.random() * 3000));
		}

		return true;
	}

	/*
	 * Adds information to the listData via GET method
	 */
	@GetMapping("/data/{data}")
	@ResponseBody
	public String addData(@PathVariable String data) {

		listData.add(data);

		return "Successfully added " + data + "<br/><a href='/data'>View Data</a>";
	}

	/*
	 * Adds information to the listData via POST method
	 */
	@PostMapping("/data")
	@ResponseBody
	public List<String> postData(@RequestParam String data) {

		listData.add(data);

		return listData;
	}

	/*
	 * Empties listData via DELETE method
	 */
	@DeleteMapping("/data")
	@ResponseBody
	public List<String> deleteData() {

		listData.clear();

		return listData;
	}
}
