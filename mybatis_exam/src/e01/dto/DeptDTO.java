package e01.dto;

public class DeptDTO {

    private int deptNo;
    private String loc;
    private String dName;

    public DeptDTO(){}

    public DeptDTO(int deptNo, String loc, String deptName) {
        this.deptNo = deptNo;
        this.loc = loc;
        this.dName = deptName;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public String getDName() {
        return dName;
    }

    public String getLoc() {
        return loc;
    }

    @Override
    public String toString() {
        return "DeptDTO{" +
                "deptNo=" + deptNo +
                ", dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
