package com.apps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private List<String> listData = new ArrayList<String>();

    public MainController() {
        listData.add("Malaysia");
        listData.add("Singapore");
        listData.add("Philippines");
        listData.add("Thailand");
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
    public List<String> getData() {
        return listData;
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
