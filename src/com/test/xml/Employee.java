package com.test.xml;



import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * 员工
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
public class Employee {

    private Long id;

    private String code;

    private String name;

    private String telephone;

    private Integer sex;

    private Dept dept;
    /**
     * @XmlElementWrapper 指定外层Xml的标签名
     * @XmlElement 指定集合中的实体的标签名
     */
    @XmlElementWrapper(name = "depts")
    @XmlElement(name = "dept")
    private List<Dept> depts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex=" + sex +
                ", dept=" + dept +
                ", depts=" + depts +
                '}';
    }
}
