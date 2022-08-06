package D_DependenciesInversion;

import java.util.ArrayList;

public class D {
    public static void run() {
        String origin = "C:\\Workspace\\Java\\SOLID-Principles\\assets\\posts.json";
        String dbPath = "C:\\Workspace\\Java\\SOLID-Principles\\assets\\db.json";
        String httpOrigin = "https://jsonplaceholder.typicode.com/todos/";

        IInfo info = new InfoByFile(origin);

        Monitor monitor = new Monitor(origin, info);
        monitor.show();

        FileDB fileDB = new FileDB(dbPath, origin, info);
        fileDB.save();

        System.out.println("\n\n");

        info = new InfoByRequest(httpOrigin);

        monitor = new Monitor(httpOrigin, info);
        monitor.show();

        fileDB = new FileDB(dbPath, httpOrigin, info);
        fileDB.save();
    }
}

interface IInfo {
    public ArrayList<Post> get();
}

class Post {
    public int id;
    public String title;

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

class Monitor {
    private String origin;
    private IInfo info;

    public Monitor(String origin, IInfo info) {
        this.origin = origin;
        this.info = info;
    }

    public void show() {
        var posts = info.get();

        for (var post : posts) {
            System.out.println(post.title);
        }
    }
}

class InfoByFile implements IInfo {
    private final String path;

    public InfoByFile(String path) {
        this.path = path;
    }

    public ArrayList<Post> get() {
        System.out.println("Informacion obtenida a traves de un archivo: " + this.path);

        var posts = new ArrayList<Post>();

        posts.add(new Post(1, "Hola Mundo"));
        posts.add(new Post(2, "C# es mejor que Java xd"));
        posts.add(new Post(3, "Las estructuras de datos importan mas que los frameworks"));

        return posts;
    }
}

class InfoByRequest implements IInfo {
    private final String url;

    public InfoByRequest(String url) {
        this.url = url;
    }

    public ArrayList<Post> get() {
        System.out.println("Informacion obtenida a traves de una peticion http: " + this.url);

        var posts = new ArrayList<Post>();

        posts.add(new Post(10, "JavaScript el mejor lenguaje de programacion"));
        posts.add(new Post(27, "Svelte el futuro de los frameworks"));
        posts.add(new Post(31, "¿Tailwind o css puro?"));

        return posts;
    }
}

class FileDB {
    private final String path;
    private final String origin;
    private IInfo info;

    public FileDB(String path, String origin, IInfo info) {
        this.path = path;
        this.origin = origin;
        this.info = info;
    }

    public void save() {
        System.out.println("Guardamos los posts de " + this.origin + " en " + this.path);
    }
}