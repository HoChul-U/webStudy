package com.nhnacademy.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentNoIdRegister;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudentsControllerTest {

    private MockMvc mockMvc;

    private StudentRepository studentRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        StudentsController studentsController = new StudentsController(studentRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(studentsController)
                .build();
    }

    @Test
    void getResponseEnityViewStudent() throws Exception {
        Student student =  new Student(0,"admin", "hochul@naver.com", 80, "hi");
        when(studentRepository.getStudent(0)).thenReturn(student);

        MvcResult mvcResult = mockMvc.perform(get("/students/{studentId}", 0))
                .andExpect(status().isOk())
                .andReturn();
        String json = objectMapper.writeValueAsString(student);

        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo(json);
        verify(studentRepository,times(1)).getStudent(0);
    }

    @Test
    void postCreateStudent() throws Exception{
        StudentRegister studentRegister= new StudentRegister();

        studentRegister.setId(0);
        studentRegister.setName("admin");
        studentRegister.setEmail("hochul@naver.com");
        studentRegister.setScore(50);
        studentRegister.setComment("hi");

        when(studentRepository.addStudent(studentRegister.getId(),
                studentRegister.getName(),
                studentRegister.getEmail(),
                studentRegister.getScore(),
                studentRegister.getComment()))
                .thenReturn(new Student(0,"admin","hochul@naver.com",50,"hi"));

        String json = objectMapper.writeValueAsString(studentRegister);
        MvcResult mvcResult = mockMvc.perform(post("/students")
                        .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


        verify(studentRepository,times(1))
                .addStudent(studentRegister.getId(),
                studentRegister.getName(),
                studentRegister.getEmail(),
                studentRegister.getScore(),
                studentRegister.getComment());
    }

    @Test
    void modifyPutStudent() throws Exception {
        StudentNoIdRegister studentNoIdRegister = new StudentNoIdRegister();
        studentNoIdRegister.setComment("hi modify");
        studentNoIdRegister.setName("hochul");
        studentNoIdRegister.setEmail("hochul@naver.com");
        studentNoIdRegister.setScore(50);

        Student student = new Student(0,
                studentNoIdRegister.getName(),
                studentNoIdRegister.getEmail(),
                studentNoIdRegister.getScore(),
                studentNoIdRegister.getComment());
        when(studentRepository.modify(student)).thenReturn(student);

        String json = objectMapper.writeValueAsString(student);
        MvcResult mvcResult = mockMvc.perform(put("/students/{studentId}", 0)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo(json);
        verify(studentRepository, times(1)).modify(student);
    }
}