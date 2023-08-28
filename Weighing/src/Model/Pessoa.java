package Model;

public class Pessoa {
  private long id;
  private String user;  
  private String nome;
  private String senha;
 
  public Pessoa(long id, String user, String nome, String senha) {
    this.id = id;
    this.user = user;
    this.nome = nome;
    this.senha = senha;
  }
  public Pessoa(String user, String nome, String senha) {
    this.user = user;
    this.nome = nome;
    this.senha = senha;
  }
    public Pessoa() {
   
  }
 
 
  
  public Pessoa(long i) {
  }
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public void mostraPessoa(){
    System.out.println("   ID: "+ getId());
    System.out.println(" User: "+getUser());
    System.out.println(" Nome: "+getNome());
    System.out.println("Senha: "+getSenha());
  }
  

  
  
}
