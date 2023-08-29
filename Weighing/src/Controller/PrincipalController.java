package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import App.Bobs;
import App.Carreta;
import App.Cavalo;
import App.Principal;
import App.Usuarios;
import DAO.BobDao;
import DAO.CarretaDao;
import DAO.Cavalodao;
import DAO.PessoaDao;
import Model.BobModel;
import Model.CarretaModel;
import Model.CavaloModel;
import Model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    @FXML    private Tab abaBob;
    @FXML    private Tab abaCarretas;
    @FXML    private Tab abaUser;
    @FXML    private Button btbBobBusca;    
    @FXML    private Button btccarredeleta;
    @FXML    private Button btnAtualiza;
    @FXML    private Button btnBobAtualiza;
    @FXML    private Button btnBobDeleta;
    @FXML    private Button btnCarreBusca;
    @FXML    private Button btnCavaloAtualiza;
    @FXML    private Button btnCavaloDeleta;
    @FXML    private Button btnCavaloOk;
    @FXML    private Button btnDeleta;
    @FXML    private Button btnbusca;
    @FXML    private Button btncarreatualiza;
    @FXML    private MenuItem menuBobs;
    @FXML    private MenuItem menuCarretas;
    @FXML    private MenuItem menuCavalos;
    @FXML    private MenuItem menuSair;
    @FXML    private MenuItem menuUsuarios;
    @FXML    private TableColumn<Pessoa, String> tbUseUser;
    @FXML    private TableColumn<Pessoa, String> tbUserNome;
    @FXML    private TableColumn<Pessoa, String> tbUserSenha;  
    @FXML    private TableColumn<BobModel, String> tblBobfrota;  
    @FXML    private TableColumn<BobModel, String> tblBobPlca;
    @FXML    private TableColumn<BobModel, String> tblBobTara;    
    @FXML    private TableColumn<BobModel, String> tblBobNomeMo;
    @FXML    private TableColumn<CarretaModel, String> tblCarrFrota;
    @FXML    private TableColumn<CarretaModel, String> tblCarrCarreta;
    @FXML    private TableColumn<CarretaModel, String> tblCarrCavalo;
    @FXML    private TableColumn<CarretaModel, String> tblCarrMotorista;
    @FXML    private TableColumn<CarretaModel, String> tblCarrEixos;
    @FXML    private TableColumn<CarretaModel, String> tblCarrDestino;
    @FXML    private TableColumn<CarretaModel, String> tblCarrCapacidade; 
    @FXML    private TableColumn<CavaloModel,String> tblCavaloCavalo;
    @FXML    private TableColumn<CavaloModel,String> tblCavaloEmpresa;
    @FXML    private TableColumn<CavaloModel,String> tblCavaloFrota;
    @FXML    private TableColumn<CavaloModel,String> tblCavaloMotorista;
    @FXML    private TableView<CavaloModel> tbtCavaloCavalo;
    @FXML    private TextField txtCavaloBusca;   
    @FXML    private TableView<BobModel> tbtBob;
    @FXML    private TableView<Pessoa> tbtUser;
    @FXML    private TableView<CarretaModel> tbtcarretas;
    @FXML    private TextField txtBusca;
    @FXML    private TextField txtcarreBusca;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initCarreta();
        initBob();
        initCavalo();
       
        //initTableCarreta();
        menuSair.setOnAction((KeyEvent) -> {
            fechar();
        });
        menuUsuarios.setOnAction((KeyEvent) -> {
            abreUsuario();
        });
        menuCavalos.setOnAction((KeyEvent) -> {
            abreCavalo();
        });
        menuCarretas.setOnAction((KeyEvent) -> {
            abreCarretas();
        });
        menuBobs.setOnAction((KeyEvent) -> {
            abreBobs();
        });

    }

    public void initTable() {
        tbUseUser.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbUserNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbUserSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        tbtUser.setItems(atualizarTabela());
    }

    public ObservableList<Pessoa> atualizarTabela() {
        PessoaDao pessoaDao = new PessoaDao();

        return FXCollections.observableArrayList(pessoaDao.getList());

    }
    public void initCarreta(){
        tblCarrFrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblCarrCarreta.setCellValueFactory(new PropertyValueFactory<>("carreta"));
        tblCarrCavalo.setCellValueFactory(new PropertyValueFactory<>("cavalo"));
        tblCarrMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));
        tblCarrEixos.setCellValueFactory(new PropertyValueFactory<>("eixos"));
        tblCarrDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tblCarrCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
        tbtcarretas.setItems(atualizaCarreta());     
    }
    
    public ObservableList<CarretaModel>atualizaCarreta(){
        CarretaDao carretaDao  = new CarretaDao();
        return FXCollections.observableArrayList(carretaDao.getList());
    }
    public void initBob(){
        tblBobfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblBobPlca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tblBobTara.setCellValueFactory(new PropertyValueFactory<>("tara"));
        tblBobNomeMo.setCellValueFactory(new PropertyValueFactory<>("motorista"));
        tbtBob.setItems(atualizaBob());
    }
    public ObservableList<BobModel>atualizaBob(){
        BobDao bobDao = new BobDao();
        return FXCollections.observableArrayList(bobDao.getList());
    }
    public void initCavalo(){
        tblCavaloFrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblCavaloCavalo.setCellValueFactory(new PropertyValueFactory<>("cavalo"));
        tblCavaloEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        tblCavaloMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));    
        tbtCavaloCavalo.setItems(atualizarCavalo());   

    }
    public ObservableList<CavaloModel>atualizarCavalo(){
        Cavalodao cavalodao = new Cavalodao();
        return FXCollections.observableArrayList(cavalodao.getList());

    }
    
    
   
    

    

    

    public void fechar() {
        Principal.getStage().close();
    }

    public void abreUsuario() {
        Usuarios usuarios = new Usuarios();

        try {
            Principal.getStage().close();
            usuarios.start(new Stage());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void abreCavalo() {
        Cavalo cavalo = new Cavalo();
        try {
            Principal.getStage().close();
            cavalo.start(new Stage());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void abreCarretas() {
        Carreta carretas = new Carreta();
        try {
            Principal.getStage().close();
            carretas.start(new Stage());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void abreBobs() {
        Principal.getStage().close();
        Bobs bobs = new Bobs();
        try {

            bobs.start(new Stage());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
