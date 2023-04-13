package vop.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import vop.Symbol;
import vop.broker.Broker;
import vop.broker.PriceUpdateCallbackInterface;
import vop.symbols.GOOG;
import vop.symbols.MSFT;

public class PrimaryController implements PriceUpdateCallbackInterface {
    Broker broker;
    Symbol symbol;
    @FXML
    Label stock_price, stock_ticker, stock_price_change;

    public void initialize() {
        this.broker = Broker.getBroker();
        this.symbol = new MSFT();
        stock_ticker.setText(symbol.getName());
        stock_price.setText(String.valueOf(symbol.priceAtTick(0)));
        new Thread(() -> {
            try {
                while (true) {
                    Platform.runLater(() -> priceUpdate(broker.getTicks()));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }).start();
    }

    @Override
    public void priceUpdate(int tick) {
        double price = symbol.priceAtTick(tick);
        float change = (float)price - Float.parseFloat(stock_price.getText().replace("$", ""));
        stock_price.setText("$" + price);
        if (change != 0) {
            stock_price_change.setText("Change: $" + change);
        }
        if (change > 0) {
            stock_price.setTextFill(Paint.valueOf("GREEN"));
        } else if (change < 0) {
            stock_price.setTextFill(Paint.valueOf("RED"));
        }
    }
}
