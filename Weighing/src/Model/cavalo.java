package Model;

public class cavalo {
  private long id;
  private String frota;
  private String placa;
  private String empresa;
  private String motorista;
  public cavalo(long id, String frota, String placa, String empresa, String motorista) {
    this.id = id;
    this.frota = frota;
    this.placa = placa;
    this.empresa = empresa;
    this.motorista = motorista;
  }
  public cavalo(String frota, String placa, String empresa, String motorista) {
    this.frota = frota;
    this.placa = placa;
    this.empresa = empresa;
    this.motorista = motorista;
  }
  public cavalo() {
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
  public String getEmpresa() {
    return empresa;
  }
  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }
  public String getMotorista() {
    return motorista;
  }
  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }
  public String getCavalo() {
    return null;
  }
  public long getid() {
    return 0;
  }
  public void add(Object cavalob) {
  }
  
}
