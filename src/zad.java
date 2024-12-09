import java.util.*;
class Company {
    protected String name; // название компании
    protected int persons; // количество сотрудников
    protected int money; // месячный фонд зарплаты

    // Конструктор
    public Company(String name, int persons, int money) {
        this.name = name;
        this.persons = persons;
        this.money = money;
    }

    // Свойство
    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("В компании " + name +
                " трудятся " + persons + " сотрудников " +
                " фонд зарплаты " + money);
    }

    public int averageSalary() {
        return money / persons;
    }

    public int maxPersons(int salary /* средняя зарплата */) {
        return money / persons;
    }

    public int minus(int minus1 /* налог в % */, int minus2 /* отчисление в ПФ в % */) {
        return money * (minus1 + minus2) / 100;
    }
}

class InsCompany extends Company {
    int counts; // количество застрахованных лиц
    int summaplus; // сумма страховых взносов
    int summaminus; // сумма страховых выплат

    // Конструктор
    public InsCompany(String name, int persons, int money, int counts, int summaplus, int summaminus) {
        super(name, persons, money); // Вызов конструктора базового класса
        this.counts = counts;
        this.summaplus = summaplus;
        this.summaminus = summaminus;
    }

    // Свойство
    public int getSummaplus() {
        return summaplus;
    }

    // Печать информации о страховой компании
    public void show() {
        super.show();
        System.out.println("застрахованных лиц " + counts +
                " взносы  " + summaplus +
                " выплаты   " + summaminus);
    }

    // Вычисление среднего размера страховых взносов
    public int averageIns() {
        return summaplus / counts;
    }
}

class AvtoCompany extends Company {
    int count; // количество автомобилей
    int haul; // объём грузоперевозок

    // Конструктор
    public AvtoCompany(String name, int persons, int money, int count, int haul) {
        super(name, persons, money); // Вызов конструктора базового класса
        this.count = count;
        this.haul = haul;
    }

    // Определение среднего объема грузоперевозок
    public int averageAvto() {
        return haul / count;
    }

    // Печать информации об автокомпании
    public void show() {
        super.show();
        System.out.println("количество автомобилей " + count +
                " объем грузоперевозок " + haul);
    }
}

class MyDemo {
    public static void main(String[] args) {
        Company[] newcomp = new Company[4];
        newcomp[0] = new InsCompany("FIRST", 3, 30000, 50000, 500000, 100000);
        newcomp[1] = new AvtoCompany("BEST", 20, 500000, 50, 800000);
        newcomp[2] = new InsCompany("FOOD", 20, 500000, 5, 800000, 50000);
        newcomp[3] = new AvtoCompany("GOOD", 30, 300000, 500, 500000);

        for (int i = 0; i < newcomp.length; i++) {
            // содержит ли newcomp[i] ссылку на объект класса InsCompany?
            if (newcomp[i] instanceof InsCompany) {
                // явное приведение типа объекта
                InsCompany A = (InsCompany) newcomp[i];
                A.show();// статическое связывание
            } else {
                AvtoCompany B = (AvtoCompany) newcomp[i];
                B.show();// статическое связывание
            }
        }
    }
}
