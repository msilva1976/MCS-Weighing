package Model;

public class CarretaModel {
  private long id;
  private String frota;
  private String carreta;
  private String cavalo;
  private String motorista;
  private String eixos;
  private String destino;
  private String capacidade;
  public CarretaModel(long id, String frota, String carreta, String cavalo, String motorista, String eixos,
      String destino, String capacidade) {
    this.id = id;
    this.frota = frota;
    this.carreta = carreta;
    this.cavalo = cavalo;
    this.motorista = motorista;
    this.eixos = eixos;
    this.destino = destino;
    this.capacidade = capacidade;
  }
  public CarretaModel(String frota, String carreta, String cavalo, String motorista, String eixos, String destino,
      String capacidade) {
    this.frota = frota;
    this.carreta = carreta;
    this.cavalo = cavalo;
    this.motorista = motorista;
    this.eixos = eixos;
    this.destino = destino;
    this.capacidade = capacidade;
  }
  public CarretaModel() {
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
  public String getCarreta() {
    return carreta;
  }
  public void setCarreta(String carreta) {
    this.carreta = carreta;
  }
  public String getCavalo() {
    return cavalo;
  }
  public void setCavalo(String cavalo) {
    this.cavalo = cavalo;
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
  
  
  
  

  
}
