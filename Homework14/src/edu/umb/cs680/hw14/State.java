package edu.umb.cs680.hw14;

public interface State {

    void openCloseButtonPushed();

    void playButtonPushed();

    void stopButtonPushed();

    String getDisplay();

}
