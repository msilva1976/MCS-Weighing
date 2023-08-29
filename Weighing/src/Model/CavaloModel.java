package Model;

public class CavaloModel {
  private long id;
  private String frota;
  private String cavalo;
  private String empresa;
  private String motorista;
  public CavaloModel(long id, String frota, String cavalo, String empresa, String motorista) {
    this.id = id;
    this.frota = frota;
    this.cavalo = cavalo;
    this.empresa = empresa;
    this.motorista = motorista;
  }
  public CavaloModel(String frota, String cavalo, String empresa, String motorista) {
    this.frota = frota;
    this.cavalo = cavalo;
    this.empresa = empresa;
    this.motorista = motorista;
  }
  public CavaloModel() {
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
  public String getCavalo() {
    return cavalo;
  }
  public void setCavalo(String cavalo) {
    this.cavalo = cavalo;
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


}