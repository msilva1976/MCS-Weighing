package Controller;

import java.net.URL;
import java.util.ResourceBundle;
///import App.ListarPessoa;
import App.Bobs;
import App.Carretas;
import App.Cavalo;
import App.Principal;
import App.Usuarios;
import DAO.PessoaDao;
import Model.Pessoa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    @FXML    private Tab abaBob;
    @FXML    private Tab abaCarretas;
    @FXML    private Tab abaUser;
    @FXML    private Button btnAtualiza;
    @FXML    private Button btnDeleta;
    @FXML    private Button btnbusca;
    @FXML    private MenuItem menuBobs;
    @FXML    private MenuItem menuCarretas;
    @FXML    private MenuItem menuCavalos;
    @FXML    private MenuItem menuSair;
    @FXML    private MenuItem menuUsuarios;
    @FXML    private TableColumn<Pessoa, String> tbUseUser;
    @FXML    private TableColumn<Pessoa, String> tbUserNome;
    @FXML    private TableColumn<Pessoa, String> tbUserSenha;
    @FXML    private TabPane tbtTaberlaUser;
    @FXML    private TableView<Pessoa> tbwUser;
    @FXML    private TextField txtBusca;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
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
        // tbwUser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

        //     @Override
        //     public void changed(ObservableValue<? extends T> arg0, T arg1, T arg2) {
        //         
        //         throw new UnsupportedOperationException("Unimplemented method 'changed'");
        //     }
            
        // });;

    }

    public void initTable(){
        tbUseUser.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbUserNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbUserSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        tbwUser.setItems(atualizarTabela());

    }
    public ObservableList<Pessoa>atualizarTabela(){
        PessoaDao pessoaDao = new PessoaDao();

        
        return FXCollections.observableArrayList(pessoaDao.getList());

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
        Carretas carretas = new Carretas();
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
    // public void ListarPessoa(){
    //     ListarPessoa pessoa = new ListarPessoa();


    // }

}
