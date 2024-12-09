import java.util.*;
    abstract class worker { // сотрудник
        protected String name;
        protected double salary; // начисление зарплаты

        public abstract double Give_Salary();
    }

    // постоянный работник
    class constworker extends worker {
        int year;
        double coef;

        public constworker(int year, double coef) {
            this.year = year;
            this.coef = coef;
        }

        // начисление зарплаты постоянному работнику
        @Override
        public double Give_Salary() {
            return (500 * year * coef);
        }
    }

    // временный работник
    class temporaryworker extends worker {
        int hours;

        public temporaryworker(int hours) {
            this.hours = hours;
        }

        // начисление зарплаты временному работнику
        @Override
        public double Give_Salary() {
            return (300 * hours);
        }
    }

    class Program {
        public static void main(String[] args) {
            worker[] factory = new worker[4];
            factory[0] = new constworker(5, 1.1);
            factory[1] = new temporaryworker(10);
            factory[2] = new temporaryworker(6);
            factory[3] = new constworker(6, 2.1);

            System.out.println(" Размер зарплаты ");
            for (int i = 0; i < 4; i++) {
                if (factory[i] instanceof constworker) {
                    System.out.print("постоянного работника: ");
                } else {
                    System.out.print("временного работника:  ");
                }
                System.out.println(" " + factory[i].Give_Salary());
            }
        }
    }