package Exercicio14;

public class UsuarioRepository {

    @Inject
    private BancoDeDados bancoDeDados;

    public void salvar(){
        bancoDeDados.conectar();
        System.out.println("Usuário Salvo!");
    }
}
