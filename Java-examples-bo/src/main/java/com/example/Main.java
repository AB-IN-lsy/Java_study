import java.util.Scanner;
interface ComputerAverage {
    //start
    double average(double[] data);
    //write your code between start and  end,do not  delete any code
    //end
}
class Gymnastics implements ComputerAverage {
    public double average(double []data) {
        double sum=0;
        double temp;
        double mx = -1, mn = 0x3f3f3f;
        for (int i = 0; i < data.length; i++){
            mx = Math.max(mx, data[i]);
            mn = Math.min(mn, data[i]);
            sum += data[i];
        }
        return (sum - mn - mx) / (data.length - 2);
        //start
        //write your code between start and  end,do not  delete any code
        //end
    }
}
class School implements ComputerAverage{
    //start
    public double average(double []data) {
        double sum=0;
        for (int i = 0; i < data.length; i++){
            sum += data[i];
        }
        return sum / data.length;
        //start
        //write your code between start and  end,do not  delete any code
        //end
    }
    //write your code between start and  end,do not  delete any code
    //end
}

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        double []data=new double[n];
        for(int i=0;i<n;i++){
            data[i]=scan.nextDouble();
        }
        //start
        ComputerAverage g = new Gymnastics();
        //write your code between start and  end,do not  delete any code
        //end
        System.out.print("Gymnastics average is:");
        System.out.printf("%.2f\n",g.average(data));
        //start
        g = new School();
        //write your code between start and  end,do not  delete any code
        //end
        System.out.print("School average is:");
        System.out.printf("%.2f",g.average(data));
    }
}