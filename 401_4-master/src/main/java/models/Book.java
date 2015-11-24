package models;


import core.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book implements Model {
    @NotNull
    private int enterpriseId;
    @NotNull @Size(min = 2, max = 256)
    private String name;
    @NotNull @Size(min = 2, max = 128)
    private String branch;
    @NotNull @Min(1)
    private int employeeCount;

    public static String tableName = "book";

    public Book(String name, String branch, int employeeCount) {
        this.name = name;
        this.branch = branch;
        this.employeeCount = employeeCount;
    }

    public Book() {

    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "enterpriseId=" + enterpriseId +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
