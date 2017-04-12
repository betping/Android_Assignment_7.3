package mr_auspicious.shivam_kr_shiv.com.sqlite2.data;


//Model Class
public class Employee {


    private String Name;
    private int Age;
    private byte[] image;


    public Employee(String name, int age, byte[] image) {
        Name = name;
        Age = age;
        this.image = image;
    }

    public Employee() {

    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
