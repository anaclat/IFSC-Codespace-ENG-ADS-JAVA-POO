import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repositorio<T> {

    private List<T> dados;

    public Repositorio() {
        this.dados = new ArrayList<>();
    }

    public void adicionar(T item) {
        dados.add(item);
        System.out.println("Item adicionado com sucesso!");
    }

    public boolean remover(T item) {
        if (dados.remove(item)) {
            System.out.println("Item removido com sucesso!");
            return true;
        } else {
            System.out.println("Item não encontrado.");
            return false;
        }
    }

    public Optional<T> buscarPorIndice(int indice) {
        if (indice >= 0 && indice < dados.size()) {
            return Optional.of(dados.get(indice));
        } else {
            System.out.println("Índice inválido.");
            return Optional.empty();
        }
    }

    // Método para listar todos os itens
    public void listarTodos() {
        if (dados.isEmpty()) {
            System.out.println("Repositório vazio.");
        } else {
            System.out.println("Itens no repositório:");
            for (T item : dados) {
                System.out.println(item);
            }
        }
    }

    // Método para buscar por uma condição personalizada
    public List<T> buscarPorCondicao(java.util.function.Predicate<T> condicao) {
        List<T> resultado = new ArrayList<>();
        for (T item : dados) {
            if (condicao.test(item)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        Repositorio<String> repositorio = new Repositorio<>();

        // Adicionando itens
        repositorio.adicionar("Maçã");
        repositorio.adicionar("Banana");
        repositorio.adicionar("Laranja");

        // Listando itens
        repositorio.listarTodos();

        // Buscando por índice
        Optional<String> itemEncontrado = repositorio.buscarPorIndice(1);
        itemEncontrado.ifPresent(item -> System.out.println("Encontrado: " + item));

        // Removendo um item
        repositorio.remover("Banana");

        // Listando após remoção
        repositorio.listarTodos();

        // Buscar por condição (exemplo: itens que começam com 'L')
        List<String> itensComL = repositorio.buscarPorCondicao(s -> s.startsWith("L"));
        System.out.println("Itens que começam com 'L': " + itensComL);
    }
}