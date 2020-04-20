package edu.umb.cs680.hw11;

abstract class MulticastObserverBase
    extends ObserverBase {

    public void update (StockEvent event) {
        addReceivedStockEvent((StockEvent) event);        
    }

    public void update (DJIAEvent event) {
        addReceivedDJIAEvent((DJIAEvent) event);        
    }

}
