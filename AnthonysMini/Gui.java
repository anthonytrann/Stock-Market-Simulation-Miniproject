
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class Gui
{
    private final int STK = 2;
    private Stock[] stockList = new Stock[STK];
    private ArrayList<Stock> stockInfo = new ArrayList<Stock>();

    private Portfolio prt = new Portfolio();

    private Panel p1 = new Panel();
    private Panel p2 = new Panel();
    private Label askProf = new Label("How much is your initial Balance?");
    private TextField getProf = new TextField(10);
    private JFrame frame = new JFrame("Stock Market Simulator");
    private Button submitButton = new Button("submit");

    private JFrame frame1 = new JFrame("Portfolio");
    private Button buyButton = new Button("Buy Shares");
    private Button sellButton = new Button("Sell Shares");
    private Button nextdatbutton = new Button("Next Day");

    private Panel p3 = new Panel();
    private Panel p4 = new Panel();
    private JFrame frame2 = new JFrame("Buy");
    private List listStock = new List();
    private TextField quantityTextField = new TextField(10);
    private Button buy = new Button("Buy");
    private String company;
    private JTable table;

    public Gui(){
        Stock s1 = new OilCompany();
        Stock s2 = new TechCompany();
        stockList[0] = s1;
        stockList[1] = s2;

        p1.setLayout(new FlowLayout());
        p1.add(askProf);
        p1.add(getProf);

        p2.add(submitButton);

        frame.add(p1);
        frame.add(p2);

        frame.setSize(500,200);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submitButton.addActionListener(new Action1());

    }

    class Action1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evt) {
            prt.setProfit(Double.parseDouble(getProf.getText()));
            prt.setValue(Double.parseDouble(getProf.getText()));
            sellbuynextday();
            frame.dispose();
        }
    }

    public void sellbuynextday(){

        frame1.setSize(600,275);
        frame1.setVisible(true);
        frame1.setLayout(new FlowLayout());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Label balanceLabel = new Label("Your current balance is: £" + prt.getProfit());
        Label portWorthLabel = new Label("Your whole portfolio is worth: £" + prt.getValue());
        frame1.add(balanceLabel);
        frame1.add(portWorthLabel);
        frame1.add(buyButton);
        frame1.add(sellButton);
        frame1.add(nextdatbutton);

        Object rowData[][] = {
                {stockList[0].getName(), "£" + stockList[0].getPrice(), stockList[0].getQuantity(), stockList[0].getLastPrice(), "", "", ""},
                {stockList[1].getName(), "£" + stockList[1].getPrice(), stockList[1].getQuantity(), stockList[1].getLastPrice(), "", "", ""}
        };
        Object columnNames[] = {"Company", "Buy Price", "Qty", "Last Price", "Market Value", "Gain", "Trade"};
        JTable table = new JTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        frame1.add(scrollPane, BorderLayout.CENTER);

        buyButton.addActionListener(new Action2(balanceLabel, portWorthLabel, scrollPane));
        sellButton.addActionListener(new Action2(balanceLabel, portWorthLabel, scrollPane));
        nextdatbutton.addActionListener(new Action2(balanceLabel, portWorthLabel, scrollPane));

    }

    class Action2 implements ActionListener{

        private Label balanceLabel;
        private Label portWorthLabel;
        private JScrollPane scrollPane;

        public Action2(Label balanceLabel, Label portWorthLabel, JScrollPane scrollPane){

            this.balanceLabel = balanceLabel;
            this.portWorthLabel = portWorthLabel;
            this.scrollPane = scrollPane;

        }

        public void actionPerformed(ActionEvent evt){


            if(evt.getActionCommand().equals("Buy Shares")){
                frame1.remove(balanceLabel);
                frame1.remove(portWorthLabel);
                frame1.remove(scrollPane);
                buy();

            } else if(evt.getActionCommand().equals("Sell Shares")){

                sell();

            } else if(evt.getActionCommand().equals("Next Day")){

                nextday();

            }

            frame1.dispose();

        }

    }

    public void buy(){

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1000, 400);
        frame2.setVisible(true);
        frame2.setLayout(new FlowLayout());

        Object rowData[][] = {
                {stockList[0].getName(), "£" + stockList[0].getPrice(), stockList[0].getQuantity(), stockList[0].getLastPrice(), "", "", ""},
                {stockList[1].getName(), "£" + stockList[1].getPrice(), stockList[1].getQuantity(), stockList[1].getLastPrice(), "", "", ""}
        };
        Object columnNames[] = {"Company", "Buy Price", "Qty", "Last Price", "Market Value", "Gain", "Trade"};
        table = new JTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        p3.add(scrollPane, BorderLayout.CENTER);

        listStock.add("Oil Company");
        listStock.add("Tech Company");

        p4.setLayout(new FlowLayout());
        p4.add(listStock);
        p4.add(quantityTextField);
        p4.add(buy);

        frame2.add(p3);
        frame2.add(p4);

        listStock.addActionListener(new Action3());
        buy.addActionListener(new Action4(scrollPane, listStock));

    }

    class Action3 implements ActionListener{

        public void actionPerformed(ActionEvent evt){

            company = evt.getActionCommand();

        }

    }

    class Action4 implements ActionListener{

        private JScrollPane scrollPane;
        private List listStock;

        public Action4(JScrollPane scrollPane, List listStock){

            this.scrollPane = scrollPane;
            this.listStock = listStock;

        }

        public void actionPerformed(ActionEvent evt){

            double quantity = Double.parseDouble(quantityTextField.getText());

            for(int k = 0; k < stockList.length; k++){

                if(company.equals(stockList[k].getName())){

                    stockList[k].setQuantity(stockList[k].getQuantity() + quantity);
                    prt.setProfit(prt.getProfit() - (quantity * stockList[k].getPrice()));
                    prt.setValue(prt.getProfit() + (stockList[k].getQuantity() * stockList[k].getPrice()));
                    if(!stockInfo.contains(stockList[k])){

                        stockInfo.add(stockList[k]);

                    }
                    frame2.remove(scrollPane);
                    frame2.remove(listStock);
                    frame2.dispose();
                    System.out.println(""+prt.getProfit());
                    sellbuynextday();
                }

            }
            buy.removeActionListener(this);



        }

    }

    public void sell(){



    }

    public void nextday(){



    }
    public static void main(String[] args){
        new Gui();
    }
}
