package Exercicio13;

public class Main {
    public static void main(String[]args){

        EntityManager<User, Integer> em = new EntityManager<>(User.class);

        em.save(new User(1, "Matheus"));
        em.save(new User(2, "Vinicius"));

        User encontrado = em.findById(1);
        System.out.println("findById(1) -> " + encontrado);

        em.delete(1);
        System.out.println("findById(1) após delete -> " + em.findById(1));
    }
}
