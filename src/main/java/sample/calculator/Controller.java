package sample.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_caler;

    @FXML
    private Button comma_btn;

    @FXML
    private Button delen_btn;

    @FXML
    private Label lable_feald;

    @FXML
    private Button minus_btn;

    @FXML
    private Button mlt_btn;

    @FXML
    private Button pecent_btn;

    @FXML
    private Button pluse_btn;

    @FXML
    private Button pluse_minus_bnt;

    @FXML
    private Button resoul_btn;

    @FXML
    private Button zero_btn;
    private String str_num = "";
    private float firts_num = 0;
    private char operation;
    @FXML
    void initialize() {
zero_btn.setOnAction(event->{
    addNumber(0);
});
        btn_1.setOnAction(event->{
            addNumber(1);
        });
        btn_2.setOnAction(event->{
            addNumber(2);
        });
        btn_3.setOnAction(event->{
            addNumber(3);
        });
        btn_4.setOnAction(event->{
            addNumber(4);
        });
        btn_5.setOnAction(event-> addNumber(5));
        btn_6.setOnAction(event-> addNumber(6));
        btn_7.setOnAction(event-> addNumber(7));
        btn_8.setOnAction(event-> addNumber(8));
        btn_9.setOnAction(event-> addNumber(9));
        pluse_btn.setOnAction(event->{
            mathAcion('+');
        });
       minus_btn.setOnAction(event->{
            mathAcion('-');
        });
        mlt_btn.setOnAction(event->{
            mathAcion('*');
        });
        delen_btn.setOnAction(event->{
            mathAcion('/');
        });
resoul_btn.setOnAction(actionEvent -> {
    if (this.operation == '+' || this.operation == '-'
            || this.operation == '*' || this.operation == '/')
        equalMethod();
});
comma_btn.setOnAction(actionEvent -> {
    if(!this.str_num.contains(".")){
        this.str_num +=".";
        lable_feald.setText(str_num);

    }
});
pecent_btn.setOnAction(actionEvent -> {
    if(this.str_num != "") {
        float num = Float.parseFloat(this.str_num)* 0.1f;
        this.str_num = Float.toString(num);
        lable_feald.setText(str_num);

    }
});
        pluse_minus_bnt.setOnAction(actionEvent -> {
            if(this.str_num != "") {
                float num = Float.parseFloat(this.str_num)* -1;
                this.str_num = Float.toString(num);
                lable_feald.setText(str_num);

            }
        });
        btn_caler.setOnAction(actionEvent -> {
            lable_feald.setText("0");
            this.str_num = "";
            this.operation ='A';
            this.firts_num = 0;
        });

    }

    private void equalMethod() {
        float res=0;
      switch (this.operation){
          case '+':
              res= this.firts_num+Float.parseFloat(this.str_num);
              break;
          case '-':
              res= this.firts_num-Float.parseFloat(this.str_num);
              break;
          case '*':
              res= this.firts_num*Float.parseFloat(this.str_num);
              break;
          case '/':
              if(Integer.parseInt(this.str_num)!= 0)
              res= this.firts_num/Float.parseFloat(this.str_num);
              else res=0;
              break;

      }
        lable_feald.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.firts_num = 0;
    }

    void mathAcion(char operation) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '*' && this.operation != '/') {
        this.firts_num = (Float.parseFloat(this.str_num));
        lable_feald.setText(String.valueOf(operation));
        this.str_num = "";
        this.operation = operation;
    }
    }

    void addNumber(int number){
        this.str_num += Integer.toString(number);
lable_feald.setText(str_num);
    }

}
