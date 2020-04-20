package edu.umb.cs680.hw14;

class DrawerOpen implements State {

    protected static DrawerOpen instance = new DrawerOpen();

    private DrawerOpen() {}

    protected static DrawerOpen getInstance() {
        return instance;
    }

    public void openCloseButtonPushed() {
        DVDPlayer.close();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }

    public void playButtonPushed() {
        DVDPlayer.close();
        DVDPlayer.play();
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
    }

    public void stopButtonPushed() { }

    public String getDisplay() {
        return "Drawer is open.";
    }

}
