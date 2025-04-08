import java.util.*;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas;
    private int proximoId = 1;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa nova = new Tarefa(proximoId++, descricao);
        tarefas.add(nova);
    }

    public void editarTarefa(int id, String novaDescricao) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setDescricao(novaDescricao);
        }
    }

    public void removerTarefa(int id) {
        tarefas.removeIf(t -> t.getId() == id);
    }

    public void marcarComoConcluida(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.marcarConcluida();
        }
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    public Tarefa buscarTarefaPorId(int id) {
        return tarefas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
        this.proximoId = tarefas.stream()
                .mapToInt(Tarefa::getId)
                .max()
                .orElse(0) + 1;
    }
}
