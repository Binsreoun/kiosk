package main.java.food;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu{
    private String name;
    private String explanation;


    public Menu(String name,String explanation){
        this.name = name;
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
