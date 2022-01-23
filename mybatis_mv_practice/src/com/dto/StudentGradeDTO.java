package com.dto;

public class StudentGradeDTO {
    private String termNo;
    private String studentNo;
    private String studentName;
    private String className;
    private double point;
    private String grade;

    public StudentGradeDTO(String termNo, String studentNo, String studentName, String className, double point, String grade) {
        this.termNo = termNo;
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.className = className;
        this.point = point;
        this.grade = grade;
    }

    public StudentGradeDTO() {
    }

    @Override
    public String toString(){
        return termNo + "  " + studentNo + "    " + studentName + "  " + className + " " + point + " " + grade;
    }
}
