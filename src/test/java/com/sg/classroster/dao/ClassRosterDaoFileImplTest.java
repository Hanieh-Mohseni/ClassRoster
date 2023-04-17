package com.sg.classroster.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sg.classroster.dto.Student;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ClassRosterDaoFileImplTest {

    private ClassRosterDao dao = new ClassRosterDaoFileImpl();


    @BeforeEach
    void setUp() throws Exception {
        List<Student> studentList = dao.getAllStudents();
        for (Student student : studentList) {
            dao.removeStudent(student.getStudentId());
        }
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void addStudent()throws Exception {
        Student myStudent = new Student("001");
        myStudent.setFirstName("Hani");
        myStudent.setLastName("Mohseni");
        myStudent.setCohort("Java-Nov 2022");

        dao.addStudent(myStudent.getStudentId(), myStudent);

        Student fromDao = dao.getStudent(myStudent.getStudentId());

        assertTrue(myStudent.getFirstName().equals(fromDao.getFirstName()) );


    }

    @Test
    void getAllStudents() throws Exception {

        Student student1 = new Student("001");
        student1.setFirstName("Hani");
        student1.setLastName("Mohseni");
        student1.setCohort("Java-Nov 2022");

        dao.addStudent(student1.getStudentId(), student1);

        Student student2 = new Student("002");
        student2.setFirstName("Xin");
        student2.setLastName("Hui");
        student2.setCohort("Java-Nov 2022");

        dao.addStudent(student2.getStudentId(), student2);

        assertEquals(2, dao.getAllStudents().size());
    }


    @Test
    void removeStudent() throws Exception{
        Student student1 = new Student("001");
        student1.setFirstName("Hani");
        student1.setLastName("Mohseni");
        student1.setCohort("Java-Nov 2022");

        dao.addStudent(student1.getStudentId(), student1);

        Student student2 = new Student("0002");
        student2.setFirstName("Xin");
        student2.setLastName("Hui");
        student2.setCohort("Java-Nov 2022");

        dao.addStudent(student2.getStudentId(), student2);

        dao.removeStudent(student1.getStudentId());
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentId()));

        dao.removeStudent(student2.getStudentId());
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentId()));

    }
    }
