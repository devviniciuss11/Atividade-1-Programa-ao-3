package Exercicio14;

public class Main {
    public static void main(String[] args) {

        System.out.println("== Caso 1: cadeia completa de dependências ==");

        UsuarioService service = Container.criar(UsuarioService.class);
        service.cadastrar();

        System.out.println();
        System.out.println("== Caso 2: dependência não encontrada (tratado) ==");
        try {
            Container.criar(ServicoSemImplementacao.class);
        } catch (Container.DependenciaNaoEncontradaException e) {
            System.out.println("Erro tratado -> " + e.getMessage());
        }
    }
}

interface Notificador {
    void notificar();
}

class ServicoSemImplementacao {
    @Inject
    private Notificador notificador;

    public void executar() {
        notificador.notificar();
    }
}
