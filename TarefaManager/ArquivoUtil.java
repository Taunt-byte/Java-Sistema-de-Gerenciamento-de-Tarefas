import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class ArquivoUtil {
    private static final String ARQUIVO = "tarefas.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvar(List<Tarefa> tarefas) {
        try (Writer writer = new FileWriter(ARQUIVO)) {
            gson.toJson(tarefas, writer);
            System.out.println("Tarefas salvas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public static List<Tarefa> carregar() {
        try (Reader reader = new FileReader(ARQUIVO)) {
            return gson.fromJson(reader, new TypeToken<List<Tarefa>>(){}.getType());
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado ou erro ao carregar.");
            return new ArrayList<>();
        }
    }
}
