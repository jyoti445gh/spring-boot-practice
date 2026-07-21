package in.strikes.crudSpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.crudSpringBootDemo.entity.Student;

//@Repository
// public class StudentRepository {

//     public Student saveStudent(Student studentReq) {
//         // save to DB
//         System.out.println("Inside Student Repository");
//         System.out.println("Exiting Student Repository");

//         Student s1 = new Student();
//         s1.setName("Aditya");
//         s1.setAge(28);
//         s1.setEmail("aditya@gmail.com");
//         s1.setRollNo(101);
//         s1.setSubject("Spring Framework");

//         return s1;
//     }
// }

public interface StudentRepository extends JpaRepository<Student, Long> {
}