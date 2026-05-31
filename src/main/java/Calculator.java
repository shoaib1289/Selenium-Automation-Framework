public class Calculator {

    int a;
    int b;
    int n;

    public int add(int a, int b){
        return (a+b);

    }
    public int multiply(int a, int b){
        return (a*b);
    }
    public int substract(int a, int b){
        return (a-b);

    }
    public boolean isPositive(int n){
        if(n>0){
            return true;
        }
        return false;
    }
    public String describer(int n) {
        if (n > 0) {
            System.out.println("positive;" + n);
        } else if (n < 0) {
            System.out.println("negative:" + n);
        } else {
            System.out.println("zero:" + n);
        }
        return "";
    }




        public static void main(String[] args){
        Calculator calculator= new Calculator();
        System.out.println(calculator.add(5,9));
        System.out.println(calculator.multiply(4,8));
        System.out.println(calculator.substract(6,8));
        System.out.println(calculator.isPositive(6));
        System.out.println(calculator.describer(0));
        }
}



