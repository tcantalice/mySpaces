package br.ucsal.cli.commons;

public class Notify {

    private static final String ICON_WARNING = "/!\\";
    private static final String ICON_ERROR = "(X)";
    private static final String ICON_SUCCESS = "( OK )";

    private static Notify instance;

    private Notify(){}

    public static Notify getInstance(){
        if(instance == null)
            instance = new Notify();
        return instance;
    }

    public void plainMessage(String msg){
        this.drawNotifier(msg, "");
    }

    public void successMessage(String msg){
        this.drawNotifier(msg, ICON_SUCCESS);
    }

    public void warningMessage(Exception e){
        this.warningMessage(e.getMessage());
    }

    public void warningMessage(String msg){
        this.drawNotifier(msg, ICON_WARNING);
    }

    public void errorMessage(Exception e){
        this.errorMessage(e.getMessage());
    }

    public void errorMessage(String msg){
        this.drawNotifier(msg, ICON_ERROR);
    }


    // Base show notify

    private void drawNotifier(String msg, String icon){
        int lineSize = msg.length() + 5 + icon.length();
        System.out.println(drawLine(lineSize));
        System.out.println(String.format("| %s %s |", icon, msg));
        System.out.println(drawLine(lineSize));
    }

    private String drawLine(int size){
        StringBuffer line = new StringBuffer();
        for(int i = 0; i < size; i++){
            line.append('-');
        }
        return line.toString();
    }



}