public class Student {
    private String name;
    private String department;
    private String program;
    private String studentCode;

    public Student(String name, String department, String program, String studentCode) {
        this.name = name;
        this.department = department;
        this.program = program;
        this.studentCode = studentCode;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getProgram() { return program; }
    public String getStudentCode() { return studentCode; }

    @Override
    public String toString() {
        return name + " | " + department + " | " + program + " | " + studentCode;
    }
}
