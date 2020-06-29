package Project.Project01;

/**
 * @author ChenZT
 */
public class Customer {
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String email;


    public Customer(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Customer(String name, String gender, int age, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Customer(String name, String gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\t" + gender + "\t" + age + "\t" + phone + "\t" + email;
    }
}
