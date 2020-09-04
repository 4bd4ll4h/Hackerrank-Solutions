package com.abd4ll4h;

import java.util.*;

public class JavaPriorityQueue_problem {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName()+" "+st.getCgp()+" "+st.getId());
            }
        }
    }

    private static class Priorities {
        public List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> students=new PriorityQueue<>(Comparator.comparing(Student::getCgp).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
            for (String event:events){
               if(event.equals("SERVED")){students.poll();
                    }
                else
                students.add(new Student(event.split(" ")));
            }

            ArrayList<Student>arrayList=new ArrayList<>();
            while (!students.isEmpty())arrayList.add(students.poll());
        return arrayList;
        }
    }

    private static class Student {
        int id;
        String name;
        double cgp;

        public Student(String []info) {
            this.id = Integer.parseInt(info[3]);
            this.name = info[1];
            this.cgp = Double.parseDouble(info[2]);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgp() {
            return cgp;
        }
    }
}
/*test case
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
 */