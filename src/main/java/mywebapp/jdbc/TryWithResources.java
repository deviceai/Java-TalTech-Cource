package mywebapp.jdbc;

public class TryWithResources {

    public static void main(String[] args) {
        MyAutoClosable c1 = new MyAutoClosable("c1");

        try(c1; MyAutoClosable c2 = new MyAutoClosable("c2")){
            System.out.println("in try block");
            throw new RuntimeException("error");
        }
        catch (Exception e) {
            System.out.println("in catch block");
        }

        System.out.println("after try/catch block");
    }

    private static class MyAutoClosable implements AutoCloseable  {
        private String name;

        public MyAutoClosable(String name){
            this.name = name;
            System.out.println("creating MyAutoCloseable " + name);
        }

        @Override
        public void close() throws Exception {
            System.out.println("closing MyAutoCloseable " + name);
        }
    }
}
