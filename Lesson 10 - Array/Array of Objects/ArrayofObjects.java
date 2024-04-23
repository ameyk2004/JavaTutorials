class Student{
    int rollno;
    int marks;
    String name;

    Student(String n,int r, int m)
    {
        this.name = n;
        this.rollno = r;
        this.marks = m;
    }

    void print()
    {
        System.out.println("\nStudent Details");
        System.out.println("Name : "+this.name);
        System.out.println("Roll No : "+this.rollno);
        System.out.println("Marks : "+this.marks);
    }
}

public class ArrayofObjects {
    public static void main(String[] args) {
        //Normal ways of creating traversing
        // int nums[] = new int[4];

        // for(int n : nums)
        // {
        //     System.out.print(n + " ");
        // }


        Student s1 = new Student("Amey", 21237, 87);
        Student s2 = new Student("Tirthraj", 21243, 92);
        Student s3 = new Student("Advait", 21228, 100);

        Student students[] = {s1,s2,s3};

        //Enhanced For loop
        for(Student stud : students)
        {
            stud.print();
        }
    }
    
}