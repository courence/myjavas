package practice.temp.hashcode;

public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id ,String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{\"User\":{");
        sb.append("\"id\":\"").append(id).append("\"").append(",");
        sb.append("\"name\":\"").append(name).append("\"");
        sb.append("}}");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}