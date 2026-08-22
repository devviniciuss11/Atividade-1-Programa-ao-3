package Exercicio13;

@Entity(tabela = "usuarios")
public class User {

    @Id
    @Column(nome = "id")
    private int id;

    @Column(nome = "nome_usuario")
    private String nome;

    public User() {} // necessário para reflection recriar o objeto

    public User(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", nome='" + nome + "'}";
    }
}