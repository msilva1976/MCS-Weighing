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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    protected static final CavaloModel newValue = null;
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
    private CavaloModel selecionada;
    private BobModel selecionadaB;
    private CarretaModel selecionadac;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initCarreta();
        initBob();
        initCavalo();

        // initTableCarreta();
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
        btnCavaloDeleta.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                deleta();
            }
        });
        btnCavaloDeleta.setOnMouseClicked((KeyEvent) -> {
            deleta();

        });
        btnBobDeleta.setOnMouseClicked((MouseEvent)->{
            deletab();
        });
        btnBobDeleta.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                deletab();
            }
        });
        btccarredeleta.setOnMouseClicked((MouseEvent)->{
            deletac();
        });
        btccarredeleta.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                deletac();
            }
        });
        tbtCavaloCavalo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends CavaloModel> observable, CavaloModel oldValue,
                    CavaloModel newValue) {
                selecionada = (CavaloModel) newValue;
            }

        });
        tbtBob.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends BobModel> observable, BobModel oldValue, BobModel newValue) {
                selecionadaB = (BobModel) newValue;
                

            }

        });
        tbtcarretas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends CarretaModel> observable, CarretaModel oldValue, CarretaModel newValue) {
               
               selecionadac = (CarretaModel) newValue;
               System.out.println("selecionada");

            }

        });

    };

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

    public void initCarreta() {
        tblCarrFrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblCarrCarreta.setCellValueFactory(new PropertyValueFactory<>("carreta"));
        tblCarrCavalo.setCellValueFactory(new PropertyValueFactory<>("cavalo"));
        tblCarrMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));
        tblCarrEixos.setCellValueFactory(new PropertyValueFactory<>("eixos"));
        tblCarrDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tblCarrCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
        tbtcarretas.setItems(atualizaCarreta());
    }

    public ObservableList<CarretaModel> atualizaCarreta() {
        CarretaDao carretaDao = new CarretaDao();
        return FXCollections.observableArrayList(carretaDao.getList());
    }

    public void initBob() {
        tblBobfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblBobPlca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tblBobTara.setCellValueFactory(new PropertyValueFactory<>("tara"));
        tblBobNomeMo.setCellValueFactory(new PropertyValueFactory<>("motorista"));
        tbtBob.setItems(atualizaBob());
    }

    public ObservableList<BobModel> atualizaBob() {
        BobDao bobDao = new BobDao();
        return FXCollections.observableArrayList(bobDao.getList());
    }

    public void initCavalo() {
        tblCavaloFrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        tblCavaloCavalo.setCellValueFactory(new PropertyValueFactory<>("cavalo"));
        tblCavaloEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        tblCavaloMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));
        tbtCavaloCavalo.setItems(atualizarCavalo());

    }

    public ObservableList<CavaloModel> atualizarCavalo() {
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

    public void deleta() {
        if (selecionada != null) {
            Cavalodao cavalodao = new Cavalodao();
            cavalodao.cavalodelete(selecionada);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Cavalo deletado");
            alert.showAndWait();
            tbtCavaloCavalo.setItems(atualizarCavalo());

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Selecione um cavalo! ");
            alert.showAndWait();

        }

    }
    public void deletab(){
        if (selecionadaB != null) {
            BobDao bobDao = new BobDao();
            bobDao.bobDeleta(selecionadaB);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Bobtail deletado com sucesso");
            alert.showAndWait();
            tbtBob.setItems(atualizaBob());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Selecione uma Bobtail.");   
            alert.showAndWait();         
        }
        
    }
    public void deletac(){
        if (selecionadac != null ) {
            CarretaDao carretaDao = new CarretaDao();
            carretaDao.deletaCarreta(selecionadac);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Carreta deletada com sucesso");
            alert.showAndWait();
            tbtcarretas.setItems(atualizaCarreta());
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Selecione uma Carreta");
            alert.showAndWait();
        }
    }
    
    

    }


