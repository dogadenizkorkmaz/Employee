public class Employee {
    //nitelikleri
    String name;
    double salary;
    int workHours, hireYear;

    public Employee(){          /*Parametresiz bir kurucu metod oluşturmak için yazılmıştır.
                                 Bir Employee nesnesi oluşturulurken parametresiz olarak çağrılır */
        this.name = "Null";      // ve bu nesnenin niteliklerine varsayılan değerler atanır.
        this.salary = 0;
        this.workHours = 0;
        this.hireYear = 0;
    }
    public Employee(String name, double salary, int workHours, int hireYear){ //Kurucu metot olup 4 parametre alacaktır.
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax(){
        if(salary > 1000)   //Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
            return (salary * 3) / 100;
        else                //Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
            return 0;
    }
    public double bonus(){  //Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
        if(workHours > 30)
            return (workHours - 40) * 30;
        else
            return 0;
    }
    public double raiseSalary(){  //Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
        if(2021 - hireYear < 10){
            return ((salary * 5) / 100); //Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
        }
        else if(2021 - hireYear > 9 && 2021 - hireYear < 20){
            return ((salary * 10) / 100); //Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
        }
        else if(2021 - hireYear > 19 ){
            return ((salary * 15) / 100); //Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
        }
        else
            return 0;
    }
    public void toStringg(){ // Çalışana ait bilgileri ekrana bastıracaktır.
        double total = salary + bonus() - tax();
        double netSalary= salary + raiseSalary();

        System.out.println("Adı: " + name + "\n" +
                "Maaşı: " + salary + "\n" +
                "Çalışma Saati: " + workHours + "\n" +
                "Başlangıç Yılı: " + hireYear + "\n" +
                "Vergi: " + tax() + "\n" +
                "Bonus: " + bonus() + "\n" +
                "Maaş Artışı: " + raiseSalary() + "\n" +
                "Vergi ve Bonuslar ile birlikte maaş: "  + total + "\n" +
                "Toplam Maaş: " + netSalary);
    }

    public static void main(String[] args)
    {
        Employee employee = new Employee("kemal", 2000, 45, 1985);
        employee.toStringg();
    }

}

