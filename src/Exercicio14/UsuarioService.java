package Exercicio14;

public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public void cadastrar(){
        usuarioRepository.salvar();
        System.out.println("Usuário Cadastrado!");
    }
}
