public class Main {
    public static void main(String[] args) {
        System.out.println("hello Studying spring boot");
        System.out.println(fibonacci(10));
    }
    static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
        // this works because first we will go on till n-1 and start building the left term then start building sum from left till the n
    }
}