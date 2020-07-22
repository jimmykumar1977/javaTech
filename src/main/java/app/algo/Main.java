package app.algo;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Main {

    public static Map<String,Integer> processData(ArrayList<String> array) {
       List<Emp> empList = array.stream().map(s->toEmp.apply(s)).collect(Collectors.toList());
       Map<String,Optional<Emp>> r =   empList.stream().collect(
                Collectors.groupingBy(Emp::getDepartment,Collectors.maxBy((e1,e2)-> e1.getID().compareTo(e2.getID()))));
        Map<String,Integer> retVal = new HashMap<>();
        r.forEach((k,v) -> retVal.put(k,v.get().getSalary()));
        return retVal;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        System.out.println(processData(getfileContent(fileName)));
    }

    private static ArrayList<String> getfileContent(final String fileName) {
        URL url = Main.class.getClassLoader().getResource(fileName);
        ArrayList<String> lines = new ArrayList<>(100);
        try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {
            stream.forEach(lines::add);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return lines;
    }

    static Function<String,Emp> toEmp = ln -> {
        String[] empArr = ln.split(",");
        Emp e = new Emp();
        e.setID(Integer.valueOf(empArr[0].trim()));
        e.setName(empArr[1]);
        e.setDepartment(empArr[2]);
        e.setSalary(Integer.valueOf(empArr[3].trim()));
        return e;
    };
}

class Emp{
    private Integer ID;
    private String Name;
    private String Department;
    private Integer Salary;
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    public Integer getSalary() {
        return Salary;
    }
    public void setSalary(Integer salary) {
        Salary = salary;
    }
}
