package com.example.SpringBoot.repository.impl;

import com.example.SpringBoot.exception.ApiException;
import com.example.SpringBoot.exception.ErrorCode;
import com.example.SpringBoot.modals.Student;
import com.example.SpringBoot.repository.IStudentRepository;
import com.example.SpringBoot.util.JsonResponse;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepository implements IStudentRepository {

//    private List<Student> students  = new ArrayList<>(
//            Arrays.asList(
//                    new Student(UUID.randomUUID(),"Phan Thanh Luc","Quang Tri","Male"),
//                    new Student(UUID.randomUUID(),"Nguyen Huu Thang","Quang Binh","Female"),
//                    new Student(UUID.randomUUID(),"Bui Xuan Hoan","Quang Tri","Male")
//            )
//    );

    @Override
    public List<Student> findAll() {
       List<Student> studentList= new ArrayList<>();

       try {
           String query = "SELECT fullName FROM student";
           PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();

           while (resultSet.next()){
               Student student = new Student(
                       UUID.fromString(resultSet.getString("id")),
                       resultSet.getString("fullName"),
                       resultSet.getString("province"),
                       resultSet.getString("gender")
               );

               studentList.add(student);
           }
       }catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return studentList;
    }

    public Optional<Student> findById(UUID id){
        return null;
//        return students.stream()
//                .filter(s -> s.getId().equals(id))
//                .findFirst();
    }

    public Student save(Student student){
        return null;
//        student.setId(UUID.randomUUID());
//        students.add(student);
//        return student;
    }
}
