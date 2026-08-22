package Exercicio13;

public class EntityManager<T, ID> {

    private final MetaDadosEntity metadados;
    private final GeradorSql sql = new GeradorSql();
    private final BancoNaMemoria<ID, T> banco = new BancoNaMemoria<>();

    public EntityManager(Class<T> classeEntidade) {
        this.metadados = new MetaDadosEntity(classeEntidade);
    }

    @SuppressWarnings("unchecked")
    public void save(T entidade) {
        try {
            String query = sql.insert(metadados, entidade);
            banco.executar(query);

            ID id = (ID) metadados.getCampoId().get(entidade);
            banco.inserir(id, entidade);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Falha ao ler campos de " + entidade, e);
        }
    }

    public T findById(ID id) {
        banco.executar(sql.selectPorId(metadados, id));
        return banco.buscar(id);
    }

    public void delete(ID id) {
        banco.executar(sql.delete(metadados, id));
        banco.remover(id);
    }
}
