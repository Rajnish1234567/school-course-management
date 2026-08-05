JDK version used : OpenJDK 17.0.12

 “Hello World” program Explanation.

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

Here,Main class is public, which means can be accessed from any file within the project.

    Access modifier of main method is public which means it is accessible
    from every class of the project.

    Static keyword tells that the method is class level
    method and can directly be called using class.

    void tells that this method will not return anything
    to the caller.

    (String[] args) this tells that the main method accept
    array of string as input.

    Inside the method we are using System.out.println.
        Here System is the the class and out.println is the 
        static method which uses printStrem to print the
        input.
