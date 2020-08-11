package ObjectOriented;

/**
 * @author ChenZT
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
 * score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
 * 问题一：打印出3年级(state值为3）的学生信息。
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 */
public class ObjectTest {
    public static void main(String[] args) {
        Student[] students = new Student[50];
        for (int i = 0; i < students.length; i++) { // 问题一
            int tempState = (int) (Math.random() * 6 + 1);
            int tempScore = (int) (Math.random() * 101);
            students[i] = new Student(i + 1, tempState, tempScore);
            if (tempState == 3) {
                System.out.println(students[i].toString());
            }
        }
        System.out.println("******************************************");
        sortState(students);
        sortSocre(students, true);
        for (Student stu : students) {
            System.out.println(stu.toString());
        }


    }

    public static void sortState(Student[] stus) {
        for (int i = stus.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (stus[j].getState() > stus[j + 1].getState()) {
                    swap(stus, j, j + 1);
                }
            }
        }

        // for (int i = 1; i < 7; i++) {
        //     for (int j = 0; j < stus.length; j++) {
        //         if (stus[j].getState() == i) {
        //             System.out.println(stus[j].toString());
        //         }
        //     }
        // }
    }


    public static void sortSocre(Student[] stus, boolean byState) {
        if (byState) {
            for (int i = stus.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (stus[j].getScore() > stus[j + 1].getScore() && stus[j].getState() == stus[j + 1].getState()) {
                        swap(stus, j, j + 1);
                    }
                }
            }
        } else {
            for (int i = stus.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (stus[j].getScore() > stus[j + 1].getScore()) {
                        swap(stus, j, j + 1);
                    }
                }
            }
        }

    }

    private static void swap(Student[] stus, int i, int j) {
        Student temp = stus[i];
        stus[i] = stus[j];
        stus[j] = temp;
    }

}


class Student {
    private int number;
    private int state;
    private int score;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int number, int state, int score) {
        this.number = number;
        this.state = state;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }
}
