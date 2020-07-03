package Model;

public class MovieTableModel {
    int id;
    String titulo, director, duración, funciones, clasificacion, catelera;

    public MovieTableModel(int id, String titulo, String director, String duración, String funciones, String clasificacion, String catelera) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duración = duración;
        this.funciones = funciones;
        this.clasificacion = clasificacion;
        this.catelera = catelera;
    }

    public MovieTableModel(int id, String titulo, String director, String duración, String funciones, String clasificacion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duración = duración;
        this.funciones = funciones;
        this.clasificacion = clasificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuración() {
        return duración;
    }

    public void setDuración(String duración) {
        this.duración = duración;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCatelera() {
        return catelera;
    }

    public void setCatelera(String catelera) {
        this.catelera = catelera;
    }
}
