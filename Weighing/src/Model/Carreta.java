package Model;

public class Carreta {
  private long id;
  private String frota;
  private String placaCarreta;
  private String placaCavalo;
  private String motorista;
  private String eixos;
  private String destino;
  private String capacidade;
  public Carreta(long id, String frota, String placaCarreta, String placaCavalo, String motorista, String eixos,
      String destino, String capacidade) {
    this.id = id;
    this.frota = frota;
    this.placaCarreta = placaCarreta;
    this.placaCavalo = placaCavalo;
    this.motorista = motorista;
    this.eixos = eixos;
    this.destino = destino;
    this.capacidade = capacidade;
  }
  public Carreta(String frota, String placaCarreta, String placaCavalo, String motorista, String eixos, String destino,
      String capacidade) {
    this.frota = frota;
    this.placaCarreta = placaCarreta;
    this.placaCavalo = placaCavalo;
    this.motorista = motorista;
    this.eixos = eixos;
    this.destino = destino;
    this.capacidade = capacidade;
  }
  public Carreta() {
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getFrota() {
    return frota;
  }
  public void setFrota(String frota) {
    this.frota = frota;
  }
  public String getPlacaCarreta() {
    return placaCarreta;
  }
  public void setPlacaCarreta(String placaCarreta) {
    this.placaCarreta = placaCarreta;
  }
  public String getPlacaCavalo() {
    return placaCavalo;
  }
  public void setPlacaCavalo(String placaCavalo) {
    this.placaCavalo = placaCavalo;
  }
  public String getMotorista() {
    return motorista;
  }
  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }
  public String getEixos() {
    return eixos;
  }
  public void setEixos(String eixos) {
    this.eixos = eixos;
  }
  public String getDestino() {
    return destino;
  }
  public void setDestino(String destino) {
    this.destino = destino;
  }
  public String getCapacidade() {
    return capacidade;
  }
  public void setCapacidade(String capacidade) {
    this.capacidade = capacidade;
  }
  public void mostracarretas(){
    System.out.println("__________________________________________________________________________");
    System.out.println("                   Id: "+getId());
    System.out.println("                Frota: "+getFrota());
    System.out.println("     Placa da carreta: "+getPlacaCarreta());
    System.out.println("      Placa do cavalo: "+getPlacaCavalo());
    System.out.println("            Motorista: "+getMotorista());
    System.out.println("                Eixos: "+getEixos());
    System.out.println("Capacidade Geometrica: "+getCapacidade());
    System.out.println("              Destino: "+getDestino());

  }
  
  

  
}
