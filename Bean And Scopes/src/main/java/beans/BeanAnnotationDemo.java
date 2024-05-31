package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student {

    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public void print() {
        System.out.println("Student class method called ...");
        address.print();
    }
}

class Address {

    public static void print() {
        System.out.println("Address class method called ...");
    }
}

@Configuration
class AppConfig {

    @Bean(name = {"address", "testingName"})
    public Address address() {
        return new Address();
    }


    @Bean
    public Student student() {
        return new Student(address());
    }
}
public class BeanAnnotationDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) applicationContext.getBean("student");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String bean: beanNames) {
            System.out.println(bean);
        }
        student.print();
    }
}
