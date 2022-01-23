package com.dto;

public class StudentDTO {
    private String studentNo;
    private String studentName;
    private String studentSsn;
    private String studentAddress;
    private String entranceDate;
    private char absenceYn;

    public StudentDTO(String stuNo, String stuName, String stuSsn, String stuAdress, String entDate, char absYn) {
        this.studentNo = stuNo;
        this.studentName = stuName;
        this.studentSsn = stuSsn;
        this.studentAddress = stuAdress;
        this.entranceDate = entDate;
        this.absenceYn = absYn;
    }

    public StudentDTO() {
    }

    @Override
    public String toString() {
        return studentNo + " " + studentName + " " + studentSsn + " " + fixNullAddress(studentAddress) + " "
                + entranceDate + " " + absenceYn + " " + "\n";
    }

    private String fixNullAddress(String address) {
        if (address.equals("...") || address.equals("불 명...")) {
            return "***주소 미상***   ";
        }
        return address;
    }
}
