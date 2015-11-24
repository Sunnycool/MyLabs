package entity;


import core.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name="Book.findAll", query="SELECT e FROM Book e"),
        @NamedQuery(name="Book.findByName", query="SELECT e FROM Book e WHERE e.name = :name"),
        @NamedQuery(name="Book.findByBranch", query="SELECT e FROM Book e WHERE e.branch = :branch")
})
public class Book  {

    private int enterpriseId;

    private String name;

    private String branch;

    private int employeeCount;

    public Book(String name, String branch, int employeeCount) {
        this.name = name;
        this.branch = branch;
        this.employeeCount = employeeCount;
    }

    public Book() {

    }

    @Id
    @GeneratedValue
    @Column(name = "bookId", nullable = false, insertable = true, updatable = true)
    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author", nullable = false, insertable = true, updatable = true)
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Basic
    @Column(name = "amount", insertable = true, updatable = true)
    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (enterpriseId != book.enterpriseId) return false;
        if (employeeCount != book.employeeCount) return false;
        if (!name.equals(book.name)) return false;
        return branch.equals(book.branch);

    }

    @Override
    public int hashCode() {
        int result = enterpriseId;
        result = 31 * result + name.hashCode();
        result = 31 * result + branch.hashCode();
        result = 31 * result + employeeCount;
        return result;
    }
}
