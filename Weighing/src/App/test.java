package App;

import java.util.List;

import DAO.PessoaDao;
import Model.Pessoa;

//SELECT * FROM mydb.pessoa;ALTER TABLE pessoa AUTO_INCREMENT = 1;

public class test {
  // // INSERIR PESSOAS
  // public static void main(String[] args) {
  // Pessoa pessoa =  new Pessoa("mantonio", "Marcos Antonio", "1234");
  // PessoaDao dao = new PessoaDao();
  // if (dao.add(pessoa)) {
  //   System.out.println("Usuario Cadastrado");
  // }else{
  // System.out.println("Usuario não Cadastrado");
  // }}


  //UPDATE PESSOAS
  // public static void main(String[] args) {
  // Pessoa pessoa =  new Pessoa(4l,"rmarques", "Marcos Antonio Marques", "1234");
  // PessoaDao dao = new PessoaDao();
  // if (dao.update(pessoa)) {
  //   System.out.println("Usuario atualizado");
  // }else{
  // System.out.println("Usuario não atualizado");
  // }}

  // public static void main(String[] args) {
  //   Pessoa pessoa = new Pessoa(1);  
  // PessoaDao dao = new PessoaDao();
  // if (dao.delete(pessoa)) {
  //   System.out.println("Usuario deletado");
  // }else{
  // System.out.println("Usuario não deletado");
  // }}

  public static void main(String[] args) {
    PessoaDao dao = new PessoaDao();
    List<Pessoa>pessoas = dao.getList();

    if (pessoas != null) {
      for (int x = 0;x < pessoas.size();x++) {
        pessoas.get(x).mostraPessoa();
        System.out.println("_____________________________");
      }
      
    } else {
      System.out.println("lista nula");
    }
  
    
  }
}
