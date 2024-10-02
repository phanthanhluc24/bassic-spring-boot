package com.example.SpringBoot.repository.impl;

import com.example.SpringBoot.exception.ApiException;
import com.example.SpringBoot.exception.ErrorCode;
import com.example.SpringBoot.modals.Student;
import com.example.SpringBoot.repository.IStudentRepository;
import com.example.SpringBoot.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepository {

    @Autowired
    private IStudentRepository iStudentRepository;
//    private List<Student> students  = new ArrayList<>(
//            Arrays.asList(
//                    new Student(UUID.randomUUID(),"Phan Thanh Luc","Quang Tri","Male"),
//                    new Student(UUID.randomUUID(),"Nguyen Huu Thang","Quang Binh","Female"),
//                    new Student(UUID.randomUUID(),"Bui Xuan Hoan","Quang Tri","Male")
//            )
//    );


    public List<Student> findAll() {
        List<Student> students = iStudentRepository.findAll();
        return students;
//        List<Student> studentList = new ArrayList<>();

//        try {
//            String query = "SELECT * FROM student";
//            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();

//            while (resultSet.next()) {
//                Student student = new Student(
//                        UUID.fromString(resultSet.getString("id")),
//                        resultSet.getString("fullName"),
//                        resultSet.getString("province"),
//                        resultSet.getString("gender")
//                );
//
//                studentList.add(student);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return studentList;
    }

    public Optional<Student> findById(Long id) {
        return null;
//        Optional<Student> student = Optional.empty();
//
//        try {
//
//            String query = "SELECT * FROM student where id = ?";
//            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query);
//            preparedStatement.setString(1, id.toString());
//            ResultSet resultSet = preparedStatement.executeQuery();

//            if (resultSet.next()) {
//                student = Optional.of(new Student(
//                        UUID.fromString(resultSet.getString("id")),
//                        resultSet.getString("fullName"),
//                        resultSet.getString("province"),
//                        resultSet.getString("gender")
//                ));
//            }
//            return student;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return students.stream()
//                .filter(s -> s.getId().equals(id))
//                .findFirst();
    }

    public Student save(Student student) {
        Student student1 = Student.builder()
                .fullName(student.getFullName())
                .province(student.getProvince())
                .Gender(student.getGender())
                .build();

        return iStudentRepository.save(student1);

//        try {
//            String query1 = "INSERT INTO student(id, fullName, province, gender) VALUES (?,?,?,?)";
//            String query2 = "UPDATE student SET fullName =?, province =?, gender =? WHERE id =?";
//
//            Optional<Student> isExitStudent = findById(student.getId());
//
//            if (isExitStudent.isPresent()) {
//                PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query2);
//                preparedStatement.setString(1, student.getFullName());
//                preparedStatement.setString(2, student.getProvince());
//                preparedStatement.setString(3, student.getGender());
//                preparedStatement.setString(4, student.getId().toString());
//                preparedStatement.executeUpdate();
//            } else {
//                student.setId(UUID.randomUUID());
//                PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query1);
//                preparedStatement.setString(2, student.getFullName());
//                preparedStatement.setString(3, student.getProvince());
//                preparedStatement.setString(4, student.getGender());
//                preparedStatement.setString(1, student.getId().toString());
//                preparedStatement.executeUpdate();
//            }
//        }
//        student.setId(UUID.randomUUID());
//        students.add(student);
    }
}
