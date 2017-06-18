package com.company;

import com.company.student.Database.ConnectionManager;

import javax.swing.*;
import java.sql.*;

@SuppressWarnings({"Duplicates", "SqlNoDataSourceInspection", "SqlDialectInspection"})
class QueryDB {
    private static int idRating;
    private static int idStudent;
    private static int idTeacher;
    private static int idLesson;
    private static int idScore;

    static void insertDataToTableStudents(JTextField nameField,
                                          JTextField lastNameField,
                                          JComboBox sexComboBox, JTextField ageField,
                                          JTextField finalPersonCodeField,
                                          JComboBox groupComboBox,
                                          JTextField finalPhoneField,
                                          JTextField emailField) {
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO Students (First_Name, Last_Name, Sex, Age, Person_Code, Student_Group, Phone, Email)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, nameField.getText());
            preparedStmt.setString(2, lastNameField.getText());
            preparedStmt.setString(3, (String) sexComboBox.getSelectedItem());
            preparedStmt.setInt(4, Integer.parseInt(ageField.getText()));
            preparedStmt.setString(5, finalPersonCodeField.getText());
            preparedStmt.setString(6, (String) groupComboBox.getSelectedItem());
            preparedStmt.setString(7, finalPhoneField.getText());
            preparedStmt.setString(8, emailField.getText());
            preparedStmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    static void insertDataToTableRating(JLabel studentsLabelName, JLabel studentsLabelSurname,
                                        String teacherName, String teacherSurname, String lesson,
                                        String course, String score) {
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO Rating (ID_St, ID_Te, ID_Pr, Score)"
                    + "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            setIdStudent(getIdStudent(studentsLabelName, studentsLabelSurname));
            setIdTeacher(getIdTeachers(teacherName, teacherSurname));
            setIdLesson(getIdLessons(lesson, course));
            setIdScore(Integer.parseInt(score));
            preparedStmt.setInt(1, getIdStudent());
            preparedStmt.setInt(2, getIdTeacher());
            preparedStmt.setInt(3, getIdLesson());
            preparedStmt.setInt(4, getIdScore());
            preparedStmt.executeUpdate();
            ResultSet resultSet = preparedStmt.getGeneratedKeys();
            if (resultSet.next())
                setIdRating(resultSet.getInt(1));
            preparedStmt.close();
            resultSet.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private static int getIdStudent(JLabel studentName, JLabel studentSurname) {
        int id = 0;
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement("SELECT id FROM Students WHERE First_Name = '" + studentName.getText() + "' AND " +
                    "Last_Name = '" + studentSurname.getText() + "'");
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            preparedStmt.close();
            resultSet.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return id;
    }

    private static int getIdTeachers(String name, String surname) {
        int id = 0;
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement("SELECT id FROM Teachers WHERE First_Name = '" + name + "' AND " +
                    "Last_Name = '" + surname + "'");
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            preparedStmt.close();
            resultSet.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return id;
    }

    private static int getIdLessons(String lesson, String course) {
        int id = 0;
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement("SELECT id FROM Lessons WHERE Lesson_Name = '" + lesson + "' AND " +
                    "Course = '" + course + "'");
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            preparedStmt.close();
            resultSet.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return id;
    }

    public static int getIdLesson() {
        return idLesson;
    }

    public static void setIdLesson(int idLesson) {
        QueryDB.idLesson = idLesson;
    }

    public static int getIdScore() {
        return idScore;
    }

    public static void setIdScore(int idScore) {
        QueryDB.idScore = idScore;
    }

    public static int getIdStudent() {
        return idStudent;
    }

    public static void setIdStudent(int idStudent) {
        QueryDB.idStudent = idStudent;
    }

    public static int getIdTeacher() {
        return idTeacher;
    }

    public static void setIdTeacher(int idTeacher) {
        QueryDB.idTeacher = idTeacher;
    }

    public static int getIdRating() {
        return idRating;
    }

    public static void setIdRating(int idRating) {
        QueryDB.idRating = idRating;
    }
}