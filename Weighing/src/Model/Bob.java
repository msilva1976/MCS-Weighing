package Model;

public class Bob {
  private long id;
  private String frota;
  private String placa;
  private String tara;
  private String motorista;
 

  public Bob(long id, String frota, String placa, String tara, String motorista) {
    this.id = id;
    this.frota = frota;
    this.placa = placa;
    this.tara = tara;
    this.motorista = motorista;
  }
  
  
  public Bob() {
  }


  public Bob(long id) {
    this.id = id;
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
  public void mostrarBob(){
    System.out.println("__________________________________________");
    System.out.println("            id: "+getId());
    System.out.println("         Frota: "+getFrota());
    System.out.println("         Placa: "+getPlaca());
    System.out.println("          Tara: "+getTara());
    System.out.println("Nome Motorista: "+getMotorista());
  }
  public String getPlaca() {
    return placa;
  }
  public void setPlaca(String placa) {
    this.placa = placa;
  }
  
  

  
}
