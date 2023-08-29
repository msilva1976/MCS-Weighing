package Model;

public class BobModel {
  private long id;
  private String frota;
  private String placa;
  private String tara;
  private String motorista;
  public BobModel(long id, String frota, String placa, String tara, String motorista) {
    this.id = id;
    this.frota = frota;
    this.placa = placa;
    this.tara = tara;
    this.motorista = motorista;
  }
  public BobModel(String frota, String placa, String tara, String motorista) {
    this.frota = frota;
    this.placa = placa;
    this.tara = tara;
    this.motorista = motorista;
  }
  public BobModel() {
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
  public String getPlaca() {
    return placa;
  }
  public void setPlaca(String placa) {
    this.placa = placa;
  }
  public String getTara() {
    return tara;
  }
  public void setTara(String tara) {
    this.tara = tara;
  }
  public String getMotorista() {
    return motorista;
  }
  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }

  
  
}
