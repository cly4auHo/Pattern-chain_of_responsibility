package chain_of_lvl_responsibility;

public class ChainApp {

    public static void main(String[] args) {

        Logger sm = new SMSLogger(Level.ERROR);
        Logger fl = new FileLogger(Level.DEBUG);
        Logger el = new EmailLogger(Level.INFO);

        sm.setNext(fl);
        fl.setNext(el);

        sm.writeMessage("Godd", Level.INFO);
        sm.writeMessage("w8", Level.DEBUG);
        sm.writeMessage("Jopa", Level.ERROR);

    }
}
